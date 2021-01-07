package ensup.service;

import java.util.Date;

public interface IServiceEntity<Person> extends IService<Person> {
    void Create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught);
    void Update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught);
    void Delete(Person person);
}
