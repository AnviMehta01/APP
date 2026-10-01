package week9;

import java.sql.*;
import java.util.*;

public class CourseRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String pass = "root";

        try {
            Connection con =
                DriverManager.getConnection(url, user, pass);

            System.out.print("Enter Course Code: ");
            String code = sc.next();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM CourseRegistration WHERE CourseCode=?");

            ps.setString(1, code);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println(
                    "Student ID: " + rs.getInt("StudentID") +
                    "\nStudent Name: " + rs.getString("StudentName") +
                    "\nCourse Code: " + rs.getString("CourseCode") +
                    "\nCourse Name: " + rs.getString("CourseName") +
                    "\nSemester: " + rs.getInt("Semester"));
            }

            if (!found)
                System.out.println("No students registered for this course.");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}