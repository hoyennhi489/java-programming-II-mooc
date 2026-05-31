import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> numbers = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            numbers.add(input);
        }

        System.out.println();
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");

        String choice = scanner.nextLine();

        if (choice.equals("n")) {

            double average = numbers.stream()
                    .mapToInt(Integer::valueOf)
                    .filter(number -> number < 0)
                    .average()
                    .getAsDouble();

            System.out.println("Average of the negative numbers: " + average);

        } else {

            double average = numbers.stream()
                    .mapToInt(Integer::valueOf)
                    .filter(number -> number > 0)
                    .average()
                    .getAsDouble();

            System.out.println("Average of the positive numbers: " + average);
        }
    }
}