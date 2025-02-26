
import java.util.*;
import java.util.stream.Collectors;
 

abstract class Course {
    protected int courseId;
    protected String courseName;
    protected String instructor;
    protected int durationWeeks;
    protected double fee;
 
    public Course(int courseId, String courseName, String instructor, int durationWeeks, double fee) {
        if (durationWeeks <= 0) {
            throw new IllegalArgumentException("Course duration must be greater than 0.");
        }
        if (fee <= 0) {
            throw new IllegalArgumentException("Course fee must be greater than 0.");
        }
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.durationWeeks = durationWeeks;
        this.fee = fee;
    }
 
   
    public abstract double calculateDiscount();
 
    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Name: " + courseName +
               ", Instructor: " + instructor + ", Duration: " + durationWeeks + " weeks" +
               ", Fee: " + fee + ", Discount: " + calculateDiscount();
    }
}
 /////////////////////////////////////////////////

class TechnicalCourse extends Course {
    public TechnicalCourse(int courseId, String courseName, String instructor, int durationWeeks, double fee) {
        super(courseId, courseName, instructor, durationWeeks, fee);
    }
 
    @Override
    public double calculateDiscount() {
        if (fee > 20000) {
            return fee * 0.10;
        }
        return 0;
    }
}
 
////////////////////////////
class NonTechnicalCourse extends Course {
    public NonTechnicalCourse(int courseId, String courseName, String instructor, int durationWeeks, double fee) {
        super(courseId, courseName, instructor, durationWeeks, fee);
    }
 
    @Override
    public double calculateDiscount() {
        if (fee > 15000) {
            return fee * 0.05;
        }
        return 0;
    }
}
 

public class CourseManagementSystem {
    private LinkedList<Course> courseRecords;
 
    public CourseManagementSystem() {
        courseRecords = new LinkedList<>();
    }
 
   
    public void addCourse(Course course) {
        courseRecords.add(course);
    }
 
   
    public void sortByFee() {
        courseRecords.sort((c1, c2) -> Double.compare(c1.fee, c2.fee));
    }
 
   
    public List<Course> getCoursesLongerThan(int weekThreshold) {
        return courseRecords.stream()
                            .filter(course -> course.durationWeeks > weekThreshold)
                            .collect(Collectors.toList());
    }
 
   
    public void displayCourses(List<Course> courses) {
        for (Course c : courses) {
            System.out.println(c);
        }
    }
 
    
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        CourseManagementSystem cms = new CourseManagementSystem();
 
        try {
            System.out.print("Enter number of courses: ");
            int courseCount = scanner.nextInt();
            scanner.nextLine(); 
 
            for (int i = 0; i < courseCount; i++) {
                System.out.println("\nEnter details for course " + (i + 1) + ":");
 
                System.out.print("Course ID: ");
                int courseId = scanner.nextInt();
                scanner.nextLine(); 
 
                System.out.print("Course Name: ");
                String courseName = scanner.nextLine();
 
                System.out.print("Instructor Name: ");
                String instructorName = scanner.nextLine();
 
                System.out.print("Duration (in weeks): ");
                int duration = scanner.nextInt();
 
                System.out.print("Course Fee: ");
                double fee = scanner.nextDouble();
                scanner.nextLine(); 
 
                System.out.print("Course Type (Technical/Non-Technical): ");
                String courseType = scanner.nextLine();
 
                Course newCourse;
                
                if (courseType.equalsIgnoreCase("Technical")) {
                    newCourse = new TechnicalCourse(courseId, courseName, instructorName, duration, fee);
                } else if (courseType.equalsIgnoreCase("Non Technical")) {
                    newCourse = new NonTechnicalCourse(courseId, courseName, instructorName, duration, fee);
                } else {
                    System.out.println("Invalid ");
                    continue;
                }
 
                cms.addCourse(newCourse);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } catch (IllegalArgumentException a) {
            System.out.println("Error: " + a.getMessage());
        } finally {
            scanner.close();
        }
 
        System.out.println("\n--- All Course Records ---");
        cms.displayCourses(cms.courseRecords);
 
        cms.sortByFee();
        System.out.println("\n--- Courses Sorted by Fee (Ascending) ---");
        cms.displayCourses(cms.courseRecords);
 
        System.out.println("\n--- Courses with Duration > 4 Weeks ---");
        List<Course> longCourses = cms.getCoursesLongerThan(4);
        cms.displayCourses(longCourses);
    }
}