
//importing necessary java libraries
// import necessary packages for JDBC, Swing and AWT
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/*
 * Create a public class called NewEmployee that extends the JFrame class 
 * and implements the ActionListener interface
 */
public class NewEmployee extends JFrame implements ActionListener {
    // Declare the instance variables
    JLabel nameLabel, genderLabel, addressLabel, stateLabel, cityLabel, emailLabel, phoneLabel;
    JTextField nameCols, genderCols, addressCols, stateCols, cityCols, emailCols, phoneCols;
    JButton submitButton, cancelButton;
    Choice choice;

    // Create a constructor for the NewEmployee class
    NewEmployee() {

        // Call the constructor of the superclass JFrame and set the title of the window
        super("New Employee");

        // Set the size and location of the window, as well as the background color
        setSize(600, 650);
        setLocation(600, 200);
        getContentPane().setBackground(Color.WHITE); // Set the background color of the content pane to white

        // Create a JPanel and set the background color to white
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        /*
         * Set the layout of the panel to a grid
         * with 8 rows, 2 columns, and a 10 pixel horizontal and 40 pixel vertical gap
         * between components
         */
        panel.setLayout(new GridLayout(8, 2, 10, 40));

        // Create JLabels and JTextFields for each piece of employee information, and
        // add them to the panel
        nameLabel = new JLabel("Name");
        nameCols = new JTextField(15);
        panel.add(nameLabel);
        panel.add(nameCols);

        // Create a new choice object and add two options, "Male" and "Female"
        choice = new Choice();
        choice.add("Male");
        choice.add("Female");

        // Create a new label object for the gender and add the choice object to the
        // panel
        genderLabel = new JLabel("Gender");
        panel.add(genderLabel);
        panel.add(choice);

        // Create a new label object for the address and a new text field object with 15
        // columns for inputting the address
        addressLabel = new JLabel("Address");
        addressCols = new JTextField(15);

        // Add the address label and text field to the panel
        panel.add(addressLabel);
        panel.add(addressCols);

        // Create a new label object for the state and a new text field object with 15
        // columns for inputting the state
        stateLabel = new JLabel("State");
        stateCols = new JTextField(15);

        // Add the state label and text field to the panel
        panel.add(stateLabel);
        panel.add(stateCols);

        // Create a new label object for the city and a new text field object with 15
        // columns for inputting the city
        cityLabel = new JLabel("City");
        cityCols = new JTextField(15);

        // Add the city label and text field to the panel
        panel.add(cityLabel);
        panel.add(cityCols);

        // Create a new label object for the email and a new text field object with 15
        // columns for inputting the email
        emailLabel = new JLabel("Email");
        emailCols = new JTextField(15);

        // Add the email label and text field to the panel
        panel.add(emailLabel);
        panel.add(emailCols);

        // Create a new label object for the phone number and a new text field object
        // with 15 columns for inputting the phone number
        phoneLabel = new JLabel("Phone");
        phoneCols = new JTextField(15);
        panel.add(phoneLabel);
        panel.add(phoneCols);

        // Create JButtons for submitting or canceling employee creation, and add them
        // to the panel
        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");
        panel.add(submitButton);
        panel.add(cancelButton);

        // Set the layout of the NewEmployee JFrame as a BorderLayout
        setLayout(new BorderLayout());
        // Add an image to the left side of the JFrame using a JLabel and an ImageIcon
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/new_employee.png"))), "West");
        add(panel, "Center"); // Add the panel to the center of the JFrame

        // Add ActionListeners to the submit and cancel buttons, and set their
        // background and foreground colors
        submitButton.addActionListener(this);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);

        cancelButton.addActionListener(this);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);

    }

    // Override the actionPerformed method of the ActionListener interface
    public void actionPerformed(ActionEvent ae) {

        // Create a new instance of the Random class to generate a unique employee
        // number
        Random rnd = new Random();
        int number = rnd.nextInt(9999);
        String num = "" + number;

        // get the values entered in the text fields and choice box
        String n = nameCols.getText();
        String g = choice.getSelectedItem();
        String a = addressCols.getText();
        String s = stateCols.getText();
        String c = cityCols.getText();
        String e = emailCols.getText();
        String p = phoneCols.getText();
        // construct a SQL query to insert a new employee with the entered values
        String qry = "insert into employee values('" + num + "','" + n + "','" + g + "','" + a + "','" + s + "','" + c
                + "','" + e + "','" + p + "')";

        try {
            // create a new connection object
            Conn c1 = new Conn();
            // execute the SQL query to insert the new employee into the database
            c1.s.executeUpdate(qry);
            // display a success message to the user
            JOptionPane.showMessageDialog(null, "Employee Created");
            this.setVisible(false); // hide the current window

        } catch (Exception ee) {
            // if an exception occurs, print the stack trace
            ee.printStackTrace();
        }
    }

    // main method to create and display a new instance of the NewEmployee class
    public static void main(String s[]) {
        new NewEmployee().setVisible(true);
    }
}
