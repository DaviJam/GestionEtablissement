package ensup.service;

import ensup.business.Person;
import ensup.business.Role;
import ensup.business.Student;

import java.util.List;

public class ServicePerson implements IEntityService<Person, Role>{


    // Create Person
    @Override
    public void Create(Person person, Role role) {

    }

    // Update Person
    @Override
    public void Update(Person person, Role role) {

    }

    // Remove Person
    @Override
    public void Remove(Person entity) {

    }

    // Read Person
    @Override
    public Person Read(int index) {
        return null;
    }

    // Get All Student
    public List<Student> getAllStudent(){
        // La j'apelle la fonction GetAllStudent dans le dao
        return null;
    }





}
