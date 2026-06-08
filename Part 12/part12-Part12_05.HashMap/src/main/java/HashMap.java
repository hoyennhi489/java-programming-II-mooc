import java.util.ArrayList;

public class HashMap<K, V> {

    private ArrayList<Pair<K, V>>[] values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new ArrayList[32];
        this.firstFreeIndex = 0;
    }

    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);

        if (this.values[hashValue] == null) {
            return null;
        }

        for (Pair<K, V> pair : this.values[hashValue]) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }

        return null;
    }

    public void add(K key, V value) {
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);

        for (Pair<K, V> pair : valuesAtIndex) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value);
                return;
            }
        }

        valuesAtIndex.add(new Pair<>(key, value));
        this.firstFreeIndex++;

        if (1.0 * this.firstFreeIndex / this.values.length > 0.75) {
            grow();
        }
    }

    public V remove(K key) {
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);

        for (int i = 0; i < valuesAtIndex.size(); i++) {
            Pair<K, V> pair = valuesAtIndex.get(i);

            if (pair.getKey().equals(key)) {
                valuesAtIndex.remove(i);
                this.firstFreeIndex--;
                return pair.getValue();
            }
        }

        return null;
    }

    private ArrayList<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);

        if (this.values[hashValue] == null) {
            this.values[hashValue] = new ArrayList<>();
        }

        return this.values[hashValue];
    }

    private void grow() {
        ArrayList<Pair<K, V>>[] newArray = new ArrayList[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            copy(newArray, i);
        }

        this.values = newArray;
    }

    private void copy(ArrayList<Pair<K, V>>[] newArray, int fromIdx) {
        if (this.values[fromIdx] == null) {
            return;
        }

        for (Pair<K, V> pair : this.values[fromIdx]) {
            int hashValue = Math.abs(pair.getKey().hashCode() % newArray.length);

            if (newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }

            newArray[hashValue].add(pair);
        }
    }
}