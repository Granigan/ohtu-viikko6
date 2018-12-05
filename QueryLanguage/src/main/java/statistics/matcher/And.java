package statistics.matcher;

import statistics.Player;

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
