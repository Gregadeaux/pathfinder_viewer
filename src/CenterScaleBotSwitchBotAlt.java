import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

import java.util.ArrayList;

/**
 * Created by greg on 2/21/18.
 */
public class CenterScaleBotSwitchBotAlt {
    public static ArrayList<Waypoint[]> PATH = new ArrayList<Waypoint[]>();
    static {
        PATH.add(new Waypoint[] {
            new Waypoint(.7, 0, Pathfinder.d2r(0)),
            new Waypoint(3,-2.1,Pathfinder.d2r(-45)),
            new Waypoint(6,-3.625,Pathfinder.d2r(0)),
            new Waypoint(7.2,-3.2,Pathfinder.d2r(45)),
            new Waypoint(7.5,-2.75,Pathfinder.d2r(90)),
            new Waypoint(6.5,-2.0,Pathfinder.d2r(180)),
            new Waypoint(5.3,-1.1,Pathfinder.d2r(190)),
        });

        PATH.add(new Waypoint[] {
            new Waypoint(5.3, -1.1, Pathfinder.d2r(10)),
            new Waypoint(6.0, -0.4, Pathfinder.d2r(180))
        });

        PATH.add(new Waypoint[] {
            new Waypoint(6.0, -0.4, Pathfinder.d2r(180)),
            new Waypoint(5.3, -0.4, Pathfinder.d2r(180))
        });

        PATH.add(new Waypoint[]{
            new Waypoint(5.3, -0.4, Pathfinder.d2r(180)),
            new Waypoint(6.2, -1.4, Pathfinder.d2r(90)),
            new Waypoint(6.7, -2.2, Pathfinder.d2r(180)),
            new Waypoint(7.0, -2.9, Pathfinder.d2r(45))
        });

        PATH.add(new Waypoint[] {
            new Waypoint(7.0, -2.9, Pathfinder.d2r(45)),
            new Waypoint(6.7, -2.2, Pathfinder.d2r(180)),
            new Waypoint(5.3, -1.8, Pathfinder.d2r(180)),
        });

        PATH.add(new Waypoint[] {
            new Waypoint(5.3, -1.8, Pathfinder.d2r(180)),
            new Waypoint(6.7, -2.2, Pathfinder.d2r(180)),
            new Waypoint(7.0, -2.9, Pathfinder.d2r(45)),
        });
    }
}
