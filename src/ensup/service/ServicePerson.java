package ensup.service;

import ensup.business.*;
import ensup.dao.DaoPerson;

import java.util.Date;
import java.util.List;

public class ServicePerson implements IServiceEntity<Person>{

    private DaoPerson dao = new DaoPerson();
    // Create Person


    @Override
    public void Create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught) {
        //TODO Appel de la fonction Create Personne
        // Checker le role et faire une instace et l'envoyer dans le DAO
        switch(role){
            case 1: // Director
                Person director = new Director(surname, mail, address, phone, 0, firstname, password);
                this.dao.create(director);
                break;
            case 2: // Manager
                Person manager = new Manager(surname, mail, address, phone, 0, firstname, password);
                this.dao.create(manager);
                break;
            case 3: // Teacher
                // On instancie Personne pour que dans le DAO il puisse récupérer le matière enseignée
                Person teacher = new Teacher(surname, mail, address, phone, 0, firstname, password, subjectTaught);
                this.dao.create(teacher);
                break;
            case 4: // Student
                // On instancie Personne pour que dans le DAO il puisse récupérer la date de naissance
                Person student = new Student(surname, mail, address, phone, 0, firstname,password, dateofbirth);
                this.dao.create(student);
                break;
        }
    }

    // Update Person
    @Override
    public void Update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught) {
    //TODO Appel de la fonction Update Personne
        switch(role){
            case 1: // Director
                Person director = new Director(surname, mail, address, phone, 0, firstname, password);
                this.dao.update(director);
                break;
            case 2: // Manager
                Person manager = new Manager(surname, mail, address, phone, 0, firstname, password);
                this.dao.update(manager);
                break;
            case 3: // Teacher
                Person teacher = new Teacher(surname, mail, address, phone, 0, firstname, password, subjectTaught);
                this.dao.update(teacher);
                break;
            case 4: // Student
                Person student = new Student(surname, mail, address, phone, 0, firstname,password,dateofbirth);
                this.dao.update(student);
                break;
        }

    }

    // Todo :  il faut passer une méthode
    @Override
    public void Delete(Person person) {
        this.dao.delete(person);
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
