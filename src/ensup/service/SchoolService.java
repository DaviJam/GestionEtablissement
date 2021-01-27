package ensup.service;

import java.util.ArrayList;
import java.util.List;

import ensup.business.School;
import ensup.dao.SchoolDao;
import ensup.dto.SchoolDTO;
import ensup.exception.dao.ExceptionDao;
import ensup.exception.service.ExceptionService;
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

	public List<SchoolDTO> getAll() throws ExceptionService
	{
		List<SchoolDTO> listSchoolDto = new ArrayList<SchoolDTO>();

		try{
			for (School school: this.dao.getAll())
				listSchoolDto.add(SchoolMapper.businessToDto(school));

			return listSchoolDto;
		}catch(ExceptionDao e){
			throw new ExceptionService(e.getMessage());
		}

	}

	public SchoolDTO get(int index) throws ExceptionService
	{

		try{
			return SchoolMapper.businessToDto(this.dao.get(index));
		} catch(ExceptionDao e){
			throw new ExceptionService(e.getMessage());
		}
	}

	public int create(SchoolDTO schoolDto) throws ExceptionService
	{
		try{
			return this.dao.create(SchoolMapper.dtoToBusiness(schoolDto));
		} catch(ExceptionDao e){
			throw new ExceptionService(e.getMessage());
		}

	}

	public int update(SchoolDTO schoolDto) throws ExceptionService
	{
		School school = SchoolMapper.dtoToBusiness(schoolDto);
		school.setId(schoolDto.getId());
		try{
			return this.dao.update(school);
		} catch(ExceptionDao e){
			throw new ExceptionService(e.getMessage());
		}

	}

	public int delete(SchoolDTO schoolDto) throws ExceptionService
	{
		try{
			return this.dao.delete(schoolDto.getId());
		} catch(ExceptionDao e){
			throw new ExceptionService(e.getMessage());
		}



	}
	
	public int delete(int index) throws ExceptionService
	{
		try
		{
			return this.dao.delete(index);
		} catch(ExceptionDao e){
			throw new ExceptionService(e.getMessage());
		}
	}

	/**
	 * Gets index.
	 *
	 * @param surname the surname
	 * @return the index
	 */
	public int getIndex( String surname ) throws ExceptionService
	{
		try
		{
			return this.dao.getIndex(surname);
		} catch(ExceptionDao e){
			throw new ExceptionService(e.getMessage());
		}

	}
}
