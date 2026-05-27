import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> storage;

    public StorageFacility() {
        this.storage = new HashMap<>();
    }

    public void add(String unit, String item) {

        if (!storage.containsKey(unit)) {
            storage.put(unit, new ArrayList<>());
        }

        storage.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {

        if (!storage.containsKey(storageUnit)) {
            return new ArrayList<>();
        }

        return storage.get(storageUnit);
    }

    public void remove(String storageUnit, String item) {

        if (!storage.containsKey(storageUnit)) {
            return;
        }

        storage.get(storageUnit).remove(item);

        if (storage.get(storageUnit).isEmpty()) {
            storage.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {

        return new ArrayList<>(storage.keySet());
    }
}