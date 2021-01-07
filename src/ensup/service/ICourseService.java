package ensup.service;	

import ensup.dto.CourseDTO;

public interface ICourseService extends IService<CourseDTO>
{
    /**
     * Create an course in the database.
     *
     * @param subject subject of the course
     * @param nbHours nbHours of the course
     * @return type of the result
     */
    //int create(String subject, float nbHours);
    
    /**
     * Update an course of the database.
     *
     * @param subject subject of the course
     * @param nbHours nbhours of the course
     * @return type of the result
     */
    //int update(String subject, float nbhours);
    
    /**
	 * Get the index of the course with the subject and the nbhours in the parameters
	 * 
	 * @param subject subject of the course
	 * @param nbhours nbhours of the course 
	 * @return type of return
	 */
    //public int getIndex( String subject, float nbhours );*/
}
