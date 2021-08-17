package state;

import gui.ShapeContainer;
import point.Point;
import shape.CrossDecorator;
import shape.Shape;
import shape.StarDecorator;

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
