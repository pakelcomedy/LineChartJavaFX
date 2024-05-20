package GradientFill;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimatedGradientLineChart extends Application {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int NUM_POINTS = 50;
    private static final double ANIMATION_DURATION = 3000; // Milliseconds
    private static final Color START_COLOR = Color.BLUE;
    private static final Color END_COLOR = Color.RED;

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
        lineChart.setTitle("Animated Gradient Line Chart");

        // Create series for data points
        series = new XYChart.Series<>();
        lineChart.getData().add(series);

        // Create VBox to hold the chart
        VBox root = new VBox(lineChart);

        // Create scene
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        // Setup stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Animated Gradient Line Chart");
        primaryStage.show();

        // Generate sample data points
        generateData();

        // Setup animation timeline
        timeline = new Timeline(new KeyFrame(Duration.ZERO, event -> updateGradient()),
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

    // Update gradient fill
    private void updateGradient() {
        Path path = (Path) series.getNode().lookup(".chart-series-line");
        if (path != null) {
            Rectangle clip = new Rectangle(0, 0, WIDTH, HEIGHT);
            path.setClip(clip);

            // Calculate gradient colors
            Color color = interpolateColor(START_COLOR, END_COLOR, timeline.getCurrentTime().toMillis() / ANIMATION_DURATION);

            // Apply gradient fill
            path.setFill(color);
        }
    }

    // Interpolate color between two colors
    private Color interpolateColor(Color startColor, Color endColor, double t) {
        double red = interpolate(startColor.getRed(), endColor.getRed(), t);
        double green = interpolate(startColor.getGreen(), endColor.getGreen(), t);
        double blue = interpolate(startColor.getBlue(), endColor.getBlue(), t);
        double opacity = interpolate(startColor.getOpacity(), endColor.getOpacity(), t);
        return new Color(red, green, blue, opacity);
    }

    // Interpolate between two values
    private double interpolate(double startValue, double endValue, double t) {
        return startValue + (endValue - startValue) * t;
    }

    public static void main(String[] args) {
        launch(args);
    }
}