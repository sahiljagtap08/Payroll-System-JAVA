import java.awt.*;
import javax.security.auth.login.LoginContext;
import javax.swing.*;

class Splash {
    public static void main(String s[]) {
        sframe frame = new sframe("Payroll System  Free Licence Version 3.0");
        frame.setVisible(true); // show
        int i;
        int x = 1;
        for (i = 2; i <= 600; i += 4, x += 1) {
            frame.setLocation((800 - ((i + x) / 2)), 500 - (i / 2));
            frame.setSize(i + x, i);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }
}

class sframe extends JFrame implements Runnable {
    Thread t1;

    sframe(String s) {
        super(s);
        setLayout(new FlowLayout());
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/payroll_system.jpg"));
        Image imagee = imageIcon.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imagee);

        JLabel label = new JLabel(imageIcon2);
        add(label);
        t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            this.setVisible(false);
            Login login = new Login();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}