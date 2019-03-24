import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;



public class Ship extends Canvas{

    private GraphicsContext gc;
    private int speed;
    private Color color;
    private Group root;


    public Ship(float x, float y, Color color, int speed, Group root)
    {
        super (60,60);
        this.root = root;
        this.setLayoutX(x);
        this.setLayoutY(y);


        this.color = color;
        this.speed = speed;

        gc = getGraphicsContext2D();
        Draw();

        setOnKeyPressed(evt -> handle(evt));
        setFocusTraversable(true);
        requestFocus();

    }

    private void handle(KeyEvent evt) {
        KeyCode k = evt.getCode();
        if (k == KeyCode.LEFT) goLeft();
        if (k == KeyCode.RIGHT) goRight();
        if (k == KeyCode.SPACE) shoot();

    }

    private void goRight() {
        this.setLayoutX(this.getLayoutX() + speed);
    }

    private void goLeft() {
        this.setLayoutX(this.getLayoutX() - speed);

    }
    private void shoot(){
        //Shot shot = new Shot(this.getLayoutX(), this.getLayoutY(),speed);
        root.getChildren().add(new Shot(this.getLayoutX(), this.getLayoutY(),speed,root));
    }

    private void Draw() {
        gc.clearRect(0,0,getWidth(), getHeight());

        // orange rockets - under the ship
        gc.setFill(Color.ORANGE);
        gc.fillRect(10,30,2.5,20);
        gc.fillRect(27.5,30,2.5,20);

        // dark red body of the ship
        gc.setFill(Color.DARKRED);
        double[] bodyXPoints = {10,20,30};
        double[] bodyYPoints = {50,20,50};
        gc.fillPolygon(bodyXPoints,bodyYPoints,3);

        //blue cockpit
        gc.setFill(Color.BLUE);
        double[] cockpitXPoints = {15,20,25};
        double[] cockpitYPoints = {55,20,55};
        gc.fillPolygon(cockpitXPoints,cockpitYPoints,3);






    }

}
