package ensup.service;

import ensup.business.Course;
import ensup.dao.CourseDao;
import ensup.dto.CourseDTO;
import ensup.mapper.CourseMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Course service.
 */
public class CourseService implements ICourseService
{
	private CourseDao dao;

	/**
	 * Instantiates a new Course service.
	 */
	public CourseService()
	{
		this.dao = new CourseDao();
	}

	public List<CourseDTO> getAll()
	{
		List<CourseDTO> listCourseDto = new ArrayList<CourseDTO>();
		
		for (Course c: this.dao.getAll())
			listCourseDto.add(CourseMapper.businessToDto(c));
		
		return listCourseDto;
	}

	public CourseDTO get(int index)
	{
		return CourseMapper.businessToDto(this.dao.get(index));
	}

	public int create(CourseDTO courseDto)
	{
		return this.dao.create(CourseMapper.dtoToBusiness(courseDto));
	}

	public int update(CourseDTO courseDto)
	{
		Course course = CourseMapper.dtoToBusiness(courseDto);
		course.setId(courseDto.getId());

		return this.dao.update(course);
	}

	public int delete(CourseDTO courseDto)
	{
		return delete(courseDto.getId());
	}
	
	public int delete(int index)
	{
		return this.dao.delete(index);
	}

	/**
	 * Gets index.
	 *
	 * @param coursesubject the coursesubject
	 * @param nbhours       the nbhours
	 * @return the index
	 */
	public int getIndex( String coursesubject, float nbhours )
	{
		return this.dao.getIndex(coursesubject, nbhours);
	}
}
