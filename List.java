package classes;

import java.util.*;
import java.awt.*;
import javax.swing.*;

// List of the tasks 
public class List extends JPanel {

    // Constructor
    List() {
        // Sets number of possible tasks (10 w/1 col) and gap between tasks
        GridLayout layout = new GridLayout(10, 1);
        layout.setVgap(5);

        // Sets layout of List class
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(400, 560));
    }

    // **
    // Updates displayed task number using size of listItems (# of tasks)
    public void updateNum (ArrayList<Task> listItems) {

        for (int i = 0; i < listItems.size(); i++) {
            // Gets Task obj at index i of listItems and
            // calls Task function changeIndex to display task #
            listItems.get(i).changeIndex(i);
        }
    }

    // Removes all completed tasks from the list
    public void removeCompleted(ArrayList<Task> listItems, ArrayList<Boolean> isChecked) {

        // Uses Component objects (retrieved from List obj "list"
        // Contains all added Task objs) for visual task removal
        for (Component c : getComponents()) {

            if (c instanceof Task) {
                // Index of listItems corresponding to (Task)c
                int b = listItems.indexOf((Task)c);

                if (isChecked.get(b) == true) {

                    // Removes Component and visually removes task from JPanel
                    remove(c);

                    listItems.remove(b);
                    isChecked.remove(b);

                    // Updates task numbers of new list once completed tasks cleared
                    updateNum(listItems);
                    revalidate();
                }
            }
        }
    }
}
