package ensup.business;

public class Entity
{
	private String surname;
	private String mailAdress;
	private String adress;
	private int phoneNumber;

	/**
	 * @param surname
	 * @param mailAdress
	 * @param adress
	 * @param phoneNumber
	 */
	public Entity(String surname, String mailAdress, String adress, int phoneNumber) {
		super();
		this.surname = surname;
		this.mailAdress = mailAdress;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @param surname
	 * @param mailAdress
	 */
	public Entity(String surname, String mailAdress)
	{
		this(surname, mailAdress, null, -1);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Unity [surname=" + surname + ", mailAdress=" + mailAdress + ", adress=" + adress + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
