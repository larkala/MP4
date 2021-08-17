package shape;

import point.Point;
import state.State;

import java.awt.*;
import java.awt.geom.Path2D;

public class CrossDecorator implements Shape{

    private Shape decoratee;
    private final State shapeState;

    public CrossDecorator(Shape decoratee)
    {
        this.decoratee = decoratee;
        this.shapeState = decoratee.shapeState();
    }


    @Override
    public void draw(Graphics g) {
        decoratee.draw(g);
        Point position = decoratee.getPosition();
        int x = (int)position.getX();
        int y = (int)position.getY();

        int wr = (int) decoratee.getWidth()/2;
        int hr = (int) decoratee. getHeight()/2;

        int vertx1 = x-wr;
        int vertx2 = x-wr;

        int hory1 = y-hr;
        int hory2 = y+hr;

        g.setColor(Color.BLUE);
        g.drawLine(vertx1, y, vertx2, y);
        g.drawLine(x, hory1, x, hory2);
        g.setColor(Color.BLACK);
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
