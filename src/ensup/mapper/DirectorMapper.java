package ensup.mapper;

import ensup.business.Director;
import ensup.dto.DirectorDTO;

public class DirectorMapper {
    public DirectorDTO businessToDto(Director director){
        DirectorDTO directorDTO = new DirectorDTO();
        directorDTO.setFirstname(director.getLastname());
        directorDTO.setLastname(director.getLastname());
        directorDTO.setMailAddress(director.getMailAddress());
        directorDTO.setAddress(director.getAddress());
        directorDTO.setPassword(director.getPassword());
        directorDTO.setRole(director.getRole());
        directorDTO.setId(director.getId());
        directorDTO.setPhoneNumber(director.getPhoneNumber());
        return directorDTO;
    };

    public Director dtoToBusiness(DirectorDTO directorDTO){
        Director director = new Director();
        director.setFirstname(directorDTO.getLastname());
        director.setLastname(directorDTO.getLastname());
        director.setMailAddress(directorDTO.getMailAddress());
        director.setAddress(directorDTO.getAddress());
        director.setPassword(directorDTO.getPassword());
        director.setRole(directorDTO.getRole());
        director.setId(directorDTO.getId());
        director.setPhoneNumber(directorDTO.getPhoneNumber());
        return director;
    };
}
