package FlightControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Airplane> airplanes = new HashMap<>();
        ArrayList<Flight> flights = new ArrayList<>();

        System.out.println("Airport Asset Control");

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");

            String command = scanner.nextLine();

            if (command.equals("x")) {
                break;
            }

            if (command.equals("1")) {
                System.out.print("Give the airplane id: ");
                String id = scanner.nextLine();

                System.out.print("Give the airplane capacity: ");
                int capacity = Integer.valueOf(scanner.nextLine());

                airplanes.put(id, new Airplane(id, capacity));
            }

            if (command.equals("2")) {
                System.out.print("Give the airplane id: ");
                String id = scanner.nextLine();

                System.out.print("Give the departure airport id: ");
                String departure = scanner.nextLine();

                System.out.print("Give the target airport id: ");
                String target = scanner.nextLine();

                flights.add(new Flight(airplanes.get(id), departure, target));
            }
        }

        System.out.println();
        System.out.println("Flight Control");

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");

            String command = scanner.nextLine();

            if (command.equals("x")) {
                break;
            }

            if (command.equals("1")) {
                for (Airplane airplane : airplanes.values()) {
                    System.out.println(airplane);
                }
            }

            if (command.equals("2")) {
                for (Flight flight : flights) {
                    System.out.println(flight);
                }
                System.out.println();
            }

            if (command.equals("3")) {
                System.out.print("Give the airplane id: ");
                String id = scanner.nextLine();

                System.out.println(airplanes.get(id));
                System.out.println();
            }
        }
    }
}