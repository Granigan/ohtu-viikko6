package statistics.matcher;

import statistics.Player;

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
