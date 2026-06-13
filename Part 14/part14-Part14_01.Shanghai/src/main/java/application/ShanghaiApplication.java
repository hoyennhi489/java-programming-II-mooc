package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    @Override
    public void start(Stage window) {

        NumberAxis xAxis = new NumberAxis(2007, 2017, 1);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);

        XYChart.Series<Number, Number> data = new XYChart.Series<>();

        data.getData().add(new XYChart.Data<>(2007, 73));
        data.getData().add(new XYChart.Data<>(2008, 68));
        data.getData().add(new XYChart.Data<>(2009, 72));
        data.getData().add(new XYChart.Data<>(2010, 72));
        data.getData().add(new XYChart.Data<>(2011, 74));
        data.getData().add(new XYChart.Data<>(2012, 73));
        data.getData().add(new XYChart.Data<>(2013, 76));
        data.getData().add(new XYChart.Data<>(2014, 73));
        data.getData().add(new XYChart.Data<>(2015, 67));
        data.getData().add(new XYChart.Data<>(2016, 56));
        data.getData().add(new XYChart.Data<>(2017, 56));

        chart.getData().add(data);

        Scene scene = new Scene(chart, 640, 480);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }
}