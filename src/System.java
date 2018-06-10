import java.util.Date;
import java.util.List;

public class System {

    List<Course> courses;
    List<CourseInSemester> coursesInSemester;
    List<Student> students;
    List<HeadLecturer> headLecturers;
    List<Lecturer> lecturers;
    List<InstructionEmployee> instructionEmployees;
    List<Test> tests;
    List<Question> questions;
    List<Semester> semesters;
    List<Answer> answers;
    List<Comment> comments;
    List<Option> options;
    List<OptionAnswer> optionAnswers;
    List<CourseStaff> courseStaffs;
    List<TestAnswer> testAnswers;

    public List<Course> getCourses() {
        return null;
    }

    public Question getQuestion(String questionId){
        return null;

    }

    public void addToTest(Question question){}

    public void setPoints(String questionId, double points){}

    public Course getCourse(String courseId){
        return null;

    }

    public TestAnswer selectTestAnswer(Student student, CourseInSemester courseInSemester, TestDate.moed moed){
        return null;

    }

    public Test selectTest(CourseInSemester courseInSemester, TestDate.moed moed){
        return null;
    }

    public void createTestDate(Date date, TestDate.moed moed, CourseInSemester courseInSemester){}

    public void showQuestions(){}

    public void showQuestionForm(){}

    public void createQuestion(){}

    public void createOption(String option){}

    public void deleteQuestion(){}

    public Semester getSemester(int year, Semester.season season){
        return null;

    }

    public CourseInSemester getCourseInSemester(Semester semester, String courseId){
        return null;
    }

    public Student getStudent(String studentId){
        return null;
    }

    public void addStudentToCourse(Student student){}

    public void setCourses(List<Course> courses) {}

    public void submitComment(String commentText){}

    public void openCourseInSemester(Semester semester, Course course){}

    public List<CourseInSemester> getCoursesInSemester() {
        return null;

    }

    public void setCoursesInSemester(List<CourseInSemester> coursesInSemester) {}

    public List<Student> getStudents() {
        return null;

    }

    public void setStudents(List<Student> students) {}

    public List<HeadLecturer> getHeadLecturers() {
        return null;

    }

    public void setHeadLecturers(List<HeadLecturer> headLecturers) {}

    public List<Lecturer> getLecturers() {
        return null;

    }

    public void setLecturers(List<Lecturer> lecturers) {}

    public List<InstructionEmployee> getInstructionEmployees() {
        return null;

    }

    public void setInstructionEmployees(List<InstructionEmployee> instructionEmployees) {}

    public List<Test> getTests() {
        return null;

    }

    public void setTests(List<Test> tests) {}

    public List<Question> getQuestions() {
        return null;

    }

    public void setQuestions(List<Question> questions) {}

    public List<Semester> getSemesters() {
        return null;

    }

    public void setSemesters(List<Semester> semesters) {}

    public List<Answer> getAnswers() {
        return null;

    }

    public void setAnswers(List<Answer> answers) {}

    public List<Comment> getComments() {
        return null;

    }

    public void setComments(List<Comment> comments) {}

    public List<Option> getOptions() {
        return null;

    }

    public void setOptions(List<Option> options) {}

    public List<OptionAnswer> getOptionAnswers() {
        return null;

    }

    public void setOptionAnswers(List<OptionAnswer> optionAnswers) {}

    public List<CourseStaff> getCourseStaffs() {
        return null;

    }

    public void setCourseStaffs(List<CourseStaff> courseStaffs) {}

    public List<TestAnswer> getTestAnswers() {
        return null;

    }

    public void setTestAnswers(List<TestAnswer> testAnswers) {}
}
