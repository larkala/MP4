package gui;
import state.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ShapeApp extends JFrame
{
    private static final long serialVersionUID = 1L;
    private ShapeContainer shapeContainer = new ShapeContainer();
    private State shapeState = new CircleState();

    public ShapeApp()
    {
        createMenu();
        this.add(shapeContainer);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
    }

    public void createMenu()
    {
        JMenu menu1 = new JMenu("Modes");
        JMenu menu2 = new JMenu("Shapes");

        createMenuItem(menu1, "Insert", e -> shapeContainer.setState(new InsertState(shapeState)));
        createMenuItem(menu1, "Move", e -> shapeContainer.setState(new MoveState()));
        createMenuItem(menu1, "Delete", e -> shapeContainer.setState(new DeleteState()));
        createMenuItem(menu1, "Mark", e -> shapeContainer.setState(new MarkedState()));
        createMenuItem(menu1, "Unmark", e -> shapeContainer.setState(new UnmarkedState()));
        createMenuItem(menu1, "Resize", e -> shapeContainer.setState(new ResizeState()));

        createMenuItem(menu2, "Circle", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeState = new CircleState();
                shapeContainer.setState(new InsertState(shapeState));
            }
        });
        createMenuItem(menu2, "Rectangle", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeState = new RectangleState();
                shapeContainer.setState(new InsertState(shapeState));
            }
        });


        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu1);
        menuBar.add(menu2);
        this.setJMenuBar(menuBar);
    }

    private void createMenuItem(JMenu menu, String label, ActionListener listener)
    {
        JMenuItem menuItem = new JMenuItem(label);
        menuItem.addActionListener(listener);
        menu.add(menuItem);
    }

    public static void main(String args[])
    {
        new ShapeApp(); // obs egentligen SwingUtilities ...
    }
}
