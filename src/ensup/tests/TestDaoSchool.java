package ensup.tests;

import java.util.List;

import ensup.business.School;
import ensup.dao.ExceptionDao;
import ensup.dao.SchoolDao;

/**
 * The type Test dao school.
 */
public class TestDaoSchool
{
	private SchoolDao dao;

	/**
	 * Instantiates a new Test dao school.
	 */
	public TestDaoSchool()
	{
		System.out.println("Constructor TestSchoolDao");
		dao = new SchoolDao();
	}

	/**
	 * Test get all.
	 */
	public void testGetAll() throws ExceptionDao
	{
		System.out.println("\nTest GetAll");
		List<School> lSchool = this.dao.getAll();
		for( School school : lSchool )
		{
			System.out.println(((School)school).toString());
		}
	}

	/**
	 * Test create.
	 */
	public void testCreate() throws ExceptionDao {
		System.out.println("\nTest Create");
		
		this.dao.create(new School("Ensup", "ensup@gmail.com", "...", "0000", 34));
	}

	/**
	 * Test get.
	 */
	public void testGet() throws ExceptionDao {
		System.out.println("\nTest Get");
		System.out.println(this.dao.get(4));
	}

	/**
	 * Test update.
	 */
	public void testUpdate()
	{
		System.out.println("\nTest Update");
		try {
			School scl = this.dao.get(4);
			//scl.setAddress("branche 5 forets des Pain");
			scl.setAddress("...");
			this.dao.update(scl);
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	/**
	 * Test delete.
	 */
	public void testDelete()
	{
		System.out.println("\nTest Delete");
		try {
			this.dao.delete(this.dao.get(4));
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) throws ExceptionDao {
		System.out.println("START TEST");
		
		TestDaoSchool tcd = new TestDaoSchool();
		
		tcd.testGetAll();
		
		tcd.testCreate();
		tcd.testGet();

		tcd.testUpdate();
		tcd.testGet();
		
		//tcd.testDelete();
		tcd.testGet();
		
		System.out.println("END TEST");
	}
}
