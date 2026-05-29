import java.util.ArrayList;

public class Box implements Packable {

    private ArrayList<Packable> items;
    private double capacity;

    public Box(double capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Packable item) {
        if (this.weight() + item.weight() <= this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public double weight() {
        double sum = 0;

        for (Packable item : this.items) {
            sum += item.weight();
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Box: " + this.items.size()
                + " items, total weight " + this.weight() + " kg";
    }
}