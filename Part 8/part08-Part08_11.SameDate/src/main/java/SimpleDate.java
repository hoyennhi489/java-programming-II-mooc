public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    @Override
    public boolean equals(Object object) {

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        if (this == object) {
            return true;
        }

        SimpleDate compared = (SimpleDate) object;

        return this.day == compared.day
                && this.month == compared.month
                && this.year == compared.year;
    }
}