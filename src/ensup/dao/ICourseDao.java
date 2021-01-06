package ensup.dao;

import ensup.business.Course;
import ensup.business.Role;

public interface ICourseDao extends IDao<Course> {

    /**
     *
     * @param course
     * @return
     */
    void addCourse(Course course);

    /**
     *
     * @param course
     * @return
     */
    int updateCourse(Course course);
}
