package ensup.business;

public class School extends Entity
{
    private Director director;

    public School(String surname, String mailAdress, String adress, int phoneNumber, Director director) {
        super(surname, mailAdress, adress, phoneNumber);
        this.director = director;
    }

    public School(String surname, String mailAdress, Director director) {
        super(surname, mailAdress);
        this.director = director;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
