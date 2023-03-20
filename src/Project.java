import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        setSize(2000, 1100);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll.jpg"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        JLabel label1 = new JLabel(imageIcon3);
        add(label1);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu1 = new JMenu("Master");
        menu1.setForeground(Color.blue);

        JMenuItem menuItem1 = new JMenuItem("New Employee");

        menuItem1.setForeground(Color.blue);
        menuItem1.setFont(new Font("monospaced", Font.PLAIN, 12));
        menuItem1.setMnemonic('N');
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));

        JMenuItem menuItem3 = new JMenuItem("Salary");
        menuItem3.setForeground(Color.blue);
        menuItem3.setFont(new Font("monospaced", Font.PLAIN, 12));
        menuItem3.setMnemonic('S');
        menuItem3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schedreport.png")));
        menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem menuItem4 = new JMenuItem("List Employee");

        menuItem4.setForeground(Color.blue);
        menuItem4.setFont(new Font("monospaced", Font.PLAIN, 12));
        menuItem4.setMnemonic('L');
        menuItem4.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/newinvoice.png")));
        menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        menu1.add(menuItem1);
        menu1.add(menuItem3);
        menu1.add(menuItem4);
        menuBar.add(menu1);

        menuItem1.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);

        JMenu edit = new JMenu("Update");
        edit.setForeground(Color.RED);

        menuBar.add(edit);
        JMenuItem menuItemUpdateSal = new JMenuItem("Update Salary");
        menuItemUpdateSal.setForeground(Color.blue);
        menuItemUpdateSal.setFont(new Font("monospaced", Font.PLAIN, 12));
        menuItemUpdateSal.setMnemonic('U');
        menuItemUpdateSal.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EditOpen.png")));
        menuItemUpdateSal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));

        edit.add(menuItemUpdateSal);

        JMenuItem menuItemUpdateEmp = new JMenuItem("Update Employee");

        menuItemUpdateEmp.setForeground(Color.blue);
        menuItemUpdateEmp.setFont(new Font("monospaced", Font.PLAIN, 12));
        menuItemUpdateEmp.setMnemonic('p');
        menuItemUpdateEmp.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
        menuItemUpdateEmp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        edit.add(menuItemUpdateEmp);
        JMenuItem menuTakeAtt = new JMenuItem("Take Attendance");

        menuTakeAtt.setForeground(Color.blue);
        menuTakeAtt.setFont(new Font("monospaced", Font.PLAIN, 12));
        menuTakeAtt.setMnemonic('T');
        menuTakeAtt.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EXPENSE.PNG")));
        menuTakeAtt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));

        edit.add(menuTakeAtt);

        menuItemUpdateSal.addActionListener(this);
        menuItemUpdateEmp.addActionListener(this);
        menuTakeAtt.addActionListener(this);

        JMenu reports = new JMenu("Reports");
        reports.setForeground(Color.blue);

        menuBar.add(reports);
        JMenuItem genPaySlip = new JMenuItem("Generate PaySlip");

        genPaySlip.setForeground(Color.blue);
        genPaySlip.setFont(new Font("monospaced", Font.PLAIN, 12));
        genPaySlip.setMnemonic('P');
        genPaySlip.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payments.png")));
        genPaySlip.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        reports.add(genPaySlip);
        JMenuItem listAttendance = new JMenuItem("List Attendance");

        listAttendance.setForeground(Color.blue);
        listAttendance.setFont(new Font("monospaced", Font.PLAIN, 12));
        listAttendance.setMnemonic('L');
        listAttendance.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
        listAttendance.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        reports.add(listAttendance);
        genPaySlip.addActionListener(this);
        listAttendance.addActionListener(this);

        JMenu util = new JMenu("Utilities");
        util.setForeground(Color.red);

        menuBar.add(util);
        JMenuItem u1 = new JMenuItem("Notepad");

        u1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));

        u1.setForeground(Color.blue);
        u1.setFont(new Font("monospaced", Font.PLAIN, 12));
        u1.setMnemonic('o');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        util.add(u1);
        JMenuItem u2 = new JMenuItem("Calculator");
        u2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/calc.png")));

        u2.setForeground(Color.blue);
        u2.setFont(new Font("monospaced", Font.PLAIN, 12));
        u2.setMnemonic('C');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        util.add(u2);
        JMenuItem u3 = new JMenuItem("Web Browser");
        u3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/explorer.jpg")));

        u3.setForeground(Color.blue);
        u3.setFont(new Font("monospaced", Font.PLAIN, 12));
        u3.setMnemonic('E');
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        util.add(u3);

        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);

        JMenu m8 = new JMenu("Exit");
        m8.setForeground(Color.red);
        menuBar.add(m8);
        JMenuItem m8i1 = new JMenuItem("Exit");
        m8.add(m8i1);
        m8i1.setForeground((Color.blue));
        m8i1.setFont(new Font("monospaced", Font.PLAIN, 14));
        m8i1.setMnemonic('X');
        m8i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        m8i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        m8i1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("New Employee"))
            new NewEmployee().setVisible(true);
        else if (msg.equals("List Employee"))
            new ListEmployee().setVisible(true);
        else if (msg.equals("Update Employee"))
            new UpdateEmployee().setVisible(true);
        else if (msg.equals("Salary"))
            new Salary().setVisible(true);
        else if (msg.equals("Update Salary"))
            new UpdateSalary().setVisible(true);
        else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
            }
        } else if (msg.equals("Web Browser")) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            } catch (Exception e) {
            }
        } else if (msg.equals("Take Attendance")) {
            new TakeAttendance().setVisible(true);
        } else if (msg.equals("Exit"))
            System.exit(0);
        else if (msg.equals("Generate PaySlip"))
            new PaySlip().setVisible(true);
        else if (msg.equals("List Attendance"))
            new ListAttendance().setVisible(true);
    }

    public static void main(String[] args) {
        new Project().setVisible(true);
    }

}
