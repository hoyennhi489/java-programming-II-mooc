package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();

        TextArea textArea = new TextArea();

        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longest = new Label("The longest word is:");

        HBox bottom = new HBox();
        bottom.getChildren().add(letters);
        bottom.getChildren().add(words);
        bottom.getChildren().add(longest);

        layout.setCenter(textArea);
        layout.setBottom(bottom);

        textArea.textProperty().addListener((change, oldValue, newValue) -> {

            letters.setText("Letters: " + newValue.length());

            String[] parts = newValue.trim().split("\\s+");

            if (newValue.trim().isEmpty()) {
                words.setText("Words: 0");
                longest.setText("The longest word is:");
                return;
            }

            words.setText("Words: " + parts.length);

            String longestWord = "";

            for (String word : parts) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

            longest.setText("The longest word is: " + longestWord);
        });

        Scene scene = new Scene(layout, 400, 300);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
}