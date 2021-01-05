package ensup.business;

/**
 * The type Director.
 */
public class Director extends Manager {
    /**
     * Instantiates a new Director.
     *
     * @param surname     the surname
     * @param mailAdress  the mail adress
     * @param adress      the adress
     * @param phoneNumber the phone number
     */
    public Director(String surname, String mailAdress, String adress, int phoneNumber) {
        super(surname, mailAdress, adress, phoneNumber);
    }

    /**
     * Instantiates a new Director.
     *
     * @param surname    the surname
     * @param mailAdress the mail adress
     */
    public Director(String surname, String mailAdress) {
        super(surname, mailAdress);
    }
}
