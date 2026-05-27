import java.util.Objects;

public class LicensePlate {

    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals(Object object) {

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        if (this == object) {
            return true;
        }

        LicensePlate compared = (LicensePlate) object;

        return this.liNumber.equals(compared.liNumber)
                && this.country.equals(compared.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liNumber, country);
    }
}