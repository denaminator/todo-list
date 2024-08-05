package classes;

import java.awt.*;
import javax.swing.*;

// Title bar header
public class TitleBar extends JPanel {

    // Constructor
    TitleBar() {
        this.setPreferredSize(new Dimension(400,80));
        this.setBackground(new Color(192, 229, 255));

        // New JLabel "ToDo List"
        JLabel titleTxt = new JLabel("ToDo List");
        titleTxt.setPreferredSize(new Dimension(200,80));
        titleTxt.setFont(new Font("Courier", Font.BOLD, 20));
        titleTxt.setHorizontalAlignment(JLabel.CENTER);

        this.add(titleTxt);
    }

}
