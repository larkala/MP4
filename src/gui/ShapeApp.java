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

        JMenu menu1 = new JMenu("Insert Shape");
        JMenu menu2 = new JMenu("Decorate");
        JMenu menu3 = new JMenu("Modes");


        createMenuItem(menu1, "Circle", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeState = new CircleState();
                shapeContainer.setState(new InsertState(shapeState));
            }
        });
        createMenuItem(menu1, "Square", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeState = new SquareState();
                shapeContainer.setState(new InsertState(shapeState));
            }
        });

        createMenuItem(menu2, "Fill", e -> shapeContainer.setState(new FillState()));
        createMenuItem(menu2, "Star", e -> shapeContainer.setState(new StarState()));
        createMenuItem(menu2, "Cross", e -> shapeContainer.setState(new CrossState()));
        createMenuItem(menu2, "Clear", e -> shapeContainer.setState(new ClearState()));

        createMenuItem(menu3, "Move", e -> shapeContainer.setState(new MoveState()));
        createMenuItem(menu3, "Delete", e -> shapeContainer.setState(new DeleteState()));
        createMenuItem(menu3, "Resize", e -> shapeContainer.setState(new ResizeState()));

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
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
