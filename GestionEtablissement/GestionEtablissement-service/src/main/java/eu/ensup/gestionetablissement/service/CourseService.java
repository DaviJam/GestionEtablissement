package eu.ensup.gestionetablissement.service;

import eu.ensup.gestionetablissement.business.Course;
import eu.ensup.gestionetablissement.dao.CourseDao;
import eu.ensup.gestionetablissement.dto.CourseDTO;
import eu.ensup.gestionetablissement.dao.ExceptionDao;
import eu.ensup.gestionetablissement.mapper.CourseMapper;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Course service.
 */
public class CourseService implements ICourseService {
    private CourseDao dao;    // nom de la classe
	/**
	 * The Class name.
	 */
	String className = getClass().getName();

	/**
	 * Instantiates a new Course service.
	 */
	public CourseService() {
//        this.dao = new CourseDao();
    }

	/**
	 * Instantiates a new Course service.
	 *
	 * @param dao the dao
	 */
	public CourseService(CourseDao dao) {
		this.dao = dao;
	}

    public List<CourseDTO> getAll() throws ExceptionService {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        List<CourseDTO> listCourseDto = new ArrayList<CourseDTO>();

		try {
			for (Course c : this.dao.getAll())
				listCourseDto.add(CourseMapper.businessToDto(c));
		} catch (ExceptionDao exceptionDao) {
			throw new ExceptionService(exceptionDao.getMessage());
		}

		return listCourseDto;
    }

	public CourseDTO get(int index) throws ExceptionService {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		CourseDTO courseDTO;
    	try {
			courseDTO = CourseMapper.businessToDto(this.dao.get(index));
		} catch (ExceptionDao exceptionDao) {
			serviceLogger.logServiceError(className, methodName,"Un problème est survenue lors de l'appel à cette méthode.");
			throw new ExceptionService(exceptionDao.getMessage());
		}
		return courseDTO;
	}

	public int create(CourseDTO courseDto) throws ExceptionService {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		int res;
    	try {
			res = this.dao.create(CourseMapper.dtoToBusiness(courseDto));
		} catch (ExceptionDao exceptionDao) {
			serviceLogger.logServiceError(className, methodName,"Un problème est survenue lors de l'appel à cette méthode.");
			throw new ExceptionService(exceptionDao.getMessage());
		}
		return res;
	}

	public int update(CourseDTO courseDto) throws ExceptionService {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		Course course = CourseMapper.dtoToBusiness(courseDto);
		course.setId(courseDto.getId());
		int ret;
		try {
			ret = this.dao.update(course);
		} catch (ExceptionDao exceptionDao) {
			serviceLogger.logServiceError(className, methodName,"Un problème est survenue lors de l'appel à cette méthode.");
			throw new ExceptionService(exceptionDao.getMessage());
		}
		return ret;
	}

	public int delete(CourseDTO courseDto) throws ExceptionService {
		return delete(courseDto.getId());
	}
	
	public int delete(int index) throws ExceptionService {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		int ret;
    	try {
			ret = this.dao.delete(index);
		} catch (ExceptionDao exceptionDao) {
			serviceLogger.logServiceError(className, methodName,"Un problème est survenue lors de l'appel à cette méthode.");
			throw new ExceptionService(exceptionDao.getMessage());
		}
		return ret;
	}

	/**
	 * Gets index.
	 *
	 * @param coursesubject the coursesubject
	 * @param nbhours       the nbhours
	 * @return the index
	 * @throws ExceptionDao the exception dao
	 */
	public int getIndex(String coursesubject, float nbhours) throws ExceptionDao {
        return this.dao.getIndex(coursesubject, nbhours);
    }
}
