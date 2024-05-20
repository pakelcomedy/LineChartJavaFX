package SplineCurve;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimatedSplineCurveLineChart extends Application {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int NUM_POINTS = 50;
    private static final double ANIMATION_DURATION = 3000; // Milliseconds
    private static final double INTERPOLATION_FACTOR = 1.5;

    private LineChart<Number, Number> lineChart;
    private XYChart.Series<Number, Number> series;
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        // Create X and Y axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");

        // Create line chart
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Animated Spline Curve Line Chart");

        // Create series for data points
        series = new XYChart.Series<>();
        lineChart.getData().add(series);

        // Create VBox to hold the chart
        VBox root = new VBox(lineChart);

        // Create scene
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        // Setup stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Animated Spline Curve Line Chart");
        primaryStage.show();

        // Generate sample data points
        generateData();

        // Setup animation timeline
        timeline = new Timeline(new KeyFrame(Duration.ZERO, event -> updateCurve()),
                new KeyFrame(Duration.millis(ANIMATION_DURATION)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    // Generate sample data points
    private void generateData() {
        for (int i = 0; i <= NUM_POINTS; i++) {
            double x = i;
            double y = Math.random() * 100;
            series.getData().add(new XYChart.Data<>(x, y));
        }
    }

    // Update spline curve
    private void updateCurve() {
        for (int i = 0; i < series.getData().size() - 1; i++) {
            double startX = series.getData().get(i).getXValue().doubleValue();
            double startY = series.getData().get(i).getYValue().doubleValue();
            double endX = series.getData().get(i + 1).getXValue().doubleValue();
            double endY = series.getData().get(i + 1).getYValue().doubleValue();

            // Interpolate points for spline curve
            for (double t = 0; t <= 1; t += 0.01) {
                double x = interpolate(startX, endX, t);
                double y = interpolate(startY, endY, t);
                series.getData().add(new XYChart.Data<>(x, y));
            }
        }

        // Remove original data points
        series.getData().subList(0, NUM_POINTS + 1).clear();
    }

    // Interpolate between two values
    private double interpolate(double startValue, double endValue, double t) {
        return startValue + (endValue - startValue) * Math.pow(t, INTERPOLATION_FACTOR);
    }

    public static void main(String[] args) {
        launch(args);
    }
}