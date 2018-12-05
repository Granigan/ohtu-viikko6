package statistics.matcher.logic;

import statistics.Player;
import statistics.matcher.Matcher;

public class And extends BooleanLogic{

    public And(Matcher... matchers) {
        super(matchers);
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : super.matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }
        return true;
    }

}
