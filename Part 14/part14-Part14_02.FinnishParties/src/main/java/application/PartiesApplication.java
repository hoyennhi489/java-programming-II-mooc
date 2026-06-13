package application;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage window) {

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);

        try {
            List<String> rows = Files.readAllLines(Paths.get("partiesdata.tsv"));

            // Bỏ dòng tiêu đề
            for (int row = 1; row < rows.size(); row++) {

                String[] parts = rows.get(row).split("\t");

                XYChart.Series<Number, Number> data = new XYChart.Series<>();
                data.setName(parts[0]);

                int year = 1968;

                for (int i = 1; i < parts.length; i++) {

                    if (!parts[i].equals("-")) {
                        data.getData().add(
                                new XYChart.Data<>(
                                        year,
                                        Double.valueOf(parts[i])
                                )
                        );
                    }

                    year += 4;
                }

                chart.getData().add(data);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Scene scene = new Scene(chart, 800, 600);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
}