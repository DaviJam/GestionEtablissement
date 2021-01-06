package ensup;

import ensup.business.Course;
import ensup.service.CourseService;
import ensup.service.ICourseService;

public class Main
{
    public static void main(String[] args)
    {
        ICourseService courseservice = new CourseService();


        // System.out.println(courseservice.get(1));

        Course coursebrice = new Course("Education Sexuelle", 69);
        courseservice.createCourse(coursebrice);

        //courseservice.getAll();


    }
}
