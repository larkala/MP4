package state;

import gui.ShapeContainer;
import point.Point;

public class ResizeState extends State{
    @Override
    public void pointerDown(Point point, ShapeContainer sc)
    {
        sc.select(point);
    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown, ShapeContainer sc)
    {
        if(sc.selected() != null && pointerDown)
        {
            sc.selected().resizeTo(point);
            sc.repaint();
        }
    }
}
