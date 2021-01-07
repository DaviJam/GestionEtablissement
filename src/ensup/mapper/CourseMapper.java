package ensup.mapper;

import ensup.business.Course;
import ensup.dto.CourseDTO;

public class CourseMapper
{
    public static CourseDTO businessToDto(Course course){

        CourseDTO newCourseDto = new CourseDTO();

        newCourseDto.setId(course.getId());
        newCourseDto.setCourseSubject(course.getCourseSubject());
        newCourseDto.setNbHours(course.getNbHours());

        return newCourseDto;
    };

    public static Course dtoToBusiness(CourseDTO coursedto){

        Course newCourse = new Course();

        newCourse.setId(coursedto.getId());
        newCourse.setCourseSubject(coursedto.getCourseSubject());
        newCourse.setNbHours(coursedto.getNbHours());

        return newCourse;
    };
}
