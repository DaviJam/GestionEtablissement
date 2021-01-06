package ensup.business;

/**
 * The type Person.
 *
 * @author Allan
 */
public class Person extends Entity{
    private int id;
    private String firstname;
    private String password;
    private Role role;

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets firstname.
     *
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Instantiates a new Person.
     *
     * @param surname     the surname
     * @param mailAddress the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     * @param id          the id
     * @param firstname   the firstname
     * @param password    the password
     */
    public Person(String surname, String mailAddress, String address, String phoneNumber, int id, String firstname, Role role, String password) {
        super(surname, mailAddress, address, phoneNumber);
        this.id = id;
        this.firstname = firstname;
        this.role = role;
        this.password = password;
    }

    public Person(String surname, String mailAddress, String address, String phoneNumber, String firstname, Role role, String password) {
        super(surname, mailAddress, address, phoneNumber);
        this.id = id;
        this.firstname = firstname;
        this.role = role;
        this.password = password;
    }

    /**
     * Instantiates a new Person.
     *
     * @param surname     the surname
     * @param mailAddress the mail address
     * @param id          the id
     * @param firstname   the firstname
     * @param password    the password
     */
    public Person(String surname, String mailAddress, int id, String firstname, String password) {
        super(surname, mailAddress);
        this.id = id;
        this.firstname = firstname;
        this.password = password;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        String res = super.toString();
        res = res.replace(super.getClass().getName(), "Person");
        res = res.substring(0, res.length()-1);
        res = res + ", id=" + id + ", firstname=" + firstname + ", password=" + password + "]";

        return res;
    }
}
