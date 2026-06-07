package dictionary;

public class Main {

    public static void main(String[] args) {

        SaveableDictionary dictionary = new SaveableDictionary("words.txt");

        if (dictionary.load()) {
            System.out.println("Dictionary loaded!");
        }

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("monkey"));

        dictionary.add("tietokone", "computer");

        System.out.println(dictionary.translate("tietokone"));
        System.out.println(dictionary.translate("computer"));

        dictionary.delete("apina");

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("monkey"));

        if (dictionary.save()) {
            System.out.println("Dictionary saved!");
        }
    }
}