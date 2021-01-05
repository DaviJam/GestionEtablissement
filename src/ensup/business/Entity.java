package ensup.business;

/**
 * The type Entity
 * 
 * @author amelie
 */
public class Entity
{
	private String surname;
	private String mailAddress;
	private String address;
	private int phoneNumber;

	/**
	 * Instantiates a new Entity.
	 * 
	 * @param surname
	 * @param mailAddress
	 * @param address
	 * @param phoneNumber
	 */
	public Entity(String surname, String mailAddress, String address, int phoneNumber) {
		super();
		this.surname = surname;
		this.mailAddress = mailAddress;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Instantiates a new Entity.
	 * 
	 * @param surname
	 * @param mailAddress
	 */
	public Entity(String surname, String mailAddress)
	{
		this(surname, mailAddress, null, -1);
	}

	/**
	 * @return The surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the address mail
	 */
	public String mailAddress() {
		return mailAddress;
	}

	/**
	 * @param mailAddress
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * @return the entity address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the entity phone number
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Unity [surname=" + surname + ", mailAddress=" + mailAddress + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
