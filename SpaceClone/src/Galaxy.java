import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


public class Galaxy extends Canvas{

    private GraphicsContext gc;
    private int speed;
    private Color color;

    public Galaxy(int x, int y) {
        super(x,y);

    }

}
