
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseNumber;
    private String courseName;
    private List<Question> questionsRepository;

    public Course(){
        questionsRepository = new ArrayList<>();
    }

    public void addQuestion(Question q){
        questionsRepository.add(q);
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Question> getQuestionsRepository() {
        return questionsRepository;
    }

    public void setQuestionsRepository(List<Question> questionsRepository) {
        this.questionsRepository = questionsRepository;
    }
}
