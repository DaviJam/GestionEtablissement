package ensup.dto;

public class CourseDTO {

    private String courseSubject;
    private float nbHours;
    private int id;

    public String getCourseSubject() {
        return courseSubject;
    }

    public void setCourseSubject(String courseSubject) {
        this.courseSubject = courseSubject;
    }

    public float getNbHours() {
        return nbHours;
    }

    public void setNbHours(float nbHours) {
        this.nbHours = nbHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseDTO() {
    }

    public CourseDTO(String courseSubject, float nbHours, int id) {
        this.courseSubject = courseSubject;
        this.nbHours = nbHours;
        this.id = id;
    }

    public CourseDTO(String courseSubject, float nbHours) {
        this.courseSubject = courseSubject;
        this.nbHours = nbHours;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseSubject='" + courseSubject + '\'' +
                ", nbHours=" + nbHours +
                ", id=" + id +
                '}';
    }
}