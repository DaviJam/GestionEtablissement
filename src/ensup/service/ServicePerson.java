package ensup.service;

import ensup.business.*;
import ensup.dao.DaoPerson;

import java.util.Date;
import java.util.List;

public class ServicePerson implements IServiceEntity<Person>{

    private DaoPerson dao = new DaoPerson();

    // Create Person
    @Override
    public int Create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught) {
        //TODO Appel de la fonction Create Personne
        // Checker le role et faire une instace et l'envoyer dans le DAO
        int check = 0;
        switch(role){
            case 1: // Director
                Person director = new Director(surname, mail, address, phone, 0, firstname, password);
                check = this.dao.create(director);
                break;
            case 2: // Manager
                Person manager = new Manager(surname, mail, address, phone, 0, firstname, password);
                check = this.dao.create(manager);
                break;
            case 3: // Teacher
                // On instancie Personne pour que dans le DAO il puisse récupérer le matière enseignée
                Person teacher = new Teacher(surname, mail, address, phone, 0, firstname, password, subjectTaught);
                check = this.dao.create(teacher);
                break;
            case 4: // Student
                // On instancie Personne pour que dans le DAO il puisse récupérer la date de naissance
                Person student = new Student(surname, mail, address, phone, 0, firstname,password, dateofbirth);
                check = this.dao.create(student);
                break;
        }
        return check;
    }

    // Update Person
    @Override
    public int Update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught) {
        int res = 0;
        switch(role){
            case 1: // Director
                Person director = new Director(surname, mail, address, phone, 0, firstname, password);
                res = this.dao.update(director);
                break;
            case 2: // Manager
                Person manager = new Manager(surname, mail, address, phone, 0, firstname, password);
                res = this.dao.update(manager);
                break;
            case 3: // Teacher
                Person teacher = new Teacher(surname, mail, address, phone, 0, firstname, password, subjectTaught);
                res = this.dao.update(teacher);
                break;
            case 4: // Student
                Person student = new Student(surname, mail, address, phone, 0, firstname,password,dateofbirth);
                res = this.dao.update(student);
                break;
        }
        return res;
    }

    @Override
    public int Delete(Person person) {
        int res = this.dao.delete(person);
        return res;
    }

    @Override
    public Person get(int index) {
        Person person = this.dao.get(index);
        return person;
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
