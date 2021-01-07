package ensup.service;

import java.util.List;

import ensup.business.Director;
import ensup.business.School;
import ensup.dao.DaoPerson;
import ensup.dao.DaoSchool;

public class ServiceSchool implements IServiceSchool
{
	private DaoSchool dao;
	
	public ServiceSchool()
	{
		this.dao = new DaoSchool();
	}
	
	public School get(int index)
	{
		return this.dao.get(index);
	}
	
	public List<School> getAll()
	{
		return this.dao.getAll();
	}
	
	public int create(String surname, String email, String address, String phone, int director)
	{
		DaoPerson pers = new DaoPerson();
		School school = new School(surname, email, address, phone, (Director)pers.get(director));
		
		return this.dao.create( school );
	}
	
	public int update(String surname, String email, String address, String phone, int director)
	{
		DaoPerson pers = new DaoPerson();
		School school = new School(surname, email, address, phone, (Director)pers.get(director));
		
		return this.dao.update( school );
	}

	public int delete(int index)
	{
		return this.dao.delete(index);
	}
	
	public int getIndex( String surname )
	{
		return this.dao.getIndex(surname);
	}
}
