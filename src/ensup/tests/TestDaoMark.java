package ensup.tests;

import ensup.business.Mark;
import ensup.dao.MarkDao;
import ensup.exception.dao.ExceptionDao;

import java.util.List;

/**
 * The type Test dao mark.
 */
public class TestDaoMark
{
	private MarkDao dao;

	/**
	 * Instantiates a new Test dao mark.
	 */
	public TestDaoMark()
	{
		System.out.println("Constructor TestCourseDao");
		dao = new MarkDao();
	}

	/**
	 * Test get all.
	 */
	public void testGetAll() throws ExceptionDao {
		System.out.println("\nTest GetAll");
		List<Mark> lCouses = this.dao.getAll();
		for( Mark mark : lCouses )
		{
			System.out.println(mark.toString());
		}
	}

	/**
	 * Test create.
	 */
	public void testCreate() throws ExceptionDao {
		System.out.println("\nTest Create");
		this.dao.create(new Mark(1, 117, 79, 12.5f,"Hello"));
		this.dao.create(new Mark(2, 118, 80, 15.5f,null));
	}

	/**
	 * Test get.
	 */
	public void testGet()
	{
		System.out.println("\nTest Get");

		try {
			System.out.println(this.dao.get(1));
		}
		catch(Exception e) { e.printStackTrace(); }

	}

	/**
	 * Test update.
	 */
	public void testUpdate()
	{
		System.out.println("\nTest Update");
		for(int index = 1; index < 10; index++)
		{
			try {
				Mark mark = this.dao.get(index);
				mark.setAssessment("Informatique");
				this.dao.update(mark);
			}
			catch(Exception e) { e.printStackTrace(); }
		}
	}

	/**
	 * Test delete.
	 */
	public void testDelete()
	{
		System.out.println("\nTest Delete");
		for(int index = 1; index < 10; index++)
		{
			try {
				this.dao.delete(this.dao.get(index));
			}
			catch(Exception e) { e.printStackTrace(); }
		}
	}

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) throws ExceptionDao {
		System.out.println("START TEST");
		
		TestDaoMark tcd = new TestDaoMark();
		
		tcd.testGetAll();
		
		//tcd.testCreate();
		tcd.testGet();

		//tcd.testUpdate();
		//tcd.testGet();

		//tcd.testDelete();
		//tcd.testGet();
		
		System.out.println("END TEST");
	}
}
