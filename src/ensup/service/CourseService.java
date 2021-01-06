package ensup.service;

import java.util.List;

import ensup.business.Course;
import ensup.dao.CourseDao;

public class CourseService implements ICourseService
{
	private CourseDao dao;
	
	public CourseService()
	{
		this.dao = new CourseDao();
	}

	public Course get(int index)
	{
		return this.dao.get(index);
	}
	
	public List<Course> getAll()
	{
		return this.dao.getAll();
	}

	public void create(String subject, float nbHours)
	{
		Course cours = new Course(subject, nbHours);
		
		this.dao.create( cours );
	}
	
	public void update(String subject, float nbHours)
	{
		Course cours = new Course(subject, nbHours);
		
		this.dao.update( cours );
	}

	public void delete(Course cours)
	{
		this.dao.delete(cours);
	}
}
