package state;

import gui.ShapeContainer;
import point.Point;
import shape.Shape;

public class ClearState extends State{
    @Override
    public void pointerDown(Point point, ShapeContainer sc) {
        sc.select(point);
        if(sc.selected() != null)
        {
            Shape unmarkedShape = sc.selected().peel();
            sc.shapes().remove(sc.selected());
            sc.shapes().add(unmarkedShape);
            sc.repaint();
        }
    }
}
