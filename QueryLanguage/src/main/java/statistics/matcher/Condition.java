package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public abstract class Condition implements Matcher {

    private final String fieldName;
    protected final int value;

    public Condition(int value, String category) {
        this.fieldName = "get" + Character.toUpperCase(category.charAt(0)) + category.substring(1, category.length());
        this.value = value;
    }

    public int getPlayersValue(Player p) {
        try {
            Method method = p.getClass().getMethod(fieldName);
            return (Integer) method.invoke(p);

        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field " + fieldName.substring(3, fieldName.length()).toLowerCase());
        }

    }
}
