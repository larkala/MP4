package state;

import gui.ShapeContainer;
import point.Point;
import shape.Shape;
import shape.ShapeDecorator;

public class MarkedState extends State{

    @Override
    public void pointerDown(Point point, ShapeContainer sc) {
        sc.select(point);
        if(sc.selected() != null)
        {
            Shape markedShape = new ShapeDecorator(sc.selected());
            sc.shapes().remove(sc.selected());
            sc.shapes().add((markedShape));
            sc.repaint();
        }
    }
}
