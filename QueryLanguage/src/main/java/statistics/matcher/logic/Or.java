package statistics.matcher.logic;

import statistics.Player;
import statistics.matcher.Matcher;

public class Or extends BooleanLogic {

    public Or(Matcher... matchers) {
        super(matchers);
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher m : super.matchers) {
            if (m.matches(p)) {
                return true;
            }
        }
        return false;
    }

}
