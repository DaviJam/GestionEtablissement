package ensup.service;

import ensup.business.Course;

public interface ICourseService extends IService<Course>
{
    void create(String subject, float nbHours);
    void update(String subject, float nbHours);
}
