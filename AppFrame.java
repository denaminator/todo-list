package classes;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// Overall structure of the ToDo list
public class AppFrame extends JFrame {

    // Private vars for different components of frame structure
    private TitleBar title;
    private List list;
    private ButtonPanel btPan;

    // Private vars for panel buttons
    private JButton addTask;
    private JButton clrTasks;

    // Constructor
    AppFrame() {
        // Sets size, close operation, and visibility of frame
        this.setSize(450,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        title = new TitleBar();
        list = new List();
        btPan = new ButtonPanel();

        // Places objects to corresponding area of BorderLayout within frame
        this.add(title, BorderLayout.NORTH);
        this.add(btPan, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        // Calls on getter methods in ButtonPanel class for button actions
        addTask = btPan.getNewTask();
        clrTasks = btPan.getClear();

        // ArrayList to contain created tasks, initial size 1
        ArrayList<Task> listItems = new ArrayList<Task>(1);
        // ArrayList to note if checked, initial size 1
        ArrayList<Boolean> isChecked = new ArrayList<Boolean>(1);
        addListeners(listItems, isChecked);
    }

    // **
    // Listener for mouse events
    public void addListeners(ArrayList<Task> listItems, ArrayList<Boolean> isChecked) {

        // Mouse events for Add Task button
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Creates new Task object, adds to List obj "list"
                Task task = new Task();
                list.add(task);
                // Appends Task obj "task" to listItems
                listItems.add(task);
                // Sets isChecked var corresponding to listItems index as false (default option)
                isChecked.add(false);

                // Calls List function updateNum to update displayed index
                list.updateNum(listItems);

                // **
                // Mouse events for Done button
                task.getDone().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        // Calls Task function changeState to alter isChecked boolean value once done
                        task.changeState(isChecked);
                        revalidate();
                    }
                });
            }
        });

        // Mouse events for Clear button
        clrTasks.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Calls List function removeCompleted to erase completed tasks
                list.removeCompleted(listItems, isChecked);
                repaint();
            }
        });
    }
}
