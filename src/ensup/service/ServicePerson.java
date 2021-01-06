package ensup.service;

import ensup.business.Person;
import ensup.business.Role;
import ensup.business.Student;
import ensup.business.Teacher;

import java.util.Date;
import java.util.List;

public class ServicePerson implements IEntityService<Person>{

    private DaoPerson dao = new DaoPerson();
    // Create Person


    @Override
    public void Create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught) {
        //TODO Appel de la fonction Create Personne
        // Checker le role et faire une instace et l'envoyer dans le DAO
        switch(role){
            case 1: // Director
                Person director = new Person(surname, mail, address, phone, 0, firstname, password);
                this.dao.Create(director);
                break;
            case 2: // Manager
                Person manager = new Person(surname, mail, address, phone, 0, firstname, password);
                this.dao.Create(manager);
                break;
            case 3: // Teacher
                // On instancie Personne pour que dans le DAO il puisse récupérer le matière enseignée
                Teacher teacher = new Teacher(surname, mail, address, phone, 0, firstname, password, subjectTaught);
                this.dao.Create(teacher);
                break;
            case 4: // Student
                // On instancie Personne pour que dans le DAO il puisse récupérer la date de naissance
                Student student = new Student(String surname, mail, address, phone, 0, firstname,password,dateofbirth);
                this.dao.Create(student);
                break;
        }
    }

    // Update Person
    @Override
    public void Update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught) {
    //TODO Appel de la fonction Update Personne
        switch(role){
            case 1: // Director
                Person director = new Person(surname, mail, address, phone, 0, firstname, password);
                this.dao.Update(director);
                break;
            case 2: // Manager
                Person manager = new Person(surname, mail, address, phone, 0, firstname, password);
                this.dao.Update(manager);
                break;
            case 3: // Teacher
                Teacher teacher = new Teacher(surname, mail, address, phone, 0, firstname, password, subjectTaught);
                this.dao.Update(teacher);
                break;
            case 4: // Student
                Student student = new Student(String surname, mail, address, phone, 0, firstname,password,dateofbirth);
                this.dao.Update(student);
                break;
        }

    }

    @Override
    public void Delete(String mail) {
        this.dao.Delete(mail);
    }

    @Override
    public Person get(int index) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return this.dao.getAll();
    }

    @Override
    public int createCourse(Person entity) {
        return 0;
    }



}
