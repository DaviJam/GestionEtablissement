package ensup.dao;

import ensup.business.Course;

/**
 * The interface Course dao.
 */
public interface ICourseDao extends IDao<Course>
{
	/**
	 * Get the index of the course by this subject and this nbhours
	 *
	 * @param subject subject of the course
	 * @param nbhours nbhours of the course
	 * @return index of the course default -1
	 */
	public int getIndex( String subject, float nbhours );

	/**
	 * Know if the index exist or not in the table Course
	 *
	 * @param index index of the course
	 * @return if the index exist
	 */
	public boolean indexExist(int index);
}
