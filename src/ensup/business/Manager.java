package ensup.business;

/**
 * The type Director.
 * Is responsible
 */
public class Manager extends Entity{

    /**
     * Instantiates a new Director.
     *
     * @param surname     the surname
     * @param mailAdress  the mail adress
     * @param adress      the adress
     * @param phoneNumber the phone number
     */
    public Manager(String surname, String mailAdress, String adress, int phoneNumber) {
        super(surname, mailAdress, adress, phoneNumber);
    }

    /**
     * Instantiates a new Director.
     *
     * @param surname    the surname
     * @param mailAdress the mail adress
     */
    public Manager(String surname, String mailAdress) {
        super(surname, mailAdress);
    }
}
