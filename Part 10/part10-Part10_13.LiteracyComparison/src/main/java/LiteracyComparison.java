import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;

public class LiteracyComparison {

    public static void main(String[] args) {

        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .sorted(Comparator.comparing(parts -> Double.valueOf(parts[5])))
                    .forEach(parts -> System.out.println(
                            parts[3].trim() + " (" + parts[4].trim() + "), "
                            + parts[2].trim().replace(" (%)", "") + ", "
                            + parts[5].trim()
                    ));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}