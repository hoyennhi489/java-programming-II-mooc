public class List<T> {

    private T[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(T value) {
        if (this.firstFreeIndex == this.values.length) {
            grow();
        }

        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    private void grow() {
        int newSize = this.values.length + this.values.length / 2;

        T[] newArray = (T[]) new Object[newSize];

        for (int i = 0; i < this.values.length; i++) {
            newArray[i] = this.values[i];
        }

        this.values = newArray;
    }

    public boolean contains(T value) {
        return indexOfValue(value) >= 0;
    }

    public int size() {
        return this.firstFreeIndex;
    }

    public T value(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return this.values[index];
    }

    public int indexOfValue(T value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    public void remove(T value) {
        int index = indexOfValue(value);

        if (index < 0) {
            return;
        }

        moveToTheLeft(index);
        this.firstFreeIndex--;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }
}