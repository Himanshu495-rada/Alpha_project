
//import required classes and packages  
import javax.swing.*;
import java.awt.*;
import java.sql.*;

//create NewPage class to create a new page on which user will navigate  
class RegisterForm extends JFrame {
    // constructor

    JPanel newPanel;
    JLabel userLabel, passLabel, phLabel, nameLabel, depLabel;
    final JTextField userField, passField, phField, nameField, depField;

    RegisterForm() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register");
        setSize(600, 600);

        // create label for username
        userLabel = new JLabel();
        userLabel.setText("Employee ID"); // set label value for textField1
        userLabel.setFont(new Font("Consolas", Font.BOLD, 16));

        // create text field to get username from the user
        userField = new JTextField(15); // set length of the text

        // create label for password
        passLabel = new JLabel();
        passLabel.setText("Password"); // set label value for textField2
        passLabel.setFont(new Font("Consolas", Font.BOLD, 16));

        // create text field to get password from the user
        passField = new JPasswordField(15); // set length for the password

        // create label for phone number
        phLabel = new JLabel();
        phLabel.setText("Phone Number"); // set label value for textField2
        phLabel.setFont(new Font("Consolas", Font.BOLD, 16));

        // create text field to get phone number from the user
        phField = new JTextField(15); // set length for the password

        // create label for name
        nameLabel = new JLabel();
        nameLabel.setText("Name"); // set label value for textField2
        nameLabel.setFont(new Font("Consolas", Font.BOLD, 16));

        // create text field to get name from the user
        nameField = new JTextField(15); // set length for the password

        // create label for department
        depLabel = new JLabel();
        depLabel.setText("Department"); // set label value for textField2
        depLabel.setFont(new Font("Consolas", Font.BOLD, 16));

        // create text field to get department from the user
        depField = new JTextField(15); // set length for the password

        // create submit button
        JButton b1 = new JButton("Register"); // set label to button
        b1.setFont(new Font("Consolas", Font.BOLD, 16));
        JButton b2 = new JButton("Cancel");
        b2.setFont(new Font("Consolas", Font.BOLD, 16));

        newPanel = new JPanel(new GridLayout(0, 2)); // set layout to grid layout with 3 rows and 2 columns
        newPanel.add(userLabel); // set username label to panel
        newPanel.add(userField); // set text field to panel
        newPanel.add(passLabel); // set password label to panel
        newPanel.add(passField); // set text field to panel
        newPanel.add(phLabel); // set phone number label to panel
        newPanel.add(phField); // set phone number text field to panel
        newPanel.add(nameLabel); // set name label to panel
        newPanel.add(nameField); // set name text field to panel
        newPanel.add(depLabel); // set department label to panel
        newPanel.add(depField); // set department text field to panel
        newPanel.add(b1); // login button
        newPanel.add(b2); // register button
        add(newPanel, BorderLayout.CENTER);
        b1.addActionListener(listener -> {

            // add data to database
            String user = userField.getText();
            String pass = passField.getText();
            String ph = phField.getText();
            String name = nameField.getText();
            String dep = depField.getText();
            String sql = "INSERT INTO Employee_details (`emp_id`, `name`, 'phnum' , 'dep', 'pwd') VALUES ('"
                    + user + "','" + name + "','" + ph + "','" + dep + "','" + pass + "')";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }

        });
    }
}