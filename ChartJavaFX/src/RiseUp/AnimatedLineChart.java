package RiseUp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimatedLineChart extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create X and Y axis
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        yAxis.setLabel("Value");

        // Create a line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Animated Line Chart");

        // Create a series for the data
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Data Series");

        // Add the series to the line chart
        lineChart.getData().add(series);

        // Create a timeline for animation
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Add keyframes to animate the data
        for (int i = 0; i <= 360; i++) {
            final int x = i;
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 0.02), event -> {
                double y = Math.sin(Math.toRadians(x));
                series.getData().add(new XYChart.Data<>(x, y));
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        // Create a stack pane to hold the line chart
        StackPane root = new StackPane();
        root.getChildren().add(lineChart);

        // Create a scene and set it on the stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Animated Line Chart");
        primaryStage.show();

        // Play the timeline animation
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}