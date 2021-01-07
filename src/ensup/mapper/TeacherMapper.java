package ensup.mapper;

import ensup.business.Student;
import ensup.business.Teacher;
import ensup.dto.PersonDTO;
import ensup.dto.StudentDTO;
import ensup.dto.TeacherDTO;

public class TeacherMapper extends PersonDTO {

    public static TeacherDTO businessToDto(Teacher teacher){

        TeacherDTO teacherDto = new TeacherDTO();

        teacherDto.setId(teacher.getId());
        teacherDto.setLastname(teacher.getLastname());
        teacherDto.setFirstname(teacher.getFirstname());
        teacherDto.setAddress(teacher.getAddress());
        teacherDto.setMailAddress(teacher.getMailAddress());
        teacherDto.setPassword(teacher.getPassword());
        teacherDto.setPhoneNumber(teacher.getPhoneNumber());
        teacherDto.setRole(teacher.getRole());
        teacherDto.setSubjectTaught(teacher.getSubjectTaught());

        return teacherDto;
    };

    public static Teacher dtoToBusiness(TeacherDTO teacherDTO)
    {
        Teacher teacher = new Teacher();

        teacher.setId(teacherDTO.getId());
        teacher.setLastname(teacherDTO.getLastname());
        teacher.setFirstname(teacherDTO.getFirstname());
        teacher.setAddress(teacherDTO.getAddress());
        teacher.setMailAddress(teacherDTO.getMailAddress());
        teacher.setPassword(teacherDTO.getPassword());
        teacher.setPhoneNumber(teacherDTO.getPhoneNumber());
        teacher.setRole(teacherDTO.getRole());

        return teacher;
    };
}
