package statistics.matcher.logic;

import statistics.Player;
import statistics.matcher.Matcher;

public class BooleanLogic implements Matcher {

    protected final Matcher[] matchers;

    public BooleanLogic(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        throw new UnsupportedOperationException("Super class BooleanLogic should never run matches().");
    }

}
