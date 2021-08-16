package shape;

import point.Point;

import java.awt.*;


public class Rectangle implements Shape
{
    private Point center;
    private double w, h;

    public Rectangle(double x, double y, double w,  double h)
    {
        center = new Point(x,y);
        this.w = w;
        this.h = h;
    }

    public Rectangle(Point point, double w, double h)
    {
        this(point.getX(), point.getY(), w, h);
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawRect((int)(0.5+center.getX()-(w/2)), (int)(0.5+center.getY()-(h/2)), (int)(0.5+w), (int)(0.5+h));
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
        return h;
    }

    @Override
    public boolean intersects(Point point)
    {
        return center.distanceTo(point) < h || center.distanceTo(point) < w;
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
        Point newPoint = new Point(point.getX()/2, point.getY()/2);
        h = w = center.distanceTo(newPoint);
    }

    @Override
    public Shape peel()
    {
        return this;
    }
}
