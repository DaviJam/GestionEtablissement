package ensup.business;

public class Entity
{
	private String surname;
	private String mailAddress;
	private String address;
	private int phoneNumber;

	/**
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
	 * @param surname
	 * @param mailAddress
	 */
	public Entity(String surname, String mailAddress)
	{
		this(surname, mailAddress, null, -1);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String mailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Unity [surname=" + surname + ", mailAddress=" + mailAddress + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
