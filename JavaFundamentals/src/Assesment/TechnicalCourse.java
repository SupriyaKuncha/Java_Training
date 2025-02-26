package Assesment;

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