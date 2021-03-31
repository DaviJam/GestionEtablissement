package eu.ensup.gestionetablissement.dao;

import static eu.ensup.gestionetablissement.dao.Connect.openConnection;
import static org.junit.jupiter.api.Assertions.*;

import eu.ensup.gestionetablissement.business.Course;
import eu.ensup.gestionetablissement.business.Person;
import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Unit test for simple App.
 */
public class DaoTest
{
    PersonDao daoPerson = null;
    CourseDao daoCourse = null;

    @BeforeEach
    public void SetUp() throws ExceptionDao {
        openConnection();
        daoCourse = new CourseDao();
        daoPerson = new PersonDao();
    }

    @Test
    @DisplayName("get person and check is not nul")
    @Tag("PersonDaoTest")
    public void personNotNull() throws ExceptionDao {
        Person p = null;
        p = daoPerson.get(121);
        assertNotNull(p);
        assertThat(p, notNullValue(Person.class));
    }

    @Test
    @DisplayName("Person should remain null")
    @Tag("PersonDaoTest")
    public void personIsNull() {
        Person p = null;
        try {
            p = daoPerson.get(0); //Fail
        } catch (ExceptionDao exceptionDao) {
            exceptionDao.printStackTrace();
        }
        assertNull(p);
        assertThat(p, nullValue(Person.class));
    }

    @Test
    @DisplayName("get person and check his first name is Moulin")
    @Tag("PersonDaoTest")
    public void personNameEqual() throws ExceptionDao {
        Person p = null;
        p = daoPerson.get(121);
        assertEquals(p.getLastname(), "Moulin");
        assertThat(p.getId(), is(121));
    }

    @Test
    @DisplayName("get person and check his first name is not Parcher")
    @Tag("PersonDaoTest")
    public void personNameNotEqual() throws ExceptionDao {
        Person p = null;
        p = daoPerson.get(117);
        assertNotEquals(p.getFirstname(), "Parcher");
        assertThat(p.getId(), not(116));
    }


    @Test
    @DisplayName("Person role should be greater than 3")
    @Tag("PersonDaoTest")
    public void personRoleIsGreaterThan3() throws ExceptionDao {
        Person p = null;
        p = daoPerson.get(127); //Success
        assertTrue(p.getRole().getNum() > 3);
    }

    @Test
    @DisplayName("Person role should be less than 3")
    @Tag("PersonDaoTest")
    public void personRoleIsLessThan3() throws ExceptionDao {
        Person p = null;
        p = daoPerson.get(7); //Success
        assertFalse(p.getRole().getNum() > 3);
    }

    @Test
    @DisplayName("Should throw because not in database")
    @Tag("PersonDaoTest")
    public void PersonNotExistInDatabase()
    {
        ExceptionDao exception = assertThrows(ExceptionDao.class , () -> daoPerson.get(2));
        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Impossible de récupérer les informations de cette personne."));
    }

    @Test
    @DisplayName("Instance of person")
    @Tag("PersonDaoTest")
    public void IsInstanceOfPerson() throws ExceptionDao {
        Person p = null;
        p = daoPerson.get(121);
        assertInstanceOf(Person.class, p);
    }

    @Test
    @DisplayName("Courses should be equal")
    @Tag("CourseDaoTest")
    public void CompareCourseSame() throws ExceptionDao {
        Course c = new Course();
        c.setId(81);
        c.setCourseSubject("EPS");
        c.setNbHours(4.0f);

        assertSame(c, c);
    }

    @Test
    @DisplayName("Courses should be equal")
    @Tag("CourseDaoTest")
    public void CompareCourseNotSame() throws ExceptionDao {
        Course c = new Course();
        c.setId(81);
        c.setCourseSubject("EPS");
        c.setNbHours(2);

        Course fetchedC= null;
        fetchedC = daoCourse.get(81); //Success
        assertNotNull(fetchedC);
        assertNotSame(fetchedC, c);
    }

//    @Test
//    @DisplayName("Get Course index")
//    @Tag("CourseDaoTest")
//    public void CompareCourseSameIndex() throws ExceptionDao {
//        int cIndex = daoCourse.getIndex("EPS", 4); //Success
//        assertThat(cIndex ,equalTo(81));
//    }

    @Test
    @DisplayName("Get Course index")
    @Tag("CourseDaoTest")
    public void UpdateAndCompareCourseSameNbHours() throws ExceptionDao {
        Course c = new Course();
        c.setId(81);
        c.setCourseSubject("EPS");
        c.setNbHours(2);

        daoCourse.update(c); //Success
        Course d = daoCourse.get(81);
        assertThat(c.getNbHours() ,equalTo(d.getNbHours()));
    }

}

/*
@org.junit.jupiter.api.Test
void exampleTest() {
    Assertions.assertTrue(trueBool);
    Assertions.assertFalse(falseBool);

    Assertions.assertNotNull(notNullString);
    Assertions.assertNull(notNullString);

    Assertions.assertNotSame(originalObject, otherObject);
    Assertions.assertEquals(4, 4);
    Assertions.assertNotEquals(3, 2);

    Assertions.assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3}, "Array Equal Test");

    Iterable<Integer> listOne = new ArrayList<>(Arrays.asList(1,2,3,4));
    Iterable<Integer> listTwo = new ArrayList<>(Arrays.asList(1,2,3,4));
    Assertions.assertIterableEquals(listOne, listTwo);

    Assertions.assertTimeout(Duration.ofMillis(100), () -> {
    Thread.sleep(50);
    return "result";
    });

    Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
    throw new IllegalArgumentException("error message");
    });

    Assertions.fail("not found good reason to pass");
}
 */