package statistics;

import statistics.matcher.*;
import statistics.matcher.condition.*;
import statistics.matcher.logic.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

//        Matcher m = new Or(new HasAtLeast(40, "goals"),
//                new HasAtLeast(60, "assists"),
//                new HasAtLeast(85, "points"),
//                new PlaysIn("EDM")
//        );

        QueryBuilder qb = new QueryBuilder();

//        Matcher m = qb.
//                playsIn("NYR").
//                hasAtLeast(15, "goals").
//                hasFewerThan(25, "assists").
//                query();
        
        Matcher m = qb.oneOf(
                        qb.playsIn("PHI")
                             .hasAtLeast(10, "goals")
                             .hasFewerThan(20, "assists").query(),
 
                        qb.playsIn("EDM")
                             .hasAtLeast(60, "points").query()
                       ).query();
        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
