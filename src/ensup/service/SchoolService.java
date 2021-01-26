package ensup.service;

import java.util.ArrayList;
import java.util.List;

import ensup.business.School;
import ensup.dao.ExceptionDao;
import ensup.dao.SchoolDao;
import ensup.dto.SchoolDTO;
import ensup.mapper.SchoolMapper;

/**
 * The type School service.
 */
public class SchoolService implements IService<SchoolDTO> {
	private SchoolDao dao;

	/**
	 * Instantiates a new School service.
	 */
	public SchoolService()
	{
		this.dao = new SchoolDao();
	}

	public List<SchoolDTO> getAll() throws ExceptionDao
	{
		List<SchoolDTO> listSchoolDto = new ArrayList<SchoolDTO>();
		
		for (School school: this.dao.getAll())
			listSchoolDto.add(SchoolMapper.businessToDto(school));
		
		return listSchoolDto;
	}

	public SchoolDTO get(int index) throws ExceptionDao
	{
		return SchoolMapper.businessToDto(this.dao.get(index));
	}

	public int create(SchoolDTO schoolDto) throws ExceptionDao
	{
		return this.dao.create(SchoolMapper.dtoToBusiness(schoolDto));
	}

	public int update(SchoolDTO schoolDto) throws ExceptionDao
	{
		School school = SchoolMapper.dtoToBusiness(schoolDto);
		school.setId(schoolDto.getId());

		return this.dao.update(school);
	}

	public int delete(SchoolDTO schoolDto) throws ExceptionDao
	{
		return delete(schoolDto.getId());
	}
	
	public int delete(int index) throws ExceptionDao
	{
		return this.dao.delete(index);
	}

	/**
	 * Gets index.
	 *
	 * @param surname the surname
	 * @return the index
	 */
	public int getIndex( String surname ) throws ExceptionDao
	{
		return this.dao.getIndex(surname);
	}
}
