package ensup.dao;

import ensup.business.Course;

public interface IDaoCourse extends IDao<Course>
{
	/**
	 * Get the index of the course with the subject and the nbhours in the parameters
	 * 
	 * @param subject subject of the course
	 * @param nbhours nbhours of the course 
	 * @return type of return
	 */
	public int getIndex( String subject, float nbhours );
	
	/**
	 * Know if the index exist or not in the table Course
	 * 
	 * @param index index of the course
	 * @return if the index exist or not
	 */
	public boolean indexExist(int index);
	
    // Todo: delete
    int createCourse(Course entity);
}
