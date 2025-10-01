package mock;

public record Loyalty(int level, Type type) {

    public enum Type {
        REJECT,
        NEUTRAL,
        COMPANION,
        PILOT,
        OWNER
    }
}
