import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) {
                break;
            }

            System.out.print("Input the age recommendation: ");
            int age = Integer.valueOf(scanner.nextLine());

            books.add(new Book(name, age));
            System.out.println();
        }

        books.sort(
                Comparator.comparing(Book::getAgeRecommendation)
                          .thenComparing(Book::getName)
        );

        System.out.println();
        System.out.println(books.size() + " books in total.");
        System.out.println();
        System.out.println("Books:");

        books.forEach(book -> System.out.println(book));
    }
}