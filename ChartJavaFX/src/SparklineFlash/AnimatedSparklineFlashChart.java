package SparklineFlash;

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

public class AnimatedSparklineFlashChart extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");

        // Create line chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Animated Sparkline Flash Chart");

        // Create data series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Data");

        // Add data to series
        series.getData().add(new XYChart.Data<>(1, 10));
        series.getData().add(new XYChart.Data<>(2, 20));
        series.getData().add(new XYChart.Data<>(3, 15));
        series.getData().add(new XYChart.Data<>(4, 25));
        series.getData().add(new XYChart.Data<>(5, 18));

        // Add series to chart
        lineChart.getData().add(series);

        // Create scene
        Scene scene = new Scene(lineChart, 600, 400);

        // Set up animation
        Timeline timeline = new Timeline();
        for (int i = 0; i < series.getData().size() - 1; i++) {
            XYChart.Data<Number, Number> startData = series.getData().get(i);
            XYChart.Data<Number, Number> endData = series.getData().get(i + 1);
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.seconds(i),
                            new KeyValue(startData.getNode().opacityProperty(), 0),
                            new KeyValue(endData.getNode().opacityProperty(), 0),
                            new KeyValue(((LineChart.Series<Number, Number>) lineChart.getData().get(0)).getNode().lookup(".chart-series-line").opacityProperty(), 0)),
                    new KeyFrame(Duration.seconds(i + 0.5),
                            new KeyValue(startData.getNode().opacityProperty(), 1),
                            new KeyValue(endData.getNode().opacityProperty(), 1),
                            new KeyValue(((LineChart.Series<Number, Number>) lineChart.getData().get(0)).getNode().lookup(".chart-series-line").opacityProperty(), 1))
            );
        }
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();

        // Show stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}