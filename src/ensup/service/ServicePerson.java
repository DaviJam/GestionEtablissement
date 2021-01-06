package ensup.service;

import ensup.business.Person;
import ensup.business.Role;
import ensup.business.Student;

import java.util.List;

public class ServicePerson implements IEntityService<Person, Role>{


    // Create Person
    @Override
    public void Create(Person person, Role role) {
    // Appel de la méthode Create dans le dao
    }

    // Update Person
    @Override
    public void Update(Person person, Role role) {

    }

    // Remove Person
    @Override
    public void Delete(Person entity) {

    }

    // Read Person
    @Override
    public Person Get(int index) {
        return null;
    }

    // Get All Student
    @Override
    public List<Person> GetAll() {
        return null;
    }

}
