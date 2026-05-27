import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {

        if (registry.containsKey(licensePlate)) {
            return false;
        }

        registry.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        return registry.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {

        if (!registry.containsKey(licensePlate)) {
            return false;
        }

        registry.remove(licensePlate);
        return true;
    }

    public void printLicensePlates() {

        for (LicensePlate plate : registry.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {

        ArrayList<String> printed = new ArrayList<>();

        for (String owner : registry.values()) {

            if (!printed.contains(owner)) {
                System.out.println(owner);
                printed.add(owner);
            }
        }
    }
}