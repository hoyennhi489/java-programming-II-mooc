import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        University university = new University("Helsinki University");

        Student s1 = new Student(1, "Anna", university);
        Student s2 = new Student(2, "John", university);
    }
}