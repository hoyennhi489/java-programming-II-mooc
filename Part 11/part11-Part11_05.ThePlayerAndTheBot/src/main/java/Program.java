import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = new Player("Anna");
        player.printName();
        player.play();

        Bot bot = new Bot("Robot");
        bot.play();
    }
}