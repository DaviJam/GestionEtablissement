package ensup.mapper;

import ensup.business.Manager;
import ensup.dto.ManagerDTO;

public class ManagerMapper {
    public ManagerDTO businessToDto(Manager manager){
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setFirstname(manager.getLastname());
        managerDTO.setLastname(manager.getLastname());
        managerDTO.setMailAddress(manager.getMailAddress());
        managerDTO.setAddress(manager.getAddress());
        managerDTO.setPassword(manager.getPassword());
        managerDTO.setRole(manager.getRole());
        managerDTO.setId(manager.getId());
        managerDTO.setPhoneNumber(manager.getPhoneNumber());
        return managerDTO;
    };

    public Manager dtoToBusiness(ManagerDTO managerDto){
        Manager manager = new Manager();
        manager.setFirstname(managerDto.getLastname());
        manager.setLastname(managerDto.getLastname());
        manager.setMailAddress(managerDto.getMailAddress());
        manager.setAddress(managerDto.getAddress());
        manager.setPassword(managerDto.getPassword());
        manager.setRole(managerDto.getRole());
        manager.setId(managerDto.getId());
        manager.setPhoneNumber(managerDto.getPhoneNumber());
        return manager;
    };
}
