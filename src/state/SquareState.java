package state;

import point.Point;
import shape.Square;
import shape.Shape;

import java.awt.*;

public class SquareState extends State{
    @Override
    public Shape drawShape(Point point)
    {
        return new Square(point, Math.random() * 100.0);
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
