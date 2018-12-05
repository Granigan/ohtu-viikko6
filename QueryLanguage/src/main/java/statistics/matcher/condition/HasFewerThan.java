package statistics.matcher.condition;

import java.lang.reflect.Method;
import statistics.Player;

public class HasFewerThan extends Condition {

    public HasFewerThan(int value, String category) {
        super(value, category);
    }

    @Override
    public boolean matches(Player p) {
        return getPlayersValue(p) < super.value;
    }

}
