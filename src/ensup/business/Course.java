package ensup.business;

public class Course {
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

    public Course(String courseSubject, float nbHours, int id) {
        this.courseSubject = courseSubject;
        this.nbHours = nbHours;
        this.id = id;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseSubject='" + courseSubject + '\'' +
                ", nbHours=" + nbHours +
                ", id=" + id +
                '}';
    }
}
