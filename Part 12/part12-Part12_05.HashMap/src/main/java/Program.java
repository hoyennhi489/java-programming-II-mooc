import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> map = new HashMap<>();

        map.add("one", "first");
        map.add("two", "second");

        System.out.println(map.get("one"));
        System.out.println(map.get("two"));

        map.remove("one");

        System.out.println(map.get("one"));
    }
}