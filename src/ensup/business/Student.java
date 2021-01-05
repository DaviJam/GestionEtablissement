package ensup.business;

import java.sql.Date;

/**
 * The type Student.
 *
 * @author Amélie
 */
public class Student extends Person
{
	private Date dateOfBirth;
	
	/**
	 * Instantiates a new Student
	 * 
	 * @param surname
	 * @param mailAddress
	 * @param address
	 * @param phoneNumber
	 * @param id
	 * @param name
	 * @param password
	 * @param dateOfBirth
	 */
	public Student(String surname, String mailAddress, String address, int phoneNumber, int id, String name, String password, Date dateOfBirth)
	{
		super(surname, mailAddress, address, phoneNumber, id, name, password);
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Instantiates a new Student
	 * 
	 * @param surname
	 * @param mailAddress
	 * @param id
	 * @param name
	 * @param password
	 * @param dateOfBirth
	 */
	public Student(String surname, String mailAddress, int id, String name, String password, Date dateOfBirth)
	{
		super(surname, mailAddress, id, name, password);
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Instantiates a new Student
	 * 
	 * @param surname
	 * @param mailAddress
	 * @param id
	 * @param name
	 * @param password
	 */
	public Student(String surname, String mailAddress, int id, String name, String password)
	{
		this(surname, mailAddress, id, name, password, null);
	}

	/**
	 * @return date of the student birth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() {
		String res = super.toString();
		res = res.replace(super.getClass().getName(), "Student");
		res = res.substring(0, res.length()-1);
		res = res + ", dateOfBirth=\" + dateOfBirth + \"]";
		
		return res;
	}
}