package ensup.dao;

import ensup.business.Mark;
import ensup.exception.dao.ExceptionDao;

/**
 * The interface Course dao.
 */
public interface IMarkDao extends IDao<Mark>
{
	/**
	 * Know if the index exist or not in the table Course
	 *
	 * @param index index of the course
	 * @return if the index exist
	 */
	public boolean indexExist(int index) throws ExceptionDao;
}
