import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Show show = new Show(
                "Avengers",
                "18:00"
        );

        Ticket ticket1 = new Ticket(
                10,
                12345,
                show
        );

        Ticket ticket2 = new Ticket(
                11,
                12346,
                show
        );
    }
}