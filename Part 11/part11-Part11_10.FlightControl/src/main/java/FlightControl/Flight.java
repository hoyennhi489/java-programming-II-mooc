package FlightControl;

public class Flight {

    private Airplane airplane;
    private String departure;
    private String target;

    public Flight(Airplane airplane, String departure, String target) {
        this.airplane = airplane;
        this.departure = departure;
        this.target = target;
    }

    @Override
    public String toString() {
        return this.airplane + " (" + this.departure + "-" + this.target + ")";
    }
}