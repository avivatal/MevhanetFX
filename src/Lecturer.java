import java.util.Dictionary;
import java.util.List;

public class Lecturer extends InstructionEmployee {

    public Lecturer(String ID, String firstName, String lastName, String phoneNumber, String email, String userName, String address, String password) {
        super(ID, firstName, lastName, phoneNumber, email, userName, address, password);
    }

    public Lecturer(InstructionEmployee instructionEmployee){
        super(instructionEmployee.getID(), instructionEmployee.getFirstName(), instructionEmployee.getLastName(), instructionEmployee.getPhoneNumber(),
                instructionEmployee.getEmail(), instructionEmployee.getUserName(), instructionEmployee.getAddress(), instructionEmployee.getPassword());
    }

    public void createTest(String courseId, Semester semester, TestDate.moed testMoed, Dictionary<Question,Double> questionsAndPoints){}

    public void addOptionsToQuestion(Question question, List<Option> optionsToAdd){}

}
