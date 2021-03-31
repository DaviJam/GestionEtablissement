
package eu.ensup.gestionetablissement.dao;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import eu.ensup.gestionetablissement.business.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    static private CourseDao _course = new CourseDao();

    @Test
    @DisplayName("Get All Course")
    public void getAllCourseTest() throws ExceptionDao{
        int length = _course.getAll().size();
        assertEquals(8,length);
    }

    /**
    @Test
    @DisplayName("Get 1 Course")
    public void getCourseTest() throws ExceptionDao{
        Course coursed = _course.get(79);

        assertEquals("Français",coursed.);
    }
*/

}