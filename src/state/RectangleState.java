package state;

import point.Point;
import shape.Rectangle;
import shape.Shape;

import java.awt.*;

public class RectangleState extends State{
    @Override
    public Shape drawShape(Point point)
    {
        return new Rectangle(point, Math.random() * 100.0, Math.random() * 100.0);
    }

    @Override
    public void fillShape(Graphics g, Shape shape)
    {
        Point position = shape.getPosition();

        int x = (int)(position.getX()-shape.getWidth()/2.0+0.5);
        int y = (int)(position.getY()-shape.getHeight()/2.0+0.5);
        g.fillRect(x,y,(int)(shape.getWidth()+0.5),(int)(shape.getHeight()+0.5));

    }
}
