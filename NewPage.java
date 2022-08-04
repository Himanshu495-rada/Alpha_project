
//import required classes and packages  
import javax.swing.*;
import java.awt.*;

//create NewPage class to create a new page on which user will navigate  
class NewPage extends JFrame {
    // constructor
    JPanel newPanel;

    NewPage() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome");
        setSize(800, 800);

        newPanel = new JPanel(new GridLayout(0, 1));
        newPanel.add(new JLabel("Welcome to the system"));

        add(newPanel);
    }
}