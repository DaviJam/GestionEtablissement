package ensup.business;

/**
 * The type Teacher.
 * 
 * @author Youness
 */
public class Teacher extends Person{
    private String subjectTaught;

    /**
     * Instantiates a new Director.
     *
     * @param surname     the surname
     * @param mailAdress  the mail adress
     * @param adress      the adress
     * @param phoneNumber the phone number
     * @param id the id
     * @param name the name
     * @param password the password
     */
    public Teacher(String surname, String mailAddress, String address, int phoneNumber, int id, String name, String password) {
        super(surname, mailAddress, address, phoneNumber, id, name, password);
    }

    public String getSubjectTaught(){
        return subjectTaught;
    }

    public void setSubjectTaught(String subjectTaught){
        this.subjectTaught = subjectTaught;
    }
}
