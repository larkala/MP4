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
}
