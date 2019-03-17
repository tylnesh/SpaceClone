import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class SpaceCloneApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Ship ship = new Ship(320 - 40, 400, Color.RED,5);
        root.getChildren().add(ship);

        Scene scene = new Scene(root, 640, 480);

        scene.setFill(Color.BLACK);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
