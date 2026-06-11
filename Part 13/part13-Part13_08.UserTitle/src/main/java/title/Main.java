package title;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a title:");
        String title = scanner.nextLine();

        UserTitle.title = title;
        UserTitle.launch(UserTitle.class);
    }
}