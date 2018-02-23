import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import java.util.ArrayList;

/**
 * Created by greg on 2/21/18.
 */
public class CenterStartScaleBotSwitchBot {
    public static ArrayList<Waypoint[]> PATH = new ArrayList<Waypoint[]>();
    static {
        PATH.add(new Waypoint[] {
            new Waypoint(.7, 0, Pathfinder.d2r(0)),
            new Waypoint(3,-2.1,Pathfinder.d2r(-45)),
            new Waypoint(6,-3.625,Pathfinder.d2r(0)),
            new Waypoint(7.5,-3.2,Pathfinder.d2r(45)),
            new Waypoint(7.7,-2.85,Pathfinder.d2r(90)),
            new Waypoint(6.7,-2.25,Pathfinder.d2r(180)),
            new Waypoint(5.3,-1.1,Pathfinder.d2r(190)),
        });

        PATH.add(new Waypoint[] {
            new Waypoint(5.3, -1.1, Pathfinder.d2r(10)),
            new Waypoint(5.9, -0.8, Pathfinder.d2r(45))
        });

        PATH.add(new Waypoint[] {
            new Waypoint(5.9, -0.8, Pathfinder.d2r(225)),
            new Waypoint(5.4, -2, Pathfinder.d2r(270)),
            new Waypoint(6, -3, Pathfinder.d2r(0)),
            new Waypoint(7.5, -2.5, Pathfinder.d2r(45)),
        });
    }
}
