import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Person person = new Person(
                "Anna",
                "Helsinki"
        );

        person.save();
        person.load("New address");
        person.delete();
    }
}