package ensup.service;

import java.util.Date;

public interface IServiceEntity<Person> extends IService<Person> {
    int Create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught);
    int Update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught);
    int Delete(Person person);
}
