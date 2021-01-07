package ensup.service;

import java.util.Date;

public interface IServiceEntity<PersonDTO> extends IService<PersonDTO>
{
    /**
     * @param surname
     * @param mail
     * @param address
     * @param phone
     * @param firstname
     * @param password
     * @param role
     * @param dateofbirth
     * @param subjectTaught
     * @return type of the result
     */
    int create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught);
    
    int update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught);
    
    /**
     * @param idEtudiant
     * @param idCourse
     * @return
     */
    int linkToCourse(int idEtudiant, int idCourse);
}
