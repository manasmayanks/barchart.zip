public class Bar implements Comparable<Bar> {
    private final String name;
    private final String category;
    private final int value;

    public Bar(String name, int value, String category) {
        if (name == null || category == null || value < 0)
            throw new IllegalArgumentException("Invalid bar parameters");
        this.name = name;
        this.value = value;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getValue() {
        return value;
    }

    public int compareTo(Bar that) {
        return Integer.compare(this.value, that.value);
    }

    public String toString() {
        return name + " (" + category + ") " + value;
    }
}
