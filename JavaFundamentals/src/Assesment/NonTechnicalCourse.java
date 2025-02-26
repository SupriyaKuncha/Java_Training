package Assesment;

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
 