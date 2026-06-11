package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {

    private HashMap<String, String> words;
    private ArrayList<String> wordList;
    private Random random;
    private String currentWord;

    @Override
    public void start(Stage window) {

        this.words = new HashMap<>();
        this.wordList = new ArrayList<>();
        this.random = new Random();

        BorderPane layout = new BorderPane();

        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        VBox menu = new VBox();
        menu.getChildren().addAll(enterButton, practiceButton);

        layout.setTop(menu);

        VBox enterView = new VBox();

        TextField wordField = new TextField();
        TextField translationField = new TextField();
        Button addButton = new Button("Add the word pair");
        Label addMessage = new Label();

        enterView.getChildren().addAll(
                new Label("Word:"),
                wordField,
                new Label("Translation:"),
                translationField,
                addButton,
                addMessage
        );

        VBox practiceView = new VBox();

        Label wordToTranslate = new Label("No words yet");
        TextField answerField = new TextField();
        Button checkButton = new Button("Check");
        Label resultLabel = new Label();

        practiceView.getChildren().addAll(
                wordToTranslate,
                answerField,
                checkButton,
                resultLabel
        );

        addButton.setOnAction(event -> {
            String word = wordField.getText();
            String translation = translationField.getText();

            if (!word.isEmpty() && !translation.isEmpty()) {
                words.put(word, translation);

                if (!wordList.contains(word)) {
                    wordList.add(word);
                }

                wordField.clear();
                translationField.clear();
                addMessage.setText("Word pair added!");
            }
        });

        enterButton.setOnAction(event -> {
            layout.setCenter(enterView);
        });

        practiceButton.setOnAction(event -> {
            if (wordList.isEmpty()) {
                wordToTranslate.setText("No words yet");
                resultLabel.setText("");
                layout.setCenter(practiceView);
                return;
            }

            currentWord = wordList.get(random.nextInt(wordList.size()));
            wordToTranslate.setText(currentWord);
            answerField.clear();
            resultLabel.setText("");

            layout.setCenter(practiceView);
        });

        checkButton.setOnAction(event -> {
            if (currentWord == null) {
                return;
            }

            String answer = answerField.getText();
            String correctAnswer = words.get(currentWord);

            if (answer.equals(correctAnswer)) {
                resultLabel.setText("Correct!");
            } else {
                resultLabel.setText("Incorrect! The correct translation is: " + correctAnswer);
            }

            currentWord = wordList.get(random.nextInt(wordList.size()));
            wordToTranslate.setText(currentWord);
            answerField.clear();
        });

        layout.setCenter(enterView);

        Scene scene = new Scene(layout, 400, 300);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}