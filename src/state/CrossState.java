package state;

import gui.ShapeContainer;
import point.Point;
import decorators.CrossDecorator;
import shape.Shape;

public class CrossState extends State{

    @Override
    public void pointerDown(Point point, ShapeContainer sc) {
        sc.select(point);
        if(sc.selected() != null)
        {
            Shape markedShape = new CrossDecorator(sc.selected());
            sc.shapes().remove(sc.selected());
            sc.shapes().add((markedShape));
            sc.repaint();
        }
    }
}
