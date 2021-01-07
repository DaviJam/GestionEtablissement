package ensup.business;

/**
 * The type School.
 */
public class School extends Entity
{
	private int id;
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
    public School(int id, String surname, String mailAddress, String address, String phoneNumber, Director director) {
        super(surname, mailAddress, address, phoneNumber);
        this.id = id;
        this.director = director;
    }
    
    public School(String surname, String mailAddress, String address, String phoneNumber, Director director) {
        super(surname, mailAddress, address, phoneNumber);
        this.id = -1;
        this.director = director;
    }

    /**
     * Instantiates a new School.
     *
     * @param surname     the surname
     * @param mailAddress the mail address
     * @param director    the director
     */
    public School(int id, String surname, String mailAddress, Director director) {
        super(surname, mailAddress);
        this.id = id;
        this.director = director;
    }
    public School(String surname, String mailAddress, Director director) {
        super(surname, mailAddress);
        this.id = -1;
        this.director = director;
    }
    
    public int getId() { return this.id; }
    
    public void setId(int id) { this.id = id; }

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
    
    @Override
	public String toString()
	{
		String res = super.toString();
		res = res.replaceAll("Entity", "School");
		res = res.substring(0, res.length()-1);
		res = res + ", id=" + id;
		res = res + ", director=" + director.getId() + "]";

		return res;
	}
}
