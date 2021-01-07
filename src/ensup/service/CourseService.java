package ensup.service;

import ensup.business.Course;
import ensup.dao.CourseDao;
import ensup.dto.CourseDTO;
import ensup.mapper.CourseMapper;

import java.util.ArrayList;
import java.util.List;

public class CourseService implements ICourseService
{
	private CourseDao dao;

	private CourseMapper mapper = new CourseMapper();

	public CourseService()
	{
		this.dao = new CourseDao();
	}

	public List<CourseDTO> getAll() {

		List<Course> listCourse = this.dao.getAll();
		List<CourseDTO> listCourseDto = new ArrayList<>();
		CourseDTO cdto = new CourseDTO();

		for (Course c: this.dao.getAll()) {
			cdto = mapper.businessToDto(c);
			listCourseDto.add(cdto);
		}

		return listCourseDto;
	}

	public CourseDTO get(int index)
	{
		Course course = this.dao.get(index);
		CourseDTO courseDTO = mapper.businessToDto(course);

		return courseDTO;
	}

	public int create(CourseDTO courseDto) {

		Course entity = this.mapper.dtoToBusiness(courseDto);
		return this.dao.create(entity);
	}

	public int update(CourseDTO courseDto) {

		Course course = this.mapper.dtoToBusiness(courseDto);
		course.setId(courseDto.getId());

		return this.dao.update(course);
	}

	public int delete(CourseDTO courseDto)
	{
		Course entity = this.mapper.dtoToBusiness(courseDto);
		return this.dao.delete(entity);
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
