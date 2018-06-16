import javafx.util.Pair;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Controller {
        private View view;
        private Model model;

        public Controller(View view, Model model){
            this.view = view;
            this.model = model;
        }

        public User login(){
            String username = view.getUsername();
            String password = view.getPassword();
            return model.login(username, password);
        }

        public ArrayList<String> getCourses(String id){
           return model.getCourses(id);
        }

        public Course getCourseDetails(Course course){
            return model.getCourseDetails(course);
        }

        public Pair<ArrayList<String>, InstructionEmployee> getAvailableActions(Course course, InstructionEmployee user){
            return model.getAvailableActions(course, user);
        }

    public boolean deleteQuestion(InstructionEmployee employee, Question question, Course selectedCourse) {
             return model.deleteQuestion(employee, question, selectedCourse);
    }

    public void addComment(String comment, Question question) {
            model.addComment(comment, question);
    }


    public void createQuestion(InstructionEmployee user, Course course, String questionBody, ArrayList<Option> options, int difficulty, double time) {
            model.createQuestion(user, course, questionBody, options, difficulty, time);
    }
}
