import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book book = new Book(
                "Clean Code",
                "Robert Martin",
                464
        );

        Plane plane = new Plane(
                "OH-LXA",
                "Airbus A320",
                2003
        );
    }
}