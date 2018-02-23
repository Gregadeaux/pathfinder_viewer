import jaci.pathfinder.Waypoint;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.LinkedList;

/**
 * Created by greg on 2/23/18.
 */
public class WaypointTable extends DefaultTableModel {

    private LinkedList<Waypoint> waypoints;
    private final String[] columns = { "X", "Y", "Angle" };

    public WaypointTable() {
        waypoints = new LinkedList<>();
    }

    @Override
    public void addRow(Object[] rowData) {
        System.out.println(rowData[0] + " " + rowData[1] + " " + rowData[2] + " " );
        waypoints.add(new Waypoint((double)rowData[0], (double)rowData[1], (double)rowData[2]));
    }

    @Override
    public int getRowCount() {
        if(waypoints == null) return 0;
        return waypoints.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        System.out.println(rowIndex + ": " );
        switch(columnIndex) {
            case 0:
                System.out.println("X: " + waypoints.get(rowIndex).x);
                return waypoints.get(rowIndex).x;
            case 1:
                System.out.println("Y: " + waypoints.get(rowIndex).y);
                return waypoints.get(rowIndex).y;
            case 2:
                System.out.println("ANGLE: " + waypoints.get(rowIndex).angle);
                return waypoints.get(rowIndex).angle;
            default:
                return null;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        Waypoint waypoint = this.waypoints.get(row);
        switch(col) {
            case 0:
                waypoint.x = Double.parseDouble((String)value);
                break;
            case 1:
                waypoint.y = Double.parseDouble((String)value);
                break;
            case 2:
                waypoint.angle = Double.parseDouble((String)value);
                break;
            default:
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
