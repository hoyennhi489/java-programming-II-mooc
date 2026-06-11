package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    @Override
    public void start(Stage window) {


        BorderPane firstLayout = new BorderPane();
        firstLayout.setTop(new Label("First view!"));

        Button toSecond = new Button("To the second view!");
        firstLayout.setCenter(toSecond);

        Scene firstView = new Scene(firstLayout, 300, 200);


        VBox secondLayout = new VBox();

        Button toThird = new Button("To the third view!");
        secondLayout.getChildren().add(toThird);
        secondLayout.getChildren().add(new Label("Second view!"));

        Scene secondView = new Scene(secondLayout, 300, 200);


        GridPane thirdLayout = new GridPane();

        thirdLayout.add(new Label("Third view!"), 0, 0);

        Button toFirst = new Button("To the first view!");
        thirdLayout.add(toFirst, 1, 1);

        Scene thirdView = new Scene(thirdLayout, 300, 200);


        toSecond.setOnAction(event -> {
            window.setScene(secondView);
        });

        toThird.setOnAction(event -> {
            window.setScene(thirdView);
        });

        toFirst.setOnAction(event -> {
            window.setScene(firstView);
        });

        window.setScene(firstView);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}