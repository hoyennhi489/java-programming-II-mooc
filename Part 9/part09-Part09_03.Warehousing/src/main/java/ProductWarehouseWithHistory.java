public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory history;

    public ProductWarehouseWithHistory(
            String productName,
            double capacity,
            double initialBalance) {

        super(productName, capacity);

        this.history = new ChangeHistory();

        super.addToWarehouse(initialBalance);
        this.history.add(this.getBalance());
    }

    public String history() {
        return history.toString();
    }

    @Override
    public void addToWarehouse(double amount) {

        super.addToWarehouse(amount);

        history.add(this.getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {

        double taken = super.takeFromWarehouse(amount);

        history.add(this.getBalance());

        return taken;
    }

    public void printAnalysis() {

        System.out.println("Product: " + this.getName());
        System.out.println("History: " + history);
        System.out.println("Largest amount of product: "
                + history.maxValue());
        System.out.println("Smallest amount of product: "
                + history.minValue());
        System.out.println("Average: " + history.average());
    }
}