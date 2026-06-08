public class Hideout<T> {

    private T hidden;

    public Hideout() {
        this.hidden = null;
    }

    public void putIntoHideout(T toHide) {
        this.hidden = toHide;
    }

    public T takeFromHideout() {
        T object = this.hidden;
        this.hidden = null;
        return object;
    }

    public boolean isInHideout() {
        return this.hidden != null;
    }
}