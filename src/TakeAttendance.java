import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TakeAttendance extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, label7;
    JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    JButton button1, button2;
    Choice choice1, choice2, choice3;

    TakeAttendance() {

        setLayout(new GridLayout(4, 2, 50, 50));
        choice1 = new Choice();
        try {
            Conn connection = new Conn();
            ResultSet rs = connection.s.executeQuery("select * from employee");
            while (rs.next()) {
                choice1.add(rs.getString("id"));
            }

        } catch (Exception e) {
        }

        add(new JLabel("Select Empno"));
        add(choice1);

        label1 = new JLabel("First Half");
        choice2 = new Choice();
        choice2.add("Present");
        choice2.add("Absent");
        choice2.add("Leave");

        add(label1);
        add(choice2);

        label2 = new JLabel("Second Half");
        choice3 = new Choice();
        choice3.add("Present");
        choice3.add("Absent");
        choice3.add("Leave");

        add(label2);
        add(choice3);

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

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(400, 450);
        setLocation(600, 200);

    }

    public void actionPerformed(ActionEvent ae) {

        String selectItem1 = choice2.getSelectedItem();
        String selectedItem2 = choice3.getSelectedItem();
        String dateToString = new java.util.Date().toString();
        String id = choice1.getSelectedItem();
        String qry = "Insert Into Attendance Values(" + id + ",'" + dateToString + "','" + selectItem1 + "','"
                + selectedItem2 + "')";

        try {
            Conn connection = new Conn();
            connection.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null, "Attendence confirmed");
            this.setVisible(false);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String s[]) {
        new TakeAttendance();
    }
}
