import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.sql.*;

//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class CreateLoginForm extends JFrame implements ActionListener {
    // initialize button, panel, label, and text field
    JButton b1, b2;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField textField1, textField2;

    // calling constructor
    CreateLoginForm() {

        // create label for username
        userLabel = new JLabel();
        userLabel.setText("Employee ID"); // set label value for textField1
        userLabel.setFont(new Font("Consolas", Font.BOLD, 16));

        // create text field to get username from the user
        textField1 = new JTextField(15); // set length of the text
        textField1.setFont(new Font("Consolas", Font.PLAIN, 16));

        // create label for password
        passLabel = new JLabel();
        passLabel.setText("Password"); // set label value for textField2
        passLabel.setFont(new Font("Consolas", Font.BOLD, 16));

        // create text field to get password from the user
        textField2 = new JPasswordField(15); // set length for the password
        textField2.setFont(new Font("Consolas", Font.PLAIN, 16));

        // create submit button
        b1 = new JButton("Login");
        b1.setFont(new Font("Consolas", Font.BOLD, 16));

        b2 = new JButton("Register");
        b2.setFont(new Font("Consolas", Font.BOLD, 16));

        // create panel to put form elements
        newPanel = new JPanel(new GridLayout(3, 2)); // set layout to grid layout with 3 rows and 2 columns
        newPanel.add(userLabel); // set username label to panel
        newPanel.add(textField1); // set text field to panel
        newPanel.add(passLabel); // set password label to panel
        newPanel.add(textField2); // set text field to panel
        newPanel.add(b1); // login button
        newPanel.add(b2); // register button

        // set border to panel
        add(newPanel, BorderLayout.CENTER);

        // perform action on button click
        b1.addActionListener(this); // add action listener to button
        b2.addActionListener(listener -> {
            System.out.println("Register button clicked");
            RegisterForm rf = new RegisterForm();
            rf.setVisible(true);
        });
        setTitle("LOGIN FORM"); // set title to the login form
    }

    // define abstract method actionPerformed() which will be called on button click
    public void actionPerformed(ActionEvent ae) // pass action listener as a parameter
    {
        String userValue = textField1.getText(); // get user entered username from the textField1
        String passValue = textField2.getText(); // get user entered pasword from the textField2


        // create connection to database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from login where emp_id = '" + userValue + "' and pwd = '" + passValue + "'");
            if (rs.next()) {
                System.out.println("Login Successful");
                NewPage np = new NewPage();
                np.setVisible(true);
                this.dispose();
            } else {
                System.out.println("Login Failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// create the main class
class LoginFormDemo {
    // main() method start
    public static void main(String arg[]) {
        try {
            // create instance of the CreateLoginForm
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(600, 300); // set size of the frame
            form.setVisible(true); // make form visible to the user
        } catch (Exception e) {
            // handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}