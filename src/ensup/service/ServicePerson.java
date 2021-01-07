package ensup.service;

import ensup.business.*;
import ensup.dao.DaoPerson;
import ensup.dto.*;
import ensup.mapper.DirectorMapper;
import ensup.mapper.ManagerMapper;
import ensup.mapper.StudentMapper;
import ensup.mapper.TeacherMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Service person.
 */
public class ServicePerson implements IServiceEntity<PersonDTO>{

    private DaoPerson dao = null;

    /**
     * Instantiates a new Service person.
     */
    public ServicePerson() {
        this.dao = new DaoPerson();
    }


    // Create Person
    @Override
    public int create(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught) {
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
    public int update(String surname, String mail, String address, String phone, String firstname, String password, int role, Date dateofbirth, String subjectTaught) {
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
    public int delete(int index) {
        //Person person = this.get(index);
        //int res = this.dao.delete(person);
        return 0;//res;
    }

    @Override
    public int linkToCourse(int idEtudiant, int idCourse) {
        int res = this.dao.LinkToCourse(idEtudiant, idCourse);
        return res;
    }

    @Override
    public PersonDTO get(int index) {
        Person person = this.dao.get(index);
        PersonDTO personDTO = new PersonDTO();
        if(person instanceof Student)
        {
            personDTO = StudentMapper.businessToDto((Student)person);

        }else if(person instanceof Manager)
        {

        }else if(person instanceof Teacher)
        {

        }else if(person instanceof Director)
        {

        }

        return personDTO;
    }

    @Override
    public List<PersonDTO> getAll() {
        List<PersonDTO> personDTOList = new ArrayList<PersonDTO>();

        this.dao.getAll().forEach(person -> {
            if(person instanceof Student)
            {
                StudentDTO studentDTO = new StudentDTO();
                StudentMapper.businessToDto((Student)person);
                personDTOList.add(studentDTO);
            } else if(person instanceof Manager)
            {
                ManagerDTO managerDTO = new ManagerDTO();
                ManagerMapper.businessToDto((Manager)person);
                personDTOList.add(managerDTO);
            }else if(person instanceof Teacher)
            {
                TeacherDTO teacherDTO = new TeacherDTO();
                TeacherMapper.businessToDto((Teacher)person);
                personDTOList.add(teacherDTO);
            }else if(person instanceof Director)
            {
                DirectorDTO directorDTO = new DirectorDTO();
                DirectorMapper.businessToDto((Director)person);
                personDTOList.add(directorDTO);
            }
        });
        return personDTOList;
    }
}
