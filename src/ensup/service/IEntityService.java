package ensup.service;

import java.util.Date;

/**
 * The interface Service entity.
 *
 * @param <PersonDTO> the type parameter
 */
public interface IEntityService<PersonDTO> extends IService<PersonDTO>
{
    /**
     * Create int.
     *
     * @param surname       the surname
     * @param mail          the mail
     * @param address       the address
     * @param phone         the phone
     * @param firstname     the firstname
     * @param password      the password
     * @param role          the role
     * @param dateofbirth   the dateofbirth
     * @param subjectTaught the subject taught
     * @return type of the result
     */
    int create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught) throws ExceptionService;

    /**
     * Update int.
     *
     * @param surname       the surname
     * @param mail          the mail
     * @param address       the address
     * @param phone         the phone
     * @param firstname     the firstname
     * @param password      the password
     * @param role          the role
     * @param dateofbirth   the dateofbirth
     * @param subjectTaught the subject taught
     * @return the int
     */
    int update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught, double average) throws ExceptionService;

    /**
     * Link to course int.
     *
     * @param idEtudiant the id etudiant
     * @param idCourse   the id course
     * @return int
     */
    int linkToCourse(int idEtudiant, int idCourse) throws ExceptionService;
}
