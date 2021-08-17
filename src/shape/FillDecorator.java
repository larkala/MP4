package shape;
import java.awt.Graphics;
import point.Point;
import state.State;

public class FillDecorator implements Shape
{
    private Shape decoratee;
    private final State shapeState;
    public FillDecorator(Shape decoratee)
    {
        this.decoratee = decoratee;
        this.shapeState = decoratee.shapeState();
    }

    @Override
    public void draw(Graphics g)
    {
        decoratee.draw(g);
        shapeState.fillShape(g, decoratee);
        }
    @Override
    public Point getPosition()
    {
        return decoratee.getPosition();
    }
    @Override
    public double getWidth()
    {
        return decoratee.getWidth();
    }
    @Override
    public double getHeight()
    {
        return decoratee.getHeight();
    }
    @Override
    public boolean intersects(Point point)
    {
        return decoratee.intersects(point);
    }
    @Override
    public void moveTo(Point point)
    {
        decoratee.moveTo(point);
    }
    @Override
    public void move(double dx, double dy)
    {
        decoratee.move(dx, dy);
    }
    @Override
    public void resizeTo(Point point)
    {
        decoratee.resizeTo(point);
    }
    @Override
    public Shape peel()
    {
        return decoratee;
    }
    @Override
    public State shapeState()
    {
        return this.shapeState;
    }
}
