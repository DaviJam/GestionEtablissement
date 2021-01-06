package ensup.service;

import ensup.business.Person;
import ensup.business.Role;
import ensup.business.Student;

import java.util.List;

public class ServicePerson implements IEntityService<Person, Role>
{
    // Create Person
    @Override
    public void create(Person person, Role role) {
    // Appel de la méthode Create dans le dao
    }

    // Update Person
    @Override
    public void update(Person person, Role role) {

    }

    // Remove Person
    @Override
    public void delete(Person entity) {

    }

    // Read Person
    @Override
    public Person get(int index) {
        return null;
    }

    // Get All Student
    @Override
    public List<Person> getAll() {
        return null;
    }

}
