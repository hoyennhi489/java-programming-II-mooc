package application;

public class Program {

    public static void main(String[] args) {

        Sensor kumpula = new TemperatureSensor();
        Sensor kaisaniemi = new TemperatureSensor();
        Sensor airport = new TemperatureSensor();

        AverageSensor helsinkiRegion = new AverageSensor();

        helsinkiRegion.addSensor(kumpula);
        helsinkiRegion.addSensor(kaisaniemi);
        helsinkiRegion.addSensor(airport);

        helsinkiRegion.setOn();

        System.out.println(helsinkiRegion.read());
        System.out.println(helsinkiRegion.read());
        System.out.println(helsinkiRegion.read());

        System.out.println("readings: " + helsinkiRegion.readings());
    }
}