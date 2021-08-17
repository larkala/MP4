package shape;

import point.Point;
import state.SquareState;
import state.State;

import java.awt.*;


public class Square implements Shape
{
    private Point center;
    private double w;
    private final State shapeState = new SquareState();

    public Square(double x, double y, double w)
    {
        center = new Point(x,y);
        this.w = w;
    }

    public Square(Point point, double w)
    {
        this(point.getX(), point.getY(), w);
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawRect((int)(0.5+center.getX()-(w/2)), (int)(0.5+center.getY()-(w/2)), (int)(0.5+w), (int)(0.5+w));
    }

    @Override
    public Point getPosition()
    {
        return center;
    }

    @Override
    public double getWidth()
    {
        return w;
    }

    @Override
    public double getHeight()
    {
        return w;
    }

    @Override
    public boolean intersects(Point point)
    {
        return center.distanceTo(point) < w/2;
    }

    @Override
    public void moveTo(Point point)
    {
        center.moveTo(point);
    }

    @Override
    public void move(double dx, double dy)
    {
        center.move(dx,dy);
    }

    @Override
    public void resizeTo(Point point)
    {
        w = center.distanceTo(point);
    }

    @Override
    public Shape peel()
    {
        return this;
    }

    @Override
    public State shapeState()
    {
        return this.shapeState;
    }
}
