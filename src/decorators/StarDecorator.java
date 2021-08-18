package decorators;

import point.Point;
import state.State;

import java.awt.*;
import java.awt.geom.Path2D;

public class StarDecorator implements ShapeDecorator {

    private shape.Shape decoratee;
    private final State shapeState;

    public StarDecorator(shape.Shape decoratee)
    {
        this.decoratee = decoratee;
        this.shapeState = decoratee.shapeState();
    }

    /**
     * Method authored by @Marco13 at stackoverflow
     * Link: https://stackoverflow.com/questions/16327588/how-to-make-star-shape-in-java
     */
    private static java.awt.Shape createStar(double centerX, double centerY,
                                    double innerRadius, double outerRadius, int numRays,
                                    double startAngleRad)
    {
        Path2D path = new Path2D.Double();
        double deltaAngleRad = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++)
        {
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0)
            {
                relX *= outerRadius;
                relY *= outerRadius;
            }
            else
            {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0)
            {
                path.moveTo(centerX + relX, centerY + relY);
            }
            else
            {
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }

    /**
     * Method authored by @Marco13 at stackoverflow
     * Link: https://stackoverflow.com/questions/16327588/how-to-make-star-shape-in-java
     */
    private static java.awt.Shape createDefaultStar(double radius, double centerX,
                                           double centerY)
    {
        return createStar(centerX, centerY, radius/2.63, radius, 5,
                Math.toRadians(-18));
    }
    @Override
    public void draw(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        decoratee.draw(g);
        Point position = decoratee.getPosition();
        int x = (int)position.getX();
        int y = (int)position.getY();
        gr.setColor(Color.ORANGE);
        gr.fill(createDefaultStar(decoratee.getWidth()/2, x, y));
        gr.setColor(Color.BLACK);
    }

    @Override
    public Point getPosition()
    {
        return decoratee.getPosition();
    }
    @Override
    public double getWidth()
    {
        return decoratee.getWidth();
    }
    @Override
    public double getHeight()
    {
        return decoratee.getHeight();
    }
    @Override
    public boolean intersects(Point point)
    {
        return decoratee.intersects(point);
    }
    @Override
    public void moveTo(Point point)
    {
        decoratee.moveTo(point);
    }
    @Override
    public void move(double dx, double dy)
    {
        decoratee.move(dx, dy);
    }
    @Override
    public void resizeTo(Point point)
    {
        decoratee.resizeTo(point);
    }
    @Override
    public shape.Shape peel()
    {
        return decoratee;
    }
    @Override
    public State shapeState()
    {
        return this.shapeState;
    }
}
