import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateEmployee extends JFrame implements ActionListener, ItemListener {
    JLabel label1, label2, label3, label4, label5, label6, label7, employeeNum;
    JTextField textField1, texField2, textField3, textField4, textField5, textField6, textField7;
    JButton button1, button2;
    Choice choice1, choice2;

    UpdateEmployee() {

        super("Update Employee");

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        choice2 = new Choice();
        choice2.setBounds(160, 40, 200, 20);

        try {
            Conn connection = new Conn();
            ResultSet rs = connection.s.executeQuery("select * from employee");

            while (rs.next()) {
                choice2.add(rs.getString("id"));
            }
        } catch (Exception e) {
        }

        employeeNum = new JLabel("Select Empno");
        employeeNum.setBounds(40, 40, 100, 20);
        add(employeeNum);
        add(choice2);

        label1 = new JLabel("Name : ");
        textField1 = new JTextField(15);

        label1.setBounds(40, 80, 100, 20);
        textField1.setBounds(160, 80, 200, 20);
        add(label1);
        add(textField1);

        choice1 = new Choice();
        choice1.add("Male");
        choice1.add("Female");

        label2 = new JLabel("Gender : ");

        label2.setBounds(40, 120, 100, 20);
        choice1.setBounds(160, 120, 200, 20);
        add(label2);
        add(choice1);

        label3 = new JLabel("Address : ");
        textField3 = new JTextField(15);

        label3.setBounds(40, 160, 100, 20);
        textField3.setBounds(160, 160, 200, 20);
        add(label3);
        add(textField3);

        label4 = new JLabel("State : ");
        textField4 = new JTextField(15);

        label4.setBounds(40, 200, 100, 20);
        textField4.setBounds(160, 200, 200, 20);
        add(label4);
        add(textField4);

        label5 = new JLabel("City : ");
        textField5 = new JTextField(15);

        label5.setBounds(40, 240, 100, 20);
        textField5.setBounds(160, 240, 200, 20);
        add(label5);
        add(textField5);

        label6 = new JLabel("Email : ");
        textField6 = new JTextField(15);

        label6.setBounds(40, 280, 100, 20);
        textField6.setBounds(160, 280, 200, 20);
        add(label6);
        add(textField6);

        label7 = new JLabel("Phone : ");
        textField7 = new JTextField(15);

        label7.setBounds(40, 320, 100, 20);
        textField7.setBounds(160, 320, 200, 20);
        add(label7);
        add(textField7);

        button1 = new JButton("Update");
        button2 = new JButton("Delete");

        button1.setBounds(40, 400, 150, 30);
        button2.setBounds(200, 400, 150, 30);
        add(button1);
        add(button2);

        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);

        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);

        button1.addActionListener(this);
        button2.addActionListener(this);

        choice2.addItemListener(this);

        setVisible(true);
        setSize(400, 550);
        setLocation(600, 200);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == button1) {
            String n = textField1.getText();
            String g = choice1.getSelectedItem();
            String a = textField3.getText();
            String s = textField4.getText();
            String c = textField5.getText();
            String e = textField6.getText();
            String p = textField7.getText();
            String qry = "update employee set name='" + n + "',gender='" + g + "',address='" + a + "',state='" + s
                    + "',city='" + c + "',email='" + e + "',phone='" + p + "'   where id=" + choice2.getSelectedItem();

            try {
                Conn connection = new Conn();
                connection.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Employee Updated");
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }

        if (ae.getSource() == button2) {
            try {
                Conn connection = new Conn();
                connection.s.executeUpdate("delete from employee where id=" + choice2.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Employee Deleted");
                this.setVisible(false);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        try {
            Conn connection = new Conn();
            ResultSet rs = connection.s.executeQuery("select * from employee where id=" + choice2.getSelectedItem());

            if (rs.next()) {
                textField1.setText(rs.getString("name"));
                textField3.setText(rs.getString("address"));
                textField4.setText(rs.getString("state"));
                textField5.setText(rs.getString("city"));
                textField6.setText(rs.getString("email"));
                textField7.setText(rs.getString("phone"));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new UpdateEmployee();
    }

}
