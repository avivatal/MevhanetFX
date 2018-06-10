import java.util.Date;
import java.util.List;

public class Reception extends User {

    public Reception(String ID, String firstName, String lastName, String phoneNumber, String email, String userName, String address, String password) {
        super(ID, firstName, lastName, phoneNumber, email, userName, address, password);
    }

    public void openCourse(String courseId, Semester semester, List<Student> registeredStudents){}

    public void setTestDate(String coureseId, Semester semester, TestDate.moed testMoed, Date testDate){}

    public void manageCourseStaff(String courseId, List<InstructionEmployee> courseStaffList){}

    public void viewGrades(String studentId){}

    public void createUser(String FirstName, String LastName, String phoneNumber, String email, String userName,
                           String ID, String address, Class<? extends User> userType){}
}
