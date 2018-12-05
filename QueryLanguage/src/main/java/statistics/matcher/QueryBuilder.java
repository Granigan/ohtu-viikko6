package statistics.matcher;

import statistics.matcher.condition.HasAtLeast;
import statistics.matcher.condition.HasFewerThan;
import statistics.matcher.logic.And;

public class QueryBuilder {
    Matcher query;

    public QueryBuilder() {
        query = new All();
    }

    public QueryBuilder(Matcher query) {
         this.query= query;
    }
    
    public Matcher query() {
        return query;
    }
    
    public QueryBuilder playsIn(String team) {
        this.query = new And(query, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.query = new And(query, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.query = new And(query, new HasFewerThan(value, category));
        return this;
    }
    
    
}
