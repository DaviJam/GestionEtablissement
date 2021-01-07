package ensup.mapper;

import ensup.business.Student;
import ensup.dto.StudentDTO;

public class StudentMapper {
    public static StudentDTO businessToDto(Student student)
    {
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(student.getId());
        studentDTO.setLastname(student.getLastname());
        studentDTO.setFirstname(student.getFirstname());
        studentDTO.setDateOfBirth(student.getDateOfBirth());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setMailAddress(student.getMailAddress());
        studentDTO.setPassword(student.getPassword());
        studentDTO.setPhoneNumber(student.getPhoneNumber());
        studentDTO.setRole(student.getRole());


        return studentDTO;
    };

    public static Student dtoToBusiness(StudentDTO studentDTO)
    {
        Student student = new Student();

        student.setId(studentDTO.getId());
        student.setLastname(studentDTO.getLastname());
        student.setFirstname(studentDTO.getFirstname());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setAddress(studentDTO.getAddress());
        student.setMailAddress(studentDTO.getMailAddress());
        student.setPassword(studentDTO.getPassword());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setRole(studentDTO.getRole());

        return student;
    };
}