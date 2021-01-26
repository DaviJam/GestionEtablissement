package ensup.tests;

import ensup.dao.ExceptionDao;
import ensup.dto.CourseDTO;
import ensup.service.CourseService;
import ensup.service.ICourseService;

public class TestDtoCourse
{
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws ExceptionDao {
        // On appelle le service
        ICourseService courseservice = new CourseService();

        // Get All
        for(CourseDTO courseDto : courseservice.getAll()){
            System.out.println(courseDto);
        }
        // Get
         System.out.println("\n"+courseservice.get(62));
        // Create
        CourseDTO coursebrice2 = new CourseDTO("Cours de DTO", 33);
        courseservice.create(coursebrice2);
        // Update
        CourseDTO course123 = courseservice.get(62);
        course123.setCourseSubject("TEST FINAL 2");
        course123.setNbHours(420);
        courseservice.update(course123);
        System.out.println("\n"+courseservice.get(62));
        // Delete
        //CourseDTO course70 = courseservice.get(63);
        //courseservice.delete(course70);
    }
}
