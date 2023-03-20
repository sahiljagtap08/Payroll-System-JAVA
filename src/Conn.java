import java.sql.*;

public class Conn {

    public Connection c;
    public Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///ps", "root", "mysql123");
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
