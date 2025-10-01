package mock;

public record Identifier(String namespace, String path) {

    public static Identifier tryParse(String id) {
        String[] parts = id.split(":");
        return new Identifier(parts[0], parts[1]);
    }

    @Override
    public String toString() {
        return namespace + ":" + path;
    }
}
