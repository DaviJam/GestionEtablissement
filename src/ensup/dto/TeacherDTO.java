package ensup.dto;

public class TeacherDTO extends PersonDTO{

    private String subjectTaught;

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String subjectTaught) {
        this.subjectTaught = subjectTaught;
    }

    public TeacherDTO() {
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "subjectTaught='" + subjectTaught + '\'' +
                '}';
    }
}
