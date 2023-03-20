import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;


public class PaySlip extends JFrame implements ActionListener {

    Choice choice;
    JTextArea textArea;
    JButton button;

    PaySlip() {

        setSize(800, 700);
        setLocation(400, 150);
        choice = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while (rs.next()) {
                choice.add(rs.getString("id"));
            }
        } catch (Exception e) {
        }

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Id"));
        panel.add(choice);
        add(panel, "North");

        textArea = new JTextArea(30, 80);
        JScrollPane jsp = new JScrollPane(textArea);

        Font f1 = new Font("arial", Font.BOLD, 20);
        textArea.setFont(f1);

        button = new JButton("Generate Pay Slip");

        add(button, "South");
        add(jsp, "Center");
        button.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        try {
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from employee where id=" + choice.getSelectedItem());
            rs.next();
            String name = rs.getString("name");
            rs.close();

            rs = c.s.executeQuery("select * from salary where id=" + choice.getSelectedItem());
            double gross = 0;
            double net = 0;

            java.util.Date d1 = new java.util.Date();
            Calendar cal = new Calendar.getInstance();
            int month = cal.get(Calendar.MONTH);

            textArea.setText(
                    " ----------------   PAY SLIP FOR THE MONTH OF " + month + " ,2019  ------------------------");
            textArea.append("\n");

            if (rs.next()) {

                textArea.append("\n     Employee ID " + rs.getString("id"));
                textArea.append("\n     Employee Name " + name);

                textArea.append("\n----------------------------------------------------------------");
                textArea.append("\n");

                double hra = rs.getDouble("hra");
                textArea.append("\n                  HRA         : " + hra);
                double da = rs.getDouble("da");
                textArea.append("\n                  DA          : " + da);
                double med = rs.getDouble("med");
                textArea.append("\n                  MED         : " + med);
                double pf = rs.getDouble("pf");
                textArea.append("\n                  PF          : " + pf);
                double basic = rs.getDouble("basic_salary");
                gross = hra + da + med + pf + basic;
                net = gross - pf;
                textArea.append("\n                  BASIC SALARY : " + basic);

                textArea.append("\n-------------------------------------------------------");
                textArea.append("\n");

                textArea.append("\n       GROSS SALARY :" + gross + "    \n       NET SALARY : " + net);
                textArea.append("\n       Tax   :   2.1% of gross " + (gross * 2.1 / 100));
                textArea.append("\n -------------------------------------------------");
                textArea.append("\n");
                textArea.append("\n");
                textArea.append("\n");
                textArea.append("   (  Signature  )      ");

            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new PaySlip().setVisible(true);
    }
}
