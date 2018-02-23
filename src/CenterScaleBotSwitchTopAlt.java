import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import java.util.ArrayList;

/**
 * Created by greg on 2/21/18.
 */
public class CenterScaleBotSwitchTopAlt {
    public static ArrayList<Waypoint[]> PATH = new ArrayList<Waypoint[]>();
    static {
        PATH.add(new Waypoint[] {
            new Waypoint(.7, 0, Pathfinder.d2r(0)),
            new Waypoint(3,-2.1,Pathfinder.d2r(-45)),
            new Waypoint(5,-3.625,Pathfinder.d2r(0)),
            new Waypoint(7.5,-3.2,Pathfinder.d2r(45)),
            new Waypoint(7.7,-2.7,Pathfinder.d2r(90)),
            new Waypoint(7.0,-2.10,Pathfinder.d2r(180)),
            new Waypoint(6.2,-0.75,Pathfinder.d2r(90)),
            new Waypoint(5.3,1.05,Pathfinder.d2r(170)),
        });

        PATH.add(new Waypoint[] {
            new Waypoint(5.3, 1.05, Pathfinder.d2r(-10)),
            new Waypoint(6.2, 1.8, Pathfinder.d2r(90))
        });

        PATH.add(new Waypoint[] {
            new Waypoint(6.2, 1.8, Pathfinder.d2r(270)),
            new Waypoint(5.6, -1.6, Pathfinder.d2r(225)),
            new Waypoint(5.4, -2, Pathfinder.d2r(270)),
            new Waypoint(6, -2.5, Pathfinder.d2r(0)),
            new Waypoint(7.5, -2.5, Pathfinder.d2r(45)),
        });
    }
}
