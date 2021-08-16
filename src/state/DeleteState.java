package state;

import gui.ShapeContainer;
import point.Point;

public class DeleteState extends State{

    @Override
    public void pointerDown(Point point, ShapeContainer sc) {
        sc.select(point);
        if(sc.selected() != null)
            sc.shapes().remove(sc.selected());
        sc.select(null);
        sc.repaint();
    }

}
