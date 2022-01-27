package myPackage;

import java.sql.*;

public class testSqlite {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;


        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/home/wiss/sharks.db";
            c = DriverManager.getConnection(url);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tbl1;");
            while (rs.next()) {
                int id = rs.getInt("one");
                String one = rs.getString("one");
                String two = rs.getString("two");
                System.out.println("one = " + one);
                System.out.println("two = " + two);

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
