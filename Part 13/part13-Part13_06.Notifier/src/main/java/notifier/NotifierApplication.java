package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage window) {

        TextField textField = new TextField();
        Button button = new Button("Update");
        Label label = new Label();

        button.setOnAction(event -> {
            label.setText(textField.getText());
        });

        VBox layout = new VBox();

        layout.getChildren().add(textField);
        layout.getChildren().add(button);
        layout.getChildren().add(label);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }
}