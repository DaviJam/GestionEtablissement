package ensup.service;

import java.util.List;

import ensup.business.Course;
import ensup.dao.DaoCourse;

public class ServiceCourse implements IServiceCourse
{
	private DaoCourse dao;
	
	public ServiceCourse()
	{
		this.dao = new DaoCourse();
	}
	
	public Course get(int index)
	{
		return this.dao.get(index);
	}
	
	public List<Course> getAll()
	{
		return this.dao.getAll();
	}

	public int createCourse(Course entity) {
		return this.dao.createCourse(entity);
	}

	public int create(String subject, float nbHours)
	{
		Course cours = new Course(subject, nbHours);
		
		return this.dao.create( cours );
	}
	
	public int update(String subject, float nbHours)
	{
		Course cours = new Course(subject, nbHours);
		
		return this.dao.update( cours );
	}

	public int delete(int index)
	{
		return this.dao.delete(index);
	}
	
	public int getIndex( String coursesubject, float nbhours )
	{
		return this.dao.getIndex(coursesubject, nbhours);
	}
}
