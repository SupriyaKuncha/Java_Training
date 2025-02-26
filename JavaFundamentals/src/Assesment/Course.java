package Assesment;

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