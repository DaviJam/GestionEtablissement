package ensup.business;

/**
 * The type Person.
 *
 * @author Allan
 */
public class Person extends Entity{
    private int id;
    private String name;
    private String password;

    /**
     * Instantiates a new Person.
     *
     * @param surname     the surname
     * @param mailAddress the mail address
     * @param address     the address
     * @param phoneNumber the phone number
     * @param id          the id
     * @param name        the name
     * @param password    the password
     */
    public Person(String surname, String mailAddress, String address, int phoneNumber, int id, String name, String password) {
        super(surname, mailAddress, address, phoneNumber);
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     * Instantiates a new Person.
     *
     * @param surname     the surname
     * @param mailAddress the mail address
     * @param id          the id
     * @param name        the name
     * @param password    the password
     */
    public Person(String surname, String mailAddress, int id, String name, String password) {
        super(surname, mailAddress);
        this.id = id;
        this.name = name;
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

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString()
	{
		String res = super.toString();
		res = res.replace(super.getClass().getName(), "Person");
		res = res.substring(0, res.length()-1);
		res = res + ", id=" + id + ", name=" + name + ", password=" + password + "]";
		
		return res;
	}
}
