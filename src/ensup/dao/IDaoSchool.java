package ensup.dao;

import ensup.business.School;

public interface IDaoSchool extends IDao<School>
{
	/**
	 * Get the index of the school with this surname
	 * 
	 * @param surname surname of the School
	 * @return type of return
	 */
	public int getIndex( String surname );
	
	/**
	 * Know if the index exist or not in the table School
	 * 
	 * @param index index of the school
	 * @return if the index exist or not
	 */
	public boolean indexExist(int index);
}
