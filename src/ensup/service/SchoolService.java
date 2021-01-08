package ensup.service;

import java.util.ArrayList;
import java.util.List;

import ensup.business.School;
import ensup.dao.SchoolDao;
import ensup.dto.SchoolDTO;
import ensup.mapper.SchoolMapper;

/**
 * The type School service.
 */
public class SchoolService implements ISchoolService
{
	private SchoolDao dao;

	/**
	 * Instantiates a new School service.
	 */
	public SchoolService()
	{
		this.dao = new SchoolDao();
	}

	public List<SchoolDTO> getAll()
	{
		List<SchoolDTO> listSchoolDto = new ArrayList<SchoolDTO>();
		
		for (School school: this.dao.getAll())
			listSchoolDto.add(SchoolMapper.businessToDto(school));
		
		return listSchoolDto;
	}

	public SchoolDTO get(int index)
	{
		return SchoolMapper.businessToDto(this.dao.get(index));
	}

	public int create(SchoolDTO schoolDto)
	{
		return this.dao.create(SchoolMapper.dtoToBusiness(schoolDto));
	}

	public int update(SchoolDTO schoolDto)
	{
		School school = SchoolMapper.dtoToBusiness(schoolDto);
		school.setId(schoolDto.getId());

		return this.dao.update(school);
	}

	public int delete(SchoolDTO schoolDto)
	{
		return delete(schoolDto.getId());
	}
	
	public int delete(int index)
	{
		return this.dao.delete(index);
	}

	/**
	 * Gets index.
	 *
	 * @param surname the surname
	 * @return the index
	 */
	public int getIndex( String surname )
	{
		return this.dao.getIndex(surname);
	}
}
