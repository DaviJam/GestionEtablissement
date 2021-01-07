package ensup.tests;

import java.util.List;

import ensup.business.Director;
import ensup.business.Person;
import ensup.business.School;
import ensup.dao.DaoPerson;
import ensup.dao.SchoolDao;

public class TestDaoSchool
{
	private SchoolDao dao;
	
	public TestDaoSchool()
	{
		System.out.println("Constructor TestSchoolDao");
		dao = new SchoolDao();
	}
	
	public void testGetAll()
	{
		System.out.println("\nTest GetAll");
		List<School> lSchool = this.dao.getAll();
		for( School school : lSchool )
		{
			System.out.println(((School)school).toString());
		}
	}
	
	public void testCreate()
	{
		System.out.println("\nTest Create");
		
		this.dao.create(new School("Ensup", "ensup@gmail.com", "...", "0000", 34));
	}
	
	public void testGet()
	{
		System.out.println("\nTest Get");
		System.out.println(this.dao.get(4));
	}
	
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
	
	public void testDelete()
	{
		System.out.println("\nTest Delete");
		try {
			this.dao.delete(this.dao.get(4));
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	public static void main(String[] args)
	{
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
