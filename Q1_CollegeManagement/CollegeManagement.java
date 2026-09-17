import student.Student;
import course.Course;

public class CollegeManagement {
    public static void main(String[] args) {

        Student s = new Student(101, "Anvi", "CSE");
        Course c = new Course(201, "Java Programming", 4);

        System.out.println("Student Details:");
        s.display();

        System.out.println("\nCourse Details:");
        c.display();
    }
}
