import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import java.util.ArrayList;

/**
 * Created by greg on 2/21/18.
 */
public class CenterStartScaleTop {
    public static ArrayList<Waypoint[]> PATH = new ArrayList<Waypoint[]>();
    static {
        PATH.add(new Waypoint[] {
            new Waypoint(0, 0, Pathfinder.d2r(0)),
            new Waypoint(2.625,2,Pathfinder.d2r(45)),
            new Waypoint(6,3.625,Pathfinder.d2r(0)),
            new Waypoint(7.5,3.2,Pathfinder.d2r(-45)),
            new Waypoint(7.7,2.85,Pathfinder.d2r(-90)),
            new Waypoint(6.5,2.25,Pathfinder.d2r(-180)),
            new Waypoint(5.3,1.9,Pathfinder.d2r(-135)),
        });
    }
}
