package title;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserTitle extends Application {

    public static String title;

    @Override
    public void start(Stage window) {
        window.setTitle(title);
        window.show();
    }
}