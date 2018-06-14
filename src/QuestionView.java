import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionView {

    private Stage primaryStage;
    private InstructionEmployee user;
    private Controller controller;
    private ArrayList<Question> questions;
    private Question selectedQuestion;
    private Course selectedCourse;


    @FXML ListView questionList;

    @FXML
    public void initialize() {

        questions = controller.qetCourseQuestions(selectedCourse, user);
        for(Question question : questions) {
            questionList.getItems().add(question.toString());
        }
        questionList.getSelectionModel().getSelectedItem();

        questionList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            }
        });
    }

    public void selectQuestion(String body){
        for (Question question: questions) {
            if(body.equals(question.toString())) {
                this.selectedQuestion = question;
                break;
            }
        }
    }

    public QuestionView(Stage primaryStage, InstructionEmployee user, Controller controller, Course selectedCourse){
        this.controller = controller;
        this.primaryStage = primaryStage;
        this.user = user;
        this.selectedCourse = selectedCourse;
        this.questions = new ArrayList<>();
        FXMLLoader course = new FXMLLoader(getClass().getResource("ViewQuestions.fxml"));
        course.setController(this);

        try {
            Parent root = (Parent) course.load();
            primaryStage.setTitle("Mivhanet");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML ListView optionsView;
    public void showQuestion() {
        try {
            ArrayList<Option> options = selectedQuestion.getOptions();
            for (Option option: options) {
                optionsView.getItems().add(option);
            }
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("seeQuestion.fxml"));
            fxmlLoader.setController(this);

            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Question");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
    }
}
