package ensup.business;

/**
 * The type School.
 */
public class School extends Entity
{
    private Director director;

    /**
     * Instantiates a new School.
     *
     * @param surname     the surname
     * @param mailAddress  the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     * @param director    the director
     */
    public School(String surname, String mailAddress, String address, int phoneNumber, Director director) {
        super(surname, mailAddress, address, phoneNumber);
        this.director = director;
    }

    /**
     * Instantiates a new School.
     *
     * @param surname     the surname
     * @param mailAddress the mail address
     * @param director    the director
     */
    public School(String surname, String mailAddress, Director director) {
        super(surname, mailAddress);
        this.director = director;
    }

    /**
     * Gets director.
     *
     * @return the director
     */
    public Director getDirector() {
        return director;
    }

    /**
     * Sets director.
     *
     * @param director the director
     */
    public void setDirector(Director director) {
        this.director = director;
    }
}
