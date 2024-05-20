package PointGrow;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimatedChart extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");

        // Create a line chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Animated Chart");

        // Create a series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Data");

        // Add data points to the series
        series.getData().add(new XYChart.Data<>(1, 2));
        series.getData().add(new XYChart.Data<>(2, 4));
        series.getData().add(new XYChart.Data<>(3, 6));
        series.getData().add(new XYChart.Data<>(4, 8));
        series.getData().add(new XYChart.Data<>(5, 10));

        // Add the series to the chart
        lineChart.getData().add(series);

        // Create a timeline for the animation
        Timeline timeline = new Timeline();
        for (XYChart.Data<Number, Number> data : series.getData()) {
            // Animate each data point's size
            KeyValue keyValue = new KeyValue(data.nodeProperty().get().scaleXProperty(), 0);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);
            timeline.getKeyFrames().add(keyFrame);
        }

        // Play the animation
        timeline.play();

        // Set up the scene
        Scene scene = new Scene(lineChart, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}