import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField;
    JPasswordField passField;
    JButton button1, button2;

    Login() {
        super("Login Page");
        setLayout(new BorderLayout());
        passField = new JPasswordField(10);
        textField = new JTextField(10);
        label3 = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\defaultpic.png")));

        button1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
        button2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));

        button1.addActionListener(this);
        button2.addActionListener(this);

        JPanel p1, p2, p3, p4;
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        add(label3, BorderLayout.WEST);

        p2.add(new JLabel("User Name  "));
        p2.add(textField);
        p2.add(new JLabel("Password "));
        p2.add(passField);
        add(p2, BorderLayout.CENTER);

        p4.add(button1);
        p4.add(button2);

        add(p4, BorderLayout.SOUTH);

        setSize(400, 250);
        setLocation(600, 400);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c1 = new Conn();
            String u = textField.getText();
            String v = passField.getPassword();

            String q = "select * from login where username='" + u + "' and password='" + v + "'";

            ResultSet rs = c1.s.executeQuery(q); // query execute
            if (rs.next()) {
                new Project().setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
