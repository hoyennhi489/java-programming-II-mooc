import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = new List<>();

        list.add("Hello");
        list.add("World");

        System.out.println(list.size());
        System.out.println(list.contains("Hello"));
        System.out.println(list.value(0));

        list.remove("Hello");

        System.out.println(list.size());
    }
}