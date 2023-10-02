/* the CollegeStudent class represents the product being built using the Prototype pattern.
 The CollegeStudent.clone() method is used to create a deep copy of the CollegeStudent object, including all the courses taken by the student.

In the Main class, a Scanner object is used to read user input for the student's name, age, major, and courses. 
The CollegeStudent object is created using the input, and its printStudent() method is called to display the student's details. 
A deep copy of the CollegeStudent object is then created using the clone() method, and a new course is added to it.
 The printStudent() method is called again to display the details of both the original and cloned student objects.

Note that the CollegeStudent class implements the Cloneable interface.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// CollegeStudent class using Prototype Pattern with deep cloning
class CollegeStudent implements Cloneable {
    private String name;
    private int age;
    private String major;
    private List<String> courses;

    public CollegeStudent(String name, int age, String major, List<String> courses) {
        this.name = name;
        this.age = age;
        this.major = major;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    @Override
    public CollegeStudent clone() {
        try {
            CollegeStudent student = (CollegeStudent) super.clone();
            student.courses = new ArrayList<String>();
            for (String course : courses) {
                student.courses.add(course);
            }
            return student;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void printStudent() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Major: " + major);
        System.out.print("Courses: ");
        for (String course : courses) {
            System.out.print(course + " ");
        }
        System.out.println();
    }
}

// Driver class for testing
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline character

        System.out.print("Enter student major: ");
        String major = scanner.nextLine();

        List<String> courses = new ArrayList<String>();
        System.out.println("Enter the courses the student is taking (type 'done' when finished):");
        while (true) {
            String course = scanner.nextLine();
            if (course.equals("done")) {
                break;
            }
            courses.add(course);
        }

        CollegeStudent originalStudent = new CollegeStudent(name, age, major, courses);
        originalStudent.printStudent();

        CollegeStudent clonedStudent = originalStudent.clone();
        clonedStudent.addCourse("Algorithms");

        System.out.println("Original student:");
        originalStudent.printStudent();

        System.out.println("Cloned student:");
        clonedStudent.printStudent();
    }
}
