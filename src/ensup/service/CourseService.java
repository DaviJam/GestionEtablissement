package ensup.service;

import ensup.business.Course;
import ensup.dao.CourseDao;
import ensup.dto.CourseDTO;
import ensup.exception.dao.ExceptionDao;
import ensup.exception.service.ExceptionService;
import ensup.mapper.CourseMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Course service.
 */
public class CourseService implements ICourseService {
    private CourseDao dao;

    /**
     * Instantiates a new Course service.
     */
    public CourseService() {
        this.dao = new CourseDao();
    }

    public List<CourseDTO> getAll() throws ExceptionService {
        List<CourseDTO> listCourseDto = new ArrayList<CourseDTO>();

		try {
			for (Course c : this.dao.getAll())
				listCourseDto.add(CourseMapper.businessToDto(c));
		} catch (ExceptionDao exceptionDao) {
			new ExceptionService(exceptionDao.getMessage());
		}

		return listCourseDto;
    }

	public CourseDTO get(int index) throws ExceptionService {
		try {
			return CourseMapper.businessToDto(this.dao.get(index));
		} catch (ExceptionDao exceptionDao) {
			new ExceptionService(exceptionDao.getMessage());
		}
		return null;
	}

	public int create(CourseDTO courseDto) throws ExceptionService {
		try {
			return this.dao.create(CourseMapper.dtoToBusiness(courseDto));
		} catch (ExceptionDao exceptionDao) {
			new ExceptionService(exceptionDao.getMessage());
		}
		return 0;
	}

	public int update(CourseDTO courseDto) throws ExceptionService {
		Course course = CourseMapper.dtoToBusiness(courseDto);
		course.setId(courseDto.getId());

		try {
			return this.dao.update(course);
		} catch (ExceptionDao exceptionDao) {
			new ExceptionService(exceptionDao.getMessage());
		}
		return 0;
	}

	public int delete(CourseDTO courseDto) throws ExceptionService {
		return delete(courseDto.getId());
	}
	
	public int delete(int index) throws ExceptionService {
		try {
			return this.dao.delete(index);
		} catch (ExceptionDao exceptionDao) {
			new ExceptionService(exceptionDao.getMessage());
		}
		return 0;
	}

    /**
     * Gets index.
     *
     * @param coursesubject the coursesubject
     * @param nbhours       the nbhours
     * @return the index
     */
    public int getIndex(String coursesubject, float nbhours) throws ExceptionDao {
        return this.dao.getIndex(coursesubject, nbhours);
    }
}
