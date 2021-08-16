package state;

import gui.ShapeContainer;
import point.Point;
import shape.Shape;
import shape.ShapeDecorator;

public class MarkedState extends State{

    private State shapeState;
    public MarkedState(State shapeState)
    {
        this.shapeState = shapeState;
    }

    public MarkedState(){
        this(new RectangleState());
    }

    @Override
    public void pointerDown(Point point, ShapeContainer sc) {
        sc.select(point);
        if(sc.selected() != null)
        {
            Shape markedShape = new ShapeDecorator(sc.selected(), shapeState);
            sc.shapes().remove(sc.selected());
            sc.shapes().add((markedShape));
            sc.repaint();
        }
    }
}
