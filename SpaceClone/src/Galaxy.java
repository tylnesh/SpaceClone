import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.Random;


public class Galaxy extends Canvas{

    private GraphicsContext gc;
    private int speed;
    private Color color;
    private Random random;
    private int size;
    Timeline timeline;
    Group root;

    public Galaxy(int x, int y, Group root) {
        super(x, y);
        this.root = root;
        random = new Random();
        speed  = random.nextInt(10)+1;
        size = random.nextInt(3);
        this.setLayoutX(random.nextInt(640));
        this.setLayoutY(random.nextInt(480));
        gc = getGraphicsContext2D();
        timeline  = new Timeline( new KeyFrame(Duration.millis(100), e->handle()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    private void handle() {

    move();
    draw();
    }

    private void move() {

        if (getLayoutY()>480) {
            setLayoutY(-20);
            setLayoutX(random.nextInt(640));
        }
                else setLayoutY(getLayoutY() + speed);


    }

    private void draw() {

        gc.setFill(Color.WHITE);
        gc.fillOval(size,size,size,size);
    }
}
