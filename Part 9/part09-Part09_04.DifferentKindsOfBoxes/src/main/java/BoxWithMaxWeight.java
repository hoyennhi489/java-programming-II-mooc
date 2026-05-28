import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private ArrayList<Item> items;
    private int capacity;

    public BoxWithMaxWeight(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public void add(Item item) {
        if (this.totalWeight() + item.getWeight() <= this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }

    private int totalWeight() {
        int sum = 0;

        for (Item item : this.items) {
            sum += item.getWeight();
        }

        return sum;
    }
}