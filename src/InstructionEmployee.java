import java.util.ArrayList;
import java.util.List;

public class InstructionEmployee extends User {

    public InstructionEmployee(String ID, String firstName, String lastName, String phoneNumber, String email, String userName, String address, String password) {
        super(ID, firstName, lastName, phoneNumber, email, userName, address, password);
        this.myQuestions = new ArrayList<>();
    }

    public InstructionEmployee(User user){
        super(user.getID(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(),
                user.getEmail(), user.getUserName(), user.getAddress(), user.getPassword());
        this.myQuestions = new ArrayList<>();
    }

    private ArrayList<Question> myQuestions;

    public ArrayList<Question> getMyQuestions() {
        return myQuestions;
    }

    public void createQuestion(Question question, String courseId){}

    public void editQuestion(Question originalQuestion, Question editedQuestion){}

    public void estimateQuestionSolutionTime(Question question, double timeEstimation){}

    public void estimateQuestionDifficulty(Question question, int difficultyEstimation){}

    public void commentQuestion(Question question, String comment){}

    public void submitStudentsTestAnswer(String courseid, Semester semester, TestDate.moed moed, List<Answer> studentsAnswers, String studentId){}

    public List<Question> viewQuestionsRepository(String courseId){ return null;}

}
