import java.sql.*;
import java.util.Scanner;

public class procoins {

        static final String DB_URL = "jdbc:den1.mysql3.gear.host";
        // Database credentials
        static final String USER = "procoinstest";
        static final String PASS = "Test123!";

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        Connection conn = null;
        Statement stmt = null;

        try {

            System.out.println("Connecting to Database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Enter an ID: ");
            String inputID = sc.nextLine();
            int s1 = Integer.parseInt(inputID);
            String strID = Integer.toString(s1);
            System.out.println("Creating Statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM person where id =" + strID;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");

                System.out.println("ID: " + id);
                System.out.println("First name: " + first_name);
                System.out.println("Last name: " + last_name);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //Finally used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }//nothing you can do but you need for the close
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
