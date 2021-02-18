package ensup.service;

import ensup.business.Mark;
import ensup.dao.MarkDao;
import ensup.dto.MarkDTO;
import ensup.exception.dao.ExceptionDao;
import ensup.exception.service.ExceptionService;
import ensup.mapper.MarkMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Mark service.
 */
public class MarkService implements IMarkService {
    
    private MarkDao dao;    // nom de la classe
    /**
     * The Class name.
     */
    String className = getClass().getName();

    /**
     * Instantiates a new Mark service.
     */
    public MarkService() {
        this.dao = new MarkDao();
    }

    public List<MarkDTO> getAll() throws ExceptionService {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        List<MarkDTO> listCourseDto = new ArrayList<MarkDTO>();

        try {
            for (Mark c : this.dao.getAll())
                listCourseDto.add(MarkMapper.businessToDto(c));
        } catch (ExceptionDao exceptionDao) {
            throw new ExceptionService(exceptionDao.getMessage());
        }

        return listCourseDto;
    }

    public MarkDTO get(int index) throws ExceptionService {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        MarkDTO markDTO;
        try {
            markDTO = MarkMapper.businessToDto(this.dao.get(index));
        } catch (ExceptionDao exceptionDao) {
            serviceLogger.logServiceError(className, methodName,"Un problème est survenue lors de l'appel à cette méthode.");
            throw new ExceptionService(exceptionDao.getMessage());
        }
        return markDTO;
    }

    public int create(MarkDTO courseDto) throws ExceptionService {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        int res;
        try {
            res = this.dao.create(MarkMapper.dtoToBusiness(courseDto));
        } catch (ExceptionDao exceptionDao) {
            serviceLogger.logServiceError(className, methodName,"Un problème est survenue lors de l'appel à cette méthode.");
            throw new ExceptionService(exceptionDao.getMessage());
        }
        return res;
    }

    public int update(MarkDTO courseDto) throws ExceptionService {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        Mark course = MarkMapper.dtoToBusiness(courseDto);
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

    public int delete(MarkDTO courseDto) throws ExceptionService {
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
}
