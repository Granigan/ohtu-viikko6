package statistics.matcher;

import statistics.matcher.condition.*;
import statistics.matcher.logic.*;

public class QueryBuilder {
    Matcher query;

    public QueryBuilder() {
        query = new All();
    }

    public Matcher query() {
        Matcher finishedQuery = query;
        query = new All();
        return finishedQuery;
    }
    
    public QueryBuilder oneOf(Matcher... queries) {
        query = new And(query, new Or(queries));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        query = new And(query, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        query = new And(query, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        query = new And(query, new HasFewerThan(value, category));
        return this;
    }
    
}
