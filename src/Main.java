import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

// 260
// 1.9292 pixels per x inch
//1.8096 pixels per y inch


/**
 * Created by greg on 2/28/17.
 */
public class Main extends JComponent{
    private static final double scale = 121.5;
    private static double time = 0.0;
    private static double maxVel = Integer.MIN_VALUE;

    private static class Line{
        final int x1;
        final int y1;
        final int x2;
        final int y2;
        final Color color;

        public Line(int x1, int y1, int x2, int y2, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
        }
    }

    private static class Text{
        final int x;
        final int y;
        final String text;

        public Text(int x, int y, String text) {
            this.x = x;
            this.y = y;
            this.text = text;
        }
    }

    public Main() {
//        for(int i = 0; i < 100; i++) {
//            lines.add(new Line(i*10, 300, i*10, 400, Color.GREEN));
//            lines.add(new Line(0, i*10, 100, i*10, Color.GREEN));
//        }
    }

    private final LinkedList<Line> lines = new LinkedList<Line>();
    private final LinkedList<Point> points = new LinkedList<Point>();
    private final LinkedList<Text> times = new LinkedList<>();

    public void addLine(int x1, int x2, int x3, int x4) {
        addLine(x1, x2, x3, x4, Color.black);
    }

    public void addLine(int x1, int x2, int x3, int x4, Color color) {
        lines.add(new Line(x1,x2,x3,x4, color));
        repaint();
    }

    public void addText(String text, int x, int y) {
        times.add(new Text(x, y, text));
        repaint();
    }

    public void addDot(int x, int y) {
        points.add(new Point(x,y));
    }

    public void clearLines() {
        lines.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D)graphics;
        try {
            BufferedImage img = ImageIO.read(new File("./field.png"));
            g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.setStroke(new BasicStroke(2));

        for (Line line : lines) {
            g.setColor(line.color);
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
        for (Point point : points) {
            g.setColor(Color.BLACK);
            g.drawOval(point.x-3, point.y-3,6,6);
        }

        for (int i = 0; i < times.size(); i++) {
            Text time = times.get(i);
            int x = time.x;
            int y = time.y;
            while(checkForText(i, x, y)) {
                y -= 20;
            }
            g.setColor(Color.BLACK);
            g.drawString(time.text, x, y);
        }
    }

    public boolean checkForText(int afterIndex, int x, int y) {
        for (int i = times.size() - 1; i > afterIndex; i--) {
            Text time = times.get(i);
            int xDif = Math.abs(time.x - x);
            int yDif = Math.abs(time.y - y);
            if(yDif < 20 && xDif < 100) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_QUINTIC, Trajectory.Config.SAMPLES_HIGH, 0.01, 2.0, 4.0, 50.0);
        double wheelbase_width = .694; //29.25/12;

        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final Main comp = new Main();
        comp.setPreferredSize(new Dimension(1250, 1012));
        testFrame.getContentPane().add(comp, BorderLayout.CENTER);

//        WaypointTable waypointTable = new WaypointTable();
//        JTable table = new JTable(waypointTable);
//        testFrame.getContentPane().add(table, BorderLayout.LINE_END);
//
//        JButton testButton = new JButton("Add Row");
//        testFrame.getContentPane().add(testButton, BorderLayout.PAGE_START);
//        testButton.addActionListener(e -> {
//            waypointTable.addRow(new Double[]{0.0, 0.0, 0.0});
//            table.repaint();
//        });

        for(Waypoint[] path : FourTotePlatform.PATH) {
            Trajectory traj = Pathfinder.generate(path, config);
            TankModifier tank = new TankModifier(traj);
            tank.modify(wheelbase_width);
//            drawTrajectory(comp, tank.getLeftTrajectory(), Color.BLUE, false);
//            drawTrajectory(comp, tank.getRightTrajectory(), Color.RED, false);
            drawTrajectory(comp, traj, Color.PINK, true);
        }

        testFrame.pack();
        testFrame.setVisible(true);

        System.out.println((time));
        System.out.println(maxVel);
    }

    public static void drawTrajectory(Main comp, Trajectory trajectory, Color color, boolean count) {
        for (int i = 1; i < trajectory.length(); i++) {
            Trajectory.Segment prevSeg = trajectory.get(i-1);
            Trajectory.Segment seg = trajectory.get(i);

            if(prevSeg.velocity > maxVel) {
                maxVel = prevSeg.velocity;
            } else if (prevSeg.velocity * -1 > maxVel) {
                maxVel = prevSeg.velocity * -1;
            }

            if(count) time += prevSeg.dt;

            int x1 = (int) (prevSeg.x * scale);
            int x2 = (int) (seg.x * scale);
            int y1 = (int) -(prevSeg.y * scale) + 506;
            int y2 = (int) -(seg.y * scale) + 506;

            int textX = x1;
            int textY = y1+20;

//            if(i == 1) comp.addDot(x1, y1);
            if(count && Math.round(time*100) % 50 == 0) {
                comp.addDot(x1, y1);
            }
//            if(count && (i == trajectory.length() / 2 || /*i == trajectory.length() / 4 ||*/ i == trajectory.length() - 1 )) comp.addText(Double.toString(Math.round(time*100)/100.0), textX, textY);

            comp.addLine(x1, y1, x2, y2, color);
        }

    }
}