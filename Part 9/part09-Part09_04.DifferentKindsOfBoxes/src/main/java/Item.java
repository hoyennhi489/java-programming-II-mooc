import java.util.Objects;

public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        if (this == object) {
            return true;
        }

        Item compared = (Item) object;

        return this.name.equals(compared.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}