import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import java.util.ArrayList;

/**
 * Created by greg on 2/21/18.
 */
public class FourTotePlatform {
    public static ArrayList<Waypoint[]> PATH = new ArrayList<Waypoint[]>();
    public static ArrayList<PrintPos> PRINT_POSITIONS = new ArrayList<PrintPos>();
    static {
        PATH.add(new Waypoint[] {
            new Waypoint(.7, -.1, Pathfinder.d2r(0)),
            new Waypoint(3,-2.1,Pathfinder.d2r(-45)),
            new Waypoint(6,-3.625,Pathfinder.d2r(0)),
            new Waypoint(7.2,-3.2,Pathfinder.d2r(45)),
            new Waypoint(7.5,-2.75,Pathfinder.d2r(90)),
            new Waypoint(6.8,-1.95,Pathfinder.d2r(155)),
            new Waypoint(5.3,-1.1,Pathfinder.d2r(190)),
        });

        PATH.add(new Waypoint[] {
            new Waypoint(5.3, -1.1, Pathfinder.d2r(10)),
            new Waypoint(6.2, -0.4, Pathfinder.d2r(180))
        });

        PATH.add(new Waypoint[]{
            new Waypoint(6.2, -0.4, Pathfinder.d2r(180)),
            new Waypoint(5.3, -0.4, Pathfinder.d2r(180))
        });

        PATH.add(new Waypoint[]{
            new Waypoint(5.3, -0.4, Pathfinder.d2r(180)),
            new Waypoint(6.9, -2.2, Pathfinder.d2r(315)),
            new Waypoint(7.0, -2.9, Pathfinder.d2r(45))
        });

        PATH.add(new Waypoint[]{
            new Waypoint(7.0, -2.9, Pathfinder.d2r(45)),
            new Waypoint(6.8, -2.05, Pathfinder.d2r(135)),
            new Waypoint(5.3, -1.8, Pathfinder.d2r(180)),
        });

        PATH.add(new Waypoint[] {
            new Waypoint(5.3, -1.8, Pathfinder.d2r(180)),
                new Waypoint(6.8, -2.05, Pathfinder.d2r(135)),
            new Waypoint(7.0, -2.9, Pathfinder.d2r(45)),
        });
    }
}
