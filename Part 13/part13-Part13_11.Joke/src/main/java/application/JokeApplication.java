package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();

        Label content = new Label("What do you call a bear with no teeth?");
        layout.setCenter(content);


        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        HBox menu = new HBox();
        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);

        layout.setTop(menu);

        jokeButton.setOnAction(event -> {
            content.setText("What do you call a bear with no teeth?");
        });

        answerButton.setOnAction(event -> {
            content.setText("A gummy bear.");
        });

        explanationButton.setOnAction(event -> {
            content.setText("A gummy bear is a candy, and a bear with no teeth cannot bite.");
        });

        Scene scene = new Scene(layout, 400, 200);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}