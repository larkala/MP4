package state;

import gui.ShapeContainer;
import point.Point;
import shape.Circle;

public class InsertState extends State{
    State shapeState;

    public InsertState(State shapeState)
    {
        this.shapeState = shapeState;
    }

    @Override
    public void pointerDown(Point point, ShapeContainer sc) {
        sc.shapes().add(shapeState.drawShape(point));
        sc.repaint();
    }

}
