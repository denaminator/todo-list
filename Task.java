package classes;

import java.util.*;
import java.awt.*;
import javax.swing.*;

// Individual tasks
public class Task extends JPanel {

    // Task number, name, done button
    private JLabel index;
    private JTextField taskName;
    private JButton done;

    // Constructor
    Task() {
        this.setPreferredSize(new Dimension(40,20));
        this.setBackground(new Color(144, 244, 236));
        this.setLayout(new BorderLayout());

        // New JLabel (blank index currently) w/dimensions and alignment
        index = new JLabel("");
        index.setPreferredSize(new Dimension(20,20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        // Text for new task
        taskName = new JTextField("  Your task...");
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBackground(new Color(213, 251, 248));
        this.add(taskName, BorderLayout.CENTER);

        // Button to mark task as complete
        done = new JButton("Done");
        done.setPreferredSize(new Dimension(50, 20));
        done.setBorder(BorderFactory.createEmptyBorder());
        this.add(done, BorderLayout.EAST);
    }

    // **
    // Getter for Done button
    public JButton getDone() {
        return done;
    }

    // Sets the displayed index of the Task obj to i+1 (index i = task i+1)
    public void changeIndex(int i) {
        this.index.setText(i + 1 + "");
        this.revalidate();
    }

    // Changes task status to done
    public void changeState(ArrayList<Boolean> isChecked) {

        this.setBackground(new Color(14, 226, 187));
        taskName.setBackground(new Color(14, 226, 187));

        // Sets numInd as task # - 1
        int numInd = Integer.valueOf(index.getText()) - 1;
        // Changes boolean val at index numInd of ArrayList isChecked to true
        isChecked.set(numInd, true);

        revalidate();
    }
}
