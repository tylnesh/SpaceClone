import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;

public class RowOfMonsters extends Group {
    private int num;
    private int speed;
    private Monster[] m;
    private int x;
    Timeline timeline;
    private int direction = 1;
    private Group root;

    public RowOfMonsters(int x, int num, int speed, Group root)
    {
        this.num = num;
        this.speed = speed;
        this.x = x;
        this.root = root;
        addMonsters();
        timeline  = new Timeline( new KeyFrame(Duration.millis(100), e->handle()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();



    }

    private void handle() {

        move();
        checkCollisions();

    }

    private void checkCollisions() {

        ArrayList<Bounds> shots = new ArrayList<Bounds>();
        for (int i = 0; i< root.getChildren().size(); i++) {
            if (root.getChildren().get(i).getClass() == Shot.class) {
                System.out.println("shots");
                shots.add(root.getChildren().get(i).getBoundsInParent());

            }
        }


        for (int i = 0; i<this.getChildren().size(); i++)
        {
            double minX = m[i].getParent().getLocalToSceneTransform().getTx() + x*i + 50;
            double minY = 30;
            double minZ = 0;
            double width = 20;
            double height = 20;

            //System.out.println(m[i].getParent().getLocalToSceneTransform().getTx());
            for (int j = 0; j<shots.size(); j++)
                if (shots.get(j).intersects(minX,minY,width,height))
                {
                    System.out.println(this.getChildren().get(i).getClass().toString());
                    System.out.println("Monster " + i + " hit!");
                    m[i].setAlive(false);
                    m[i].draw();

                }
        }
    }


    private void move() {
        setLayoutX(getLayoutX() + (speed * direction));
        if (getLayoutX()>80) direction = -1;
        if (getLayoutX()<-40) direction = 1;
        //System.out.println(m[1].getParent().getLocalToSceneTransform().getTx());

        //Bounds b = new Bounds(minX, minY, minZ, width, height);
    }

    private void addMonsters() {
        m = new Monster[num];
        for (int i = 0; i < num; i++){
            m[i] = new Monster((x*(i)+50),30,this.root, Color.YELLOW);
            this.getChildren().add(m[i]);


        }


    }

}
