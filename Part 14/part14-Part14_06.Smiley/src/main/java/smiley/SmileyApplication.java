package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();

        Canvas canvas = new Canvas(300, 300);
        GraphicsContext painter = canvas.getGraphicsContext2D();

        // Background
        painter.setFill(Color.WHITE);
        painter.fillRect(0, 0, 300, 300);

        // Face
        painter.setStroke(Color.BLACK);
        painter.strokeOval(50, 50, 200, 200);

        // Eyes
        painter.fillOval(90, 100, 20, 20);
        painter.fillOval(190, 100, 20, 20);

        // Smile
        painter.strokeArc(100, 120, 100, 80, 180, 180, javafx.scene.shape.ArcType.OPEN);

        layout.setCenter(canvas);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }
}