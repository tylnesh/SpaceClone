import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Shot extends Canvas {
    //int hp = 1;
    private int speed;
    private Timeline timeline;
    private GraphicsContext gc;
    private double x;
    private double y;
    private Group root;

    public Shot(double x, double y, int speed, Group root) {

        super(20,20) ;
        System.out.println("Shot created");
        System.out.println("X:" + x);
        System.out.println("Y:" + y);
        //System.out.println(this.getBoundsInLocal());
        this.root = root;
        this.x = x;
        this.y = y;
        setLayoutX(x);
        setLayoutY(y);
        this.speed = speed;
        gc = getGraphicsContext2D();
        timeline  = new Timeline( new KeyFrame(Duration.millis(100), e->handle()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    private void handle() {

        move();
        draw();
        System.out.println();
        for (int i = 0; i < root.getChildren().size(); i++)
        {

            if (root.getChildren().get(i).getClass().toString() == "Shot")
            {
                //if (this.getLayoutBounds())
            }

        }

        if(getLayoutY() <= 0) {
            timeline.stop();
            root.getChildren().remove(this);
        }

    }

    private void move() {

       setLayoutY(getLayoutY() - speed);

    }

    private void draw() {
        gc.clearRect(0,0,getWidth(), getHeight());
        gc.setFill(Color.ORANGE);
        gc.fillRect(5,5,5,20);
    }


   }