package ensup.tests;

import java.util.List;

import ensup.business.Course;
import ensup.dao.CourseDao;

public class TestDaoCourse
{
	private CourseDao dao;
	
	public TestDaoCourse()
	{
		System.out.println("Constructor TestCourseDao");
		dao = new CourseDao();
	}
	
	public void testGetAll()
	{
		System.out.println("\nTest GetAll");
		List<Course> lCouses = this.dao.getAll();
		for( Course course : lCouses )
		{
			System.out.println(course.toString());
		}
	}
	
	public void testCreate()
	{
		System.out.println("\nTest Create");
		this.dao.create(new Course("Math",        15, 1));
		this.dao.create(new Course("Science",     10, 2));
		this.dao.create(new Course("Francais",    20, 3));
		this.dao.create(new Course("Anglais",     15, 4));
		this.dao.create(new Course("Sport",       10, 5));
		this.dao.create(new Course("Dessin",       9, 6));
		this.dao.create(new Course("technologie",  8, 7));
		this.dao.create(new Course("Informatique", 2, 8));
		this.dao.create(new Course("Musique",      9, 9));
	}
	
	public void testGet()
	{
		System.out.println("\nTest Get");
		for(int index = 1; index < 10; index++)
		{
			try {
				System.out.println(this.dao.get(index));
			}
			catch(Exception e) { e.printStackTrace(); }
		}
	}
	
	public void testUpdate()
	{
		System.out.println("\nTest Update");
		for(int index = 1; index < 10; index++)
		{
			try {
				Course cou = this.dao.get(index);
				cou.setCourseSubject("Informatique");
				this.dao.update(cou);
			}
			catch(Exception e) { e.printStackTrace(); }
		}
	}
	
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

	public static void main(String[] args)
	{
		System.out.println("START TEST");
		
		TestDaoCourse tcd = new TestDaoCourse();
		
		tcd.testGetAll();
		
		tcd.testCreate();
		tcd.testGet();

		tcd.testUpdate();
		tcd.testGet();
		
		tcd.testDelete();
		tcd.testGet();
		
		System.out.println("END TEST");
	}
}
