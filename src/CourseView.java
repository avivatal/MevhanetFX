import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class CourseView {

    private Stage primaryStage;
    private InstructionEmployee user;
    private Controller controller;
    private Course selectedCourse;

    @FXML
    MenuButton actions;

    @FXML
    public void initialize() {
        Pair<ArrayList<String>, InstructionEmployee> pair = controller.getAvailableActions(selectedCourse, user);
        user = pair.getValue();
        for(String action : pair.getKey()) {
            MenuItem item = new MenuItem(action);
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(action.equals("View Repository")) {
                        QuestionView qv = new QuestionView(primaryStage, (InstructionEmployee)user, controller, selectedCourse);
                    }
                    if(action.equals("Create Question")) {
                        CreateQuestionView cqv = new CreateQuestionView(primaryStage, (InstructionEmployee)user, controller, selectedCourse);
                    }
                }
            });
            actions.getItems().addAll(item);
        }
    }

    public CourseView(Stage primaryStage, InstructionEmployee user, Controller controller, Course selectedCourse){
        this.controller = controller;
        this.primaryStage = primaryStage;
        this.user = user;
        this.selectedCourse = selectedCourse;

        FXMLLoader course = new FXMLLoader(getClass().getResource("Course.fxml"));
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
        HomeView hv = new HomeView(primaryStage, user, controller);
    }
}
