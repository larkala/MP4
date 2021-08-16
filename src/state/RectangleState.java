package state;

import point.Point;
import shape.Rectangle;
import shape.Shape;

public class RectangleState extends State{
    @Override
    public Shape drawShape(Point point)
    {
        return new Rectangle(point, Math.random() * 100.0, Math.random() * 100.0);
    }
}
