package statistics.matcher;

import statistics.Player;

public class HasAtLeast extends Condition {

    public HasAtLeast(int value, String category) {
        super(value, category);
    }

    @Override
    public boolean matches(Player p) {
        return getPlayersValue(p) >= super.value;
    }
}
