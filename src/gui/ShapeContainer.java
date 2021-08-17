package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import handler.MouseHandler;
import point.Point;
import point.Pointable;
import shape.Shape;
import state.CircleState;
import state.InsertState;
import state.State;

public class ShapeContainer extends JPanel implements Pointable {
    private static final long serialVersionUID = 1L;
    private List<Shape>       shapes           = new LinkedList<Shape>();

    private Shape selected;
    private State state = new InsertState(new CircleState());

    public ShapeContainer()
    {
        super();
        MouseHandler mouseHandler = new MouseHandler(this);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.setBackground(Color.white);
    }

    public void addShape(Shape shape)
    {
        shapes.add(shape);
    }

    public void paintComponent(Graphics g) // anropas av Swing när det är dags att
    // rendera
    {
        super.paintComponent(g);

        for (Shape shape : shapes)
            shape.draw(g);

    }

    public Shape selected() {
        return selected;
    }

    public void select(Point point)
    {
        if(point == null)
        {
            selected = null;
            return;
        }
        for (Shape shape : shapes)
        {
            if (shape.intersects(point))
            {
                selected = shape;
                return;
            }
        }
    }

    public void pointerDown(Point point)
    {
        state.pointerDown(point, this);
    }

    public void pointerUp(Point point)
    {
        selected = null;
    }

    public void pointerMoved(Point point, boolean pointerDown)
    {
        state.pointerMoved(point, pointerDown, this);
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public List<Shape> shapes(){
        return this.shapes;
    }
}
