package LineDraw;

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
        // Creating the x and y axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");

        // Creating the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Animated Line Chart");

        // Creating the data series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Data");

        // Adding data points to the series
        series.getData().add(new XYChart.Data<>(0, 0));
        series.getData().add(new XYChart.Data<>(1, 1));
        series.getData().add(new XYChart.Data<>(2, 3));
        series.getData().add(new XYChart.Data<>(3, 2));
        series.getData().add(new XYChart.Data<>(4, 4));

        // Adding the series to the chart
        lineChart.getData().add(series);

        // Creating a timeline for the animation
        Timeline timeline = new Timeline();
        series.getData().forEach(data -> {
            double endX = data.getXValue().doubleValue();
            double endY = data.getYValue().doubleValue();
            // Set the data point to 0 to make it appear as if it's drawing
            data.setXValue(0);
            data.setYValue(0);
            // Adding keyframes to animate the line draw
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO),
                    new KeyFrame(Duration.seconds(2), new KeyValue(data.XValueProperty(), endX)),
                    new KeyFrame(Duration.seconds(2), new KeyValue(data.YValueProperty(), endY))
            );
        });
        timeline.play();

        // Creating the scene
        Scene scene = new Scene(lineChart, 600, 400);

        // Setting the stage
        stage.setScene(scene);
        stage.setTitle("Animated Line Chart");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}