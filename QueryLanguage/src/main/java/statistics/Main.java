package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

//        Matcher m = new Or(new HasAtLeast(40, "goals"),
//                new HasAtLeast(60, "assists"),
//                new HasAtLeast(85, "points")
//        );

        QueryBuilder query = new QueryBuilder();
        Matcher m = query.
                playsIn("NYR").
                hasAtLeast(15, "goals").
                hasFewerThan(25, "assists").
                query();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
