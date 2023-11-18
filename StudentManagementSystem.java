
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    // Constructor
    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    // Methods

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Remove a student
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
