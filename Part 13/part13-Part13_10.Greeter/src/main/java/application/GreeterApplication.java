package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage window) {

        VBox firstLayout = new VBox();

        Label instruction = new Label("Enter your name:");
        TextField nameField = new TextField();
        Button startButton = new Button("Start");

        firstLayout.getChildren().addAll(instruction, nameField, startButton);

        Scene firstView = new Scene(firstLayout, 300, 200);

        VBox secondLayout = new VBox();

        Label greeting = new Label();

        secondLayout.getChildren().add(greeting);

        Scene secondView = new Scene(secondLayout, 300, 200);

        startButton.setOnAction(event -> {
            greeting.setText("Welcome " + nameField.getText() + "!");
            window.setScene(secondView);
        });

        window.setScene(firstView);
        window.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}