package ensup.service;

import java.util.List;

import ensup.business.Course;

public interface ICourseService
{
    void delete(Course course);
    Course get(int index);
    List<Course> getAll();
    int createCourse(Course course);
    void create(String subject, float nbHours);
    void update(String subject, float nbHours);
}
