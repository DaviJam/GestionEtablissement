package ensup.dto;

/**
 * The type School.
 */
public class SchoolDTO
{
	private int id;
	private String surname;
	private String mailAddress;
	private String address;
	private String phoneNumber;
    private int director;
	/**
	 * @param id
	 * @param surname
	 * @param mailAddress
	 * @param address
	 * @param phoneNumber
	 * @param director
	 */
	public SchoolDTO(int id, String surname, String mailAddress, String address, String phoneNumber, int director)
	{
		super();
		this.id = id;
		this.surname = surname;
		this.mailAddress = mailAddress;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.director = director;
	}
	
	public SchoolDTO(String surname, String mailAddress, String address, String phoneNumber, int director)
	{
		this(-1, surname, mailAddress, address, phoneNumber, director);
	}
	
	public SchoolDTO()
	{
		this(-1, null, null, null, null, -1);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMailAddress() {
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getDirector() {
		return director;
	}
	public void setDirector(int director) {
		this.director = director;
	}
	
	@Override
	public String toString() {
		return "SchoolDTO [id=" + id + ", surname=" + surname + ", mailAddress=" + mailAddress + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", director=" + director + "]";
	}
}
