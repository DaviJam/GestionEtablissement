package ensup.dto;

import ensup.business.Role;

import java.util.Date;

public class StudentDTO extends PersonDTO{
    private Date dateOfBirth;

    public StudentDTO(){ }

    public StudentDTO(String lastname, String mailAddress, String address, String phoneNumber, String firstname, String password, Date dateOfBirth)
    {
        super(lastname, mailAddress, address, phoneNumber, firstname, Role.STUDENT, password);
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Instantiates a new Student
     *
     * @param lastname
     * @param mailAddress
     * @param address
     * @param phoneNumber
     * @param id
     * @param firstname
     * @param password
     * @param dateOfBirth
     */
    public StudentDTO(String lastname, String mailAddress, String address, String phoneNumber, int id, String firstname, String password, Date dateOfBirth)
    {
        super(lastname, mailAddress, address, phoneNumber, id, firstname, Role.STUDENT, password);
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Instantiates a new Student
     *
     * @param lastname
     * @param mailAddress
     * @param id
     * @param firstname
     * @param password
     * @param dateOfBirth
     */
    public StudentDTO(String lastname, String mailAddress, int id, String firstname, String password, Date dateOfBirth)
    {
        super(lastname, mailAddress, id, firstname, password);
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Instantiates a new Student
     *
     * @param lastname
     * @param mailAddress
     * @param id
     * @param firstname
     * @param password
     */
    public StudentDTO(String lastname, String mailAddress, int id, String firstname, String password)
    {
        this(lastname, mailAddress, id, firstname, password, null);
    }


    /**
     * @return date of the student birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        String res = super.toString();
        res = res.replace("Person", "Student");
        res = res.substring(0, res.length()-1);
        res = res + ", dateOfBirth=\" + dateOfBirth + \"]";

        return res;
    }
}
