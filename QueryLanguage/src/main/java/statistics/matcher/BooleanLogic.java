package statistics.matcher;

import statistics.Player;

public class BooleanLogic implements Matcher{
    protected final Matcher[] matchers;

    public BooleanLogic(Matcher... matchers) {
        this.matchers = matchers;
    }
    
    
    @Override
    public boolean matches(Player p) {
        throw new UnsupportedOperationException("Super class BooleanLogic should not run matches()."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
