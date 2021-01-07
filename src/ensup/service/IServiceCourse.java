package ensup.service;	

import ensup.business.Course;

public interface IServiceCourse extends IService<Course>
{
    int createCourse(Course course);
    int create(String subject, float nbHours);
    int update(String subject, float nbHours);
    public int getIndex( String coursesubject, float nbhours );
}
