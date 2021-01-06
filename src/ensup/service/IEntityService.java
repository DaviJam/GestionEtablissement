package ensup.service;

import java.util.Date;

public interface IEntityService<Person> extends IService<Person> {
    void Create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught);
    void Update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught);
    void Delete(String mail);
}
