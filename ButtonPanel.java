package classes;

import java.awt.*;
import javax.swing.*;

// Panel at bottom with buttons
public class ButtonPanel extends JPanel {

    // Private vars to add and clear tasks
    private JButton addTask;
    private JButton clrTasks;

    Font btnFont = new Font("Courier", Font.PLAIN, 18);

    // Constructor
    ButtonPanel() {
        this.setPreferredSize(new Dimension(400,60));
        this.setBackground(new Color(192, 229, 255));

        // Add task button (border and font)
        addTask = new JButton("Add task");
        addTask.setFont(btnFont);
        this.add(addTask);

        // Space between buttons w/horizontal strut
        this.add(Box.createHorizontalStrut(10));

        // Clear tasks button (border and font)
        clrTasks = new JButton("Clear completed tasks");
        clrTasks.setFont(btnFont);
        this.add(clrTasks);
    }

    // **
    // Getter method for Add tasks
    public JButton getNewTask() {
        return addTask;
    }

    // Getter method for Clear tasks
    public JButton getClear() {
        return clrTasks;
    }
}
