import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Salary extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, label7;
    JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    JButton button1, button2;
    Choice choice;

    Salary() {

        super("Set Salary");

        setLayout(new GridLayout(8, 2, 20, 20));
        choice = new Choice();

        try {
            Conn connection = new Conn();
            ResultSet rs = connection.s.executeQuery("select * from employee");

            while (rs.next()) {
                choice.add(rs.getString("id"));
            }
        } catch (Exception e) {
        }

        add(new JLabel("Select Empno"));
        add(choice);

        label1 = new JLabel("HRA");
        textField1 = new JTextField(15);
        add(label1);
        add(textField1);

        label3 = new JLabel("DA");
        textField3 = new JTextField(15);
        add(label3);
        add(textField3);

        label4 = new JLabel("MED");
        textField4 = new JTextField(15);
        add(label4);
        add(textField4);

        label5 = new JLabel("PF");
        textField5 = new JTextField(15);
        add(label5);
        add(textField5);

        label6 = new JLabel("Basic Salary");
        textField6 = new JTextField(15);
        add(label6);
        add(textField6);

        button1 = new JButton("Submit");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);

        button2 = new JButton("Cancel");
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);

        add(button1);
        add(button2);

        button1.addActionListener(this);
        button2.addActionListener(this);

        setSize(450, 550);
        setLocation(500, 200);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae) {

        String hra = textField1.getText();
        String id = choice.getSelectedItem();
        String da = textField3.getText();
        String med = textField4.getText();
        String pf = textField5.getText();
        String basic = textField6.getText();
        String qry = "insert into salary values(" + id + "," + hra + "," + da + "," + med + "," + pf + "," + basic
                + ")";

        try {
            Conn connection1 = new Conn();
            connection1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null, "Salary updated");
            this.setVisible(false);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Salary();
    }
}
