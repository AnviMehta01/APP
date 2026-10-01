package week9;

import java.sql.*;
import java.util.*;

public class ProductJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/store";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con =
                DriverManager.getConnection(URL, USER, PASS);

            System.out.print("Product ID: ");
            int id = sc.nextInt();

            System.out.print("Product Name: ");
            String name = sc.next();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Product VALUES(?,?,?,?)");

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);

            ps.executeUpdate();
            System.out.println("Product inserted");

            ps = con.prepareStatement(
                "SELECT * FROM Product WHERE ProductID=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                    "Product: " + rs.getInt("ProductID") +
                    " " + rs.getString("ProductName") +
                    " " + rs.getDouble("Price") +
                    " " + rs.getInt("Quantity"));
            }

            System.out.print("New Quantity: ");
            int newQuantity = sc.nextInt();

            ps = con.prepareStatement(
                "UPDATE Product SET Quantity=? WHERE ProductID=?");

            ps.setInt(1, newQuantity);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("\nProducts with quantity below 10:");

            ps = con.prepareStatement(
                "SELECT * FROM Product WHERE Quantity < 10");

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("ProductID") + " " +
                    rs.getString("ProductName") + " " +
                    rs.getDouble("Price") + " " +
                    rs.getInt("Quantity"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
