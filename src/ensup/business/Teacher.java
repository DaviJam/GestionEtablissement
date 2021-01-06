package ensup.business;

/**
 * The type Teacher.
 *
 * @author Youness
 */
public class Teacher extends Person{
    private String subjectTaught;

    /**
     * Instantiates a new Teacher.
     *
     * @param surname       the surname
     * @param mailAddress   the mail address
     * @param address       the address
     * @param phoneNumber   the phone number
     * @param id            the id
     * @param firstname     the firstname
     * @param password      the password
     * @param subjectTaught the subject taught
     */
    public Teacher(String surname, String mailAddress, String address, String phoneNumber, int id, String firstname, String password, String subjectTaught) {
        super(surname, mailAddress, address, phoneNumber, id, firstname, Role.TEACHER, password);
        this.subjectTaught = subjectTaught;
    }

    /**
     * Get subject taught string.
     *
     * @return the string
     */
    public String getSubjectTaught(){
        return subjectTaught;
    }

    /**
     * Set subject taught.
     *
     * @param subjectTaught the subject taught
     */
    public void setSubjectTaught(String subjectTaught){
        this.subjectTaught = subjectTaught;
    }
}
