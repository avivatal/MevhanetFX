import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CreateQuestionView {

    private Stage primaryStage;
    private InstructionEmployee user;
    private Controller controller;
    private Question questionToAdd;
    private Course selectedCourse;


    @FXML TableView optionsList;
    @FXML TextField bodyTextField;
    @FXML Button addQuestionBTN;

    @FXML
    public void initialize() {

    }

    public CreateQuestionView(Stage primaryStage, InstructionEmployee user, Controller controller, Course selectedCourse){
        this.controller = controller;
        this.primaryStage = primaryStage;
        this.user = user;
        this.selectedCourse = selectedCourse;
        FXMLLoader newQuestionView = new FXMLLoader(getClass().getResource("newQuestion.fxml"));
        newQuestionView.setController(this);

        try {
            Parent root = (Parent) newQuestionView.load();
            primaryStage.setTitle("Mivhanet");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
