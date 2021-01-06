package ensup.tests;

import java.util.ArrayList;
import java.util.List;

import ensup.business.Course;
import ensup.dao.CourseDao;

public class TestCourseDao
{
	private CourseDao dao;
	
	public TestCourseDao()
	{
		System.out.println("Constructor TestCourseDao");
		dao = new CourseDao();
	}
	
	public void testCreate()
	{
		System.out.println("Test Create");
		this.dao.create(new Course("Math", 15));
		this.dao.create(new Course("Science", 10));
		this.dao.create(new Course("Francais", 20));
		this.dao.create(new Course("Anglais", 15));
		this.dao.create(new Course("Sport", 10));
		this.dao.create(new Course("Dessin", 9));
	}
	
	public void testGetAll()
	{
		System.out.println("Test GetAll");
		List<Course> lCouses = this.dao.getAll();
		for( Course course : lCouses )
		{
			System.out.println(course.toString());
		}
	}

	public static void main(String[] args)
	{
		System.out.println("START TEST");
		
		TestCourseDao tcd = new TestCourseDao();
		tcd.testCreate();
		tcd.testGetAll();
		
		System.out.println("END TEST");
	}
}
