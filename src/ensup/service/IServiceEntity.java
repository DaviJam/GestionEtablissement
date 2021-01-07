package ensup.service;

import java.util.Date;

public interface IServiceEntity<Person> extends IService<Person>
{
    int create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught);
    int update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught);
    int linkToCourse(int idEtudiant, int idCourse);
}
