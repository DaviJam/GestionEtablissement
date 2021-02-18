package ensup.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import ensup.business.Director;
import ensup.business.Manager;
import ensup.business.Person;
import ensup.business.Student;
import ensup.business.Teacher;
import ensup.dao.PersonDao;
import ensup.exception.service.ExceptionService;
import ensup.service.PersonService;

/**
 * The type Test dao person.
 */
public class TestDaoPerson {
    private PersonDao _dao;

    /**
     * Instantiates a new Test dao person.
     */
    public TestDaoPerson() {
        this._dao = new PersonDao();
    }
    

	
	public void testGetMoyenne() throws ExceptionService {
		float moyenne = (new PersonService()).getAverage(119);
		System.out.println("\nTest GetMoyenne: "+moyenne);
	}

    /**
     * Test create boolean.
     *
     * @return the boolean
     * @throws ParseException the parse exception
     */
    public boolean TestCreate() throws ParseException {
        boolean testRes = true;
        SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
        Person p1 = new Director("James", "newbo@gizup.fr", "Cherche bien 901 Dolodolo", "123456789", "Dada", "12345");
        Person p2 = new Manager("Filou", "grab@gizup.fr", "Cherche bien 901 Dolodolo", "1245","Fou","3251");
        Person p3 = new Teacher("Karmer", "givo@gizup.fr", "Cherche bien 901 Dolodolo", "3524", "12345", "3534", "Français");
        Person p4 = new Student("Glob", "gbg@gizup.fr", "Cherche bien 901 Dolodolo", "123456789", "Dada", "2521215", dateFmt.parse("09/25/2005"));
        try {
            if (_dao.create(p1) == 0) testRes = false;
            if (_dao.create(p2) == 0) testRes = false;
            if (_dao.create(p3) == 0) testRes = false;
            if (_dao.create(p4) == 0) testRes = false;
        } catch (Exception e)
        {
            System.out.println("Test Failed : exception " + e.toString());
            testRes = false;
        }
        return testRes;
    }

    /**
     * Test update boolean.
     *
     * @return the boolean
     * @throws ParseException the parse exception
     */
    public boolean TestUpdate() throws ParseException {
        boolean testRes = true;
        SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
        Person p1 = new Director("Glob", "nefbo@gizup.fr", "Cherche bien 901 Dolodolo", "123456789", "Dada", "12345");
        Person p2 = new Manager("Glob", "grab@gizup.fr", "Cherche bien 901 Dolodolo", "1245","Fou","3251");
        Person p3 = new Teacher("Glob", "givo@gizup.fr", "Cherche bien 901 Dolodolo", "3524", "12345", "3534", "Français");
        Person p4 = new Student("Glob", "gbg@gizup.fr", "Cherche bien 901 Dolodolo", "123456789", "Dada", "2521215", dateFmt.parse("09/25/2005"));
        try {
            if (_dao.update(p1) == 0) testRes = false;
            if (_dao.update(p2) == 0) testRes = false;
            if (_dao.update(p3) == 0) testRes = false;
            if (_dao.update(p4) == 0) testRes = false;
        } catch (Exception e)
        {
            System.out.println("Test Failed : exception " + e.toString());
            testRes = false;
        }
        return testRes;
    }

    /**
     * Test get all boolean.
     *
     * @return the boolean
     * @throws ParseException the parse exception
     */
    public boolean TestGetAll() throws ParseException {
        AtomicBoolean testRes = new AtomicBoolean(true);
        SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
        Person p1 = new Director("Glob", "newbo@gizup.fr", "Cherche bien 901 Dolodolo", "123456789", "Dada", "12345");
        Person p2 = new Manager("Glob", "grab@gizup.fr", "Cherche bien 901 Dolodolo", "1245","Fou","3251");
        Person p3 = new Teacher("Glob", "givo@gizup.fr", "Cherche bien 901 Dolodolo", "3524", "12345", "3534", "Français");
        Person p4 = new Student("Glob", "gbg@gizup.fr", "Cherche bien 901 Dolodolo", "123456789", "Dada", "2521215", dateFmt.parse("09/25/2005"));

        List<Person> personList = new ArrayList<Person>();

        /**
         * Get all the registered entities in the person table of the database
         */
        try {
        personList = _dao.getAll();
        } catch (Exception e)
        {
            System.out.println("Test Failed : exception " + e.toString());
            testRes.set(false);
        }

        personList.forEach(person -> {
            if(person instanceof Director) {
                if(!p1.isEqualTo(person)) testRes.set(false);
            } else if(person instanceof Manager) {
                if(!p2.isEqualTo(person)) testRes.set(false);
            } else if(person instanceof Teacher) {
                if(!p3.isEqualTo(person)) testRes.set(false);
            } else if(person instanceof Student) {
                if(!p4.isEqualTo(person)) testRes.set(false);
            }
        });
        return testRes.get();
    }

    /**
     * Test remove boolean.
     *
     * @return the boolean
     * @throws ParseException the parse exception
     */
//Todo : finish this
    public boolean TestRemove() throws ParseException {
        boolean testRes = true;
        SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
        Person p1 = new Director("Glob", "newbo@gizup.fr", "Cherche bien 901 Dolodolo", "123456789", "Dada", "12345");
        Person p2 = new Manager("Glob", "grab@gizup.fr", "Cherche bien 901 Dolodolo", "1245","Fou","3251");
        Person p3 = new Teacher("Glob", "givo@gizup.fr", "Cherche bien 901 Dolodolo", "3524", "12345", "3534", "Français");
        Person p4 = new Student("Glob", "gbg@gizup.fr", "Cherche bien 901 Dolodolo", "123456789", "Dada", "2521215", dateFmt.parse("09/25/2005"));
        try {
            if (_dao.update(p1) == 0) testRes = false;
            if (_dao.update(p2) == 0) testRes = false;
            if (_dao.update(p3) == 0) testRes = false;
            if (_dao.update(p4) == 0) testRes = false;
        } catch (Exception e)
        {
            System.out.println("Test Failed : exception " + e.toString());
            testRes = false;
        }
        return testRes;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        System.out.println("START TEST");

        TestDaoPerson tcp = new TestDaoPerson();
        try {
            tcp.TestCreate();
        }
        catch (Exception e )
        {
            System.out.println("TEST FAILED DUE TO EXCEPTION "+ e.toString());
        }
        System.out.println("END TEST");
    }
}
