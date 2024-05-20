package PointAppear;

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

public class AnimatedLineChart extends Application {

    @Override
    public void start(Stage stage) {
        // Create axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");

        // Create line chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Animated Line Chart");

        // Create data series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Data");

        // Add data points
        series.getData().add(new XYChart.Data<>(1, 0)); // Initialize Y value with 0
        series.getData().add(new XYChart.Data<>(2, 0)); // Initialize Y value with 0
        series.getData().add(new XYChart.Data<>(3, 0)); // Initialize Y value with 0
        series.getData().add(new XYChart.Data<>(4, 0)); // Initialize Y value with 0
        series.getData().add(new XYChart.Data<>(5, 0)); // Initialize Y value with 0

        // Add series to chart
        lineChart.getData().add(series);

        // Create timeline for animation
        Timeline timeline = new Timeline();
        for (int i = 0; i < series.getData().size(); i++) {
            XYChart.Data<Number, Number> data = series.getData().get(i);
            // Add keyframes to timeline for each data point
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(i + 1),
                    new KeyValue(data.YValueProperty(), Math.random() * 30))); // Change this value to control the appearance position
        }

        // Set cycle count and play animation
        timeline.setCycleCount(1);
        timeline.play();

        // Show the scene
        Scene scene = new Scene(lineChart, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}