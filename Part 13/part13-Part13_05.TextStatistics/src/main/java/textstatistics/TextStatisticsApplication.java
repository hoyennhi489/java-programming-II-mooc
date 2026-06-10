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
        layout.setCenter(textArea);

        HBox bottom = new HBox();

        bottom.getChildren().add(new Label("Letters: 0"));
        bottom.getChildren().add(new Label("Words: 0"));
        bottom.getChildren().add(new Label("The longest word is:"));

        layout.setBottom(bottom);

        Scene scene = new Scene(layout, 400, 300);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
}