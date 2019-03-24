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

        Ship ship = new Ship(320 - 40, 400, Color.RED,25, root);



        Scene scene = new Scene(root, 640, 480);

        scene.setFill(Color.BLACK);

        Galaxy[] galaxy = new Galaxy[200];
        for (int i = 0; i<200; i++)
        {
          galaxy[i] = new Galaxy(640,480,root);
          root.getChildren().add(galaxy[i]);

        }

       // Monster m1 = new Monster(100,100,root, Color.YELLOW);

        RowOfMonsters r1 = new RowOfMonsters(50,10,10, root);
        //root.getChildren().add(m1);
        //root.getChildren().addAll(r1);
        root.getChildren().add(r1);
        root.getChildren().add(ship);



        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
