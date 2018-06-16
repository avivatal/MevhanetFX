import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class QuestionView {

    private Stage primaryStage;
    private InstructionEmployee user;
    private Controller controller;
    private ArrayList<Question> questions;
    private Question selectedQuestion;
    private Course selectedCourse;


    @FXML
    Accordion acc;

    @FXML
    public void initialize() {
        ArrayList<TitledPane> tps = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            VBox vb = new VBox();
            HBox hb = new HBox();
            if(user instanceof HeadLecturer) {
                Button deleteQuestion = new Button("Delete Question");
                deleteQuestion.setOnAction((event)-> {
                    boolean isInTest = controller.deleteQuestion(user, question, selectedCourse);
                    if(isInTest) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Cannot perform this Action");
                        alert.setContentText("The selected question exists in a test");
                        alert.show();
                    } else {
                        int qindex = questions.indexOf(question);
                        acc.getPanes().remove(tps.get(qindex));
                        tps.remove(qindex);
                        questions.remove(question);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information");
                        alert.setHeaderText("Success");
                        alert.setContentText("The question has been deleted");
                        alert.show();
                    }
                });
                hb.getChildren().add(deleteQuestion);
            }
            if(question.getCommentCounter() < 10) {
                Button createComment = new Button("Create Comment");
                hb.getChildren().add(createComment);
                createComment.setOnAction((event) -> {
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Add A Comment");
                    dialog.setHeaderText("Please type a comment");


                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()){
                        if(question.getCommentCounter() >= 10) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setHeaderText("Cannot perform this Action");
                            alert.setContentText("Cannot create more comments");
                            alert.show();
                        } else {
                            String comment = result.get();
                            controller.addComment(comment, question);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information");
                            alert.setHeaderText("Success");
                            alert.setContentText("The comment has been created");
                            alert.show();
                        }
                    }
                });
            }

            ListView lv = new ListView(FXCollections.observableArrayList(question.getOptions()));
            vb.getChildren().add(lv);
            vb.getChildren().add(hb);
            tps.add(new TitledPane(question.getBody(), vb));
        }
        acc.getPanes().addAll(tps);
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
        this.questions = new ArrayList<>(selectedCourse.getQuestionsRepository());
        FXMLLoader course = new FXMLLoader(getClass().getResource("ViewQuestions.fxml"));
        course.setController(this);

        try {
            Parent root = (Parent) course.load();
            primaryStage.setTitle("Mivhanet");
            primaryStage.setScene(new Scene(root, 700, 700));
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void back(){
        CourseView cv = new CourseView(primaryStage, user, controller, selectedCourse);
    }

}
