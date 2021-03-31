package eu.ensup.gestionetablissement.service;

import eu.ensup.gestionetablissement.dao.ExceptionDao;
import eu.ensup.gestionetablissement.dto.CourseDTO;

/**
 * The interface Course service.
 */
public interface ICourseService extends IService<CourseDTO>
{
    /**
     *
     * @param coursesubject
     * @param nbhours
     * @return
     * @throws ExceptionService
     */
    public int getIndex(String coursesubject, float nbhours) throws ExceptionService, ExceptionDao;
}
