package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage window) {

        Label label = new Label("Label");
        Button button = new Button("Button");

        VBox layout = new VBox();

        layout.getChildren().add(label);
        layout.getChildren().add(button);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }
}