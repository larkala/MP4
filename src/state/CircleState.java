package state;

import point.Point;
import shape.Circle;
import shape.Shape;

import java.awt.*;

public class CircleState extends State{
    @Override
    public Shape drawShape(Point point)
    {
        return new Circle(point, Math.random() * 50.0);
    }

    @Override
    public void fillShape(Graphics g, Shape shape)
    {
        Point position = shape.getPosition();
        int x = (int)(position.getX()-shape.getWidth()/2.0+0.5);
        int y = (int)(position.getY()-shape.getHeight()/2.0+0.5);
        g.fillOval(x,y,(int)(shape.getWidth()+0.5),(int)(shape.getHeight()+0.5));

    }
}

