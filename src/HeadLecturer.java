import java.util.List;

public class HeadLecturer extends Lecturer {

    public HeadLecturer(String ID, String firstName, String lastName, String phoneNumber, String email, String userName, String address, String password) {
        super(ID, firstName, lastName, phoneNumber, email, userName, address, password);
    }

    public HeadLecturer(InstructionEmployee instructionEmployee){
        super(instructionEmployee.getID(), instructionEmployee.getFirstName(), instructionEmployee.getLastName(), instructionEmployee.getPhoneNumber(),
                instructionEmployee.getEmail(), instructionEmployee.getUserName(), instructionEmployee.getAddress(), instructionEmployee.getPassword());
    }

    public void createCourseSyllabus(String courseId, String syllabus){}

    public void approveTest(Test testToApprove){}

    public void deleteQuestion(Question questionToDelete){}

    public void updateSingleTestGrade(Test test, double newScore){}

    public void updateMultipleGrades(List<Test> tests, double factorToAddToScores){}

}
