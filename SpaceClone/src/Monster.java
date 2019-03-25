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

public class Monster extends Canvas {
    private GraphicsContext gc;
    private Color color;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    private boolean isAlive;
    private Timeline timeline;

    Group root;

    public Monster(int x, int y, Group root, Color color){
        super(20,20);
        this.color = color;
        this.root = root;
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.isAlive = true;

        gc = getGraphicsContext2D();

       // timeline  = new Timeline( new KeyFrame(Duration.millis(100), e->handle()));
       // timeline.setCycleCount(Animation.INDEFINITE);
       // timeline.play();

        draw();
    }




    public void draw() {

        if (isAlive)
        {
            System.out.println("Monster Says Draw!");
            gc.setFill(color);
            gc.fillRect(0,0,20,20);

        }
        else{
            gc.clearRect(0,0,20,20);
        }

    }

}


