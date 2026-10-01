package week9;

import java.sql.*;
import java.util.*;

public class LibraryJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/library";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n1. Insert Book");
                System.out.println("2. Search Book");
                System.out.println("3. Display Available Books");
                System.out.println("4. Issue Book");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();

                if (ch == 1) {
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();

                    System.out.print("Title: ");
                    String title = sc.next();

                    System.out.print("Author: ");
                    String author = sc.next();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    String sql =
                        "INSERT INTO Book VALUES(?,?,?,?,?)";

                    PreparedStatement ps =
                        con.prepareStatement(sql);

                    ps.setInt(1, id);
                    ps.setString(2, title);
                    ps.setString(3, author);
                    ps.setDouble(4, price);
                    ps.setBoolean(5, true);

                    ps.executeUpdate();
                    System.out.println("Book inserted");
                }

                else if (ch == 2) {
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();

                    PreparedStatement ps =
                        con.prepareStatement(
                            "SELECT * FROM Book WHERE BookID=?");

                    ps.setInt(1, id);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        System.out.println(
                            rs.getInt("BookID") + " " +
                            rs.getString("Title") + " " +
                            rs.getString("Author") + " " +
                            rs.getDouble("Price") + " " +
                            rs.getBoolean("Availability"));
                    } else {
                        System.out.println("Book not found");
                    }
                }

                else if (ch == 3) {
                    Statement st = con.createStatement();

                    ResultSet rs = st.executeQuery(
                        "SELECT * FROM Book WHERE Availability=true");

                    while (rs.next()) {
                        System.out.println(
                            rs.getInt("BookID") + " " +
                            rs.getString("Title") + " " +
                            rs.getString("Author") + " " +
                            rs.getDouble("Price"));
                    }
                }

                else if (ch == 4) {
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();

                    PreparedStatement ps =
                        con.prepareStatement(
                            "UPDATE Book SET Availability=false WHERE BookID=?");

                    ps.setInt(1, id);
                    ps.executeUpdate();

                    System.out.println("Book issued");
                }

                else {
                    break;
                }
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
