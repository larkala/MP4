package state;

import gui.ShapeContainer;
import point.Point;
import shape.Shape;

import java.awt.*;

public abstract class State {
    private State state;
    public void pointerDown(Point point, ShapeContainer sc)
    {}

    public void pointerMoved(Point point, boolean pointerDown, ShapeContainer sc)
    {}

    public Shape drawShape(Point point)
    {
        return null;
    }

    public void setState(State newState)
    {
        this.state = newState;
    }

    public State getState()
    {
        return this.state;
    }


}
