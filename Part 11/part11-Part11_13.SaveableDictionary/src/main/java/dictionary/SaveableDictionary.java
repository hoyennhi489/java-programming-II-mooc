package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SaveableDictionary {

    private HashMap<String, String> words;
    private String file;

    public SaveableDictionary() {
        this.words = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.words = new HashMap<>();
        this.file = file;
    }

    public void add(String word, String translation) {
        if (this.words.containsKey(word) || this.words.containsKey(translation)) {
            return;
        }

        this.words.put(word, translation);
        this.words.put(translation, word);
    }

    public String translate(String word) {
        return this.words.get(word);
    }

    public void delete(String word) {
        String translation = this.words.get(word);

        if (translation == null) {
            return;
        }

        this.words.remove(word);
        this.words.remove(translation);
    }

    public boolean load() {
        try (Scanner fileReader = new Scanner(Paths.get(this.file))) {

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");

                this.add(parts[0], parts[1]);
            }

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean save() {
        try (PrintWriter writer = new PrintWriter(this.file)) {

            HashSet<String> printed = new HashSet<>();

            for (String word : this.words.keySet()) {
                String translation = this.words.get(word);

                if (!printed.contains(word) && !printed.contains(translation)) {
                    writer.println(word + ":" + translation);
                    printed.add(word);
                    printed.add(translation);
                }
            }

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}