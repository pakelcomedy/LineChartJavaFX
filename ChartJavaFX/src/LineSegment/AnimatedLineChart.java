package LineSegment;

import javafx.animation.KeyFrame;
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
        // Create the X and Y axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");

        // Create the line chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Animated Line Chart");

        // Create a series for the line chart
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Data");

        // Add data points to the series
        series.getData().add(new XYChart.Data<>(0, 0));
        series.getData().add(new XYChart.Data<>(1, 2));
        series.getData().add(new XYChart.Data<>(2, 1));
        series.getData().add(new XYChart.Data<>(3, 4));
        series.getData().add(new XYChart.Data<>(4, 3));

        // Add series to the chart
        lineChart.getData().add(series);

        // Create a timeline for the animation
        Timeline timeline = new Timeline();
        for (int i = 0; i < series.getData().size() - 1; i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(1 * (index + 1)), event -> {
                // Draw line segment between two consecutive points
                drawLineSegment(series, index);
            });
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();

        // Set up the scene
        Scene scene = new Scene(lineChart, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void drawLineSegment(XYChart.Series<Number, Number> series, int index) {
        double startX = series.getData().get(index).getXValue().doubleValue();
        double startY = series.getData().get(index).getYValue().doubleValue();
        double endX = series.getData().get(index + 1).getXValue().doubleValue();
        double endY = series.getData().get(index + 1).getYValue().doubleValue();

        // Create a new line segment between the two points
        XYChart.Series<Number, Number> segment = new XYChart.Series<>();
        segment.getData().add(new XYChart.Data<>(startX, startY));
        segment.getData().add(new XYChart.Data<>(endX, endY));

        // Add the line segment to the chart
        ((LineChart<Number, Number>) series.getChart()).getData().add(segment);
    }

    public static void main(String[] args) {
        launch(args);
    }
}