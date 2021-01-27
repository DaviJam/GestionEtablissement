package ensup.service;

import ensup.business.Course;
import ensup.dao.CourseDao;
import ensup.dao.DaoException.ExceptionDao;
import ensup.dto.CourseDTO;
import ensup.mapper.CourseMapper;
import ensup.service.serviceException.ExceptionService;

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

        for (Course c : this.dao.getAll())
            listCourseDto.add(CourseMapper.businessToDto(c));

        return listCourseDto;
    }

    public CourseDTO get(int index) throws ExceptionService {
        return CourseMapper.businessToDto(this.dao.get(index));
    }

    public int create(CourseDTO courseDto) throws ExceptionService {
        try {
            return this.dao.create(CourseMapper.dtoToBusiness(courseDto));
        } catch (ExceptionDao e) {
            e.getMessage();
        }
        return 0;
    }

    public int update(CourseDTO courseDto) throws ExceptionService {
        Course course = CourseMapper.dtoToBusiness(courseDto);
        course.setId(courseDto.getId());
        try {
            return this.dao.update(course);
        } catch (ExceptionDao e) {
            e.getMessage();
        }
        return 0;
    }

    public int delete(CourseDTO courseDto) throws ExceptionService {
        return delete(courseDto.getId());
    }

    public int delete(int index) throws ExceptionService {
        return this.dao.delete(index);
    }

    /**
     * Gets index.
     *
     * @param coursesubject the coursesubject
     * @param nbhours       the nbhours
     * @return the index
     */
    public int getIndex(String coursesubject, float nbhours) {
        return this.dao.getIndex(coursesubject, nbhours);
    }
}
