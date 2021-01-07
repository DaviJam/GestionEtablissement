package ensup.dao;

import ensup.business.Course;
import ensup.business.Role;

public interface IDaoCourse extends IDao<Course>
{
	public int getIndex( String subject, float nbHours );
	public boolean idExiste(int index);
}