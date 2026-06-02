public class MainProgram {

    public static void main(String[] args) {

        Checker checker = new Checker();

        System.out.println(checker.isDayOfWeek("tue"));
        System.out.println(checker.allVowels("aeio"));
        System.out.println(checker.timeOfDay("17:23:05"));
    }
}