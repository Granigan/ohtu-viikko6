package statistics.matcher.logic;

import statistics.Player;
import statistics.matcher.Matcher;

public class Not extends BooleanLogic{

    public Not(Matcher... matchers) {
        super(matchers);
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher m : super.matchers) {
            if (m.matches(p)) {
                return false;
            }
        }
        return true;
    }

}
