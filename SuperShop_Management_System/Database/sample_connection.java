import java.sql.*;

public class DBconnect {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "");
            System.out.println("connected");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from demotab");

            while (rs.next()) {
                System.out.println("no=" + rs.getInt(1) + " name=" + rs.getString(2));
            }
           // Connection.close();
        } catch (Exception s) {
            System.out.println(s);
        }
    }
}
