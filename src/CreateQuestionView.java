import static java.lang.System.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CreateQuestionView {

    private Stage primaryStage;
    private InstructionEmployee user;
    private Controller controller;
    private Question questionToAdd;
    private Course selectedCourse;
    private ArrayList<Option> options;
    private int diff;

    @FXML
    ListView optionsList;
    @FXML
    TextField bodyTextField;
    @FXML
    TextField time;
    @FXML
    Button addBtn;
    @FXML
    ComboBox difficulty;

    @FXML
    public void initialize() {
        for (int i = 0; i < 6; i++) {
            difficulty.getItems().add("" + i);
        }

    }

    public void addOption() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add an Option");
        dialog.setHeaderText("Add an Option");
        Optional<String> optionBody = dialog.showAndWait();

        if (optionBody.isPresent()) {
            List<String> choices = new ArrayList<>();
            choices.add("True");
            choices.add("False");
            ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>("True", choices);
            choiceDialog.setTitle("True or False?");
            choiceDialog.setHeaderText("Is the option True or False?");
            Optional<String> trueOrFalse = choiceDialog.showAndWait();
            if (trueOrFalse.isPresent()) {
                Option option = new Option(optionBody.get(), Boolean.valueOf(trueOrFalse.get().toLowerCase()));
                options.add(option);
                optionsList.getItems().add(option.toString());
            }
        }
    }

    public void addQuestion() {
        double timed;

        try {
            timed = Double.parseDouble(time.getText());

            if (!bodyTextField.getText().isEmpty() && !time.getText().isEmpty()) {
                controller.createQuestion(user, selectedCourse, bodyTextField.getText(), options,
                        diff, timed);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Question was created successfully!");
                alert.showAndWait();
                primaryStage.close();
                HomeView hm = new HomeView(primaryStage, user, controller);
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("Please enter all parameters");
                error.show();
            }
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Please enter time to solve in minutes!");
            error.show();
        }
    }

    public CreateQuestionView(Stage primaryStage, InstructionEmployee user, Controller controller, Course selectedCourse) {
        this.controller = controller;
        this.primaryStage = primaryStage;
        this.user = user;
        this.selectedCourse = selectedCourse;
        FXMLLoader newQuestionView = new FXMLLoader(getClass().getResource("newQuestion.fxml"));
        newQuestionView.setController(this);
        options = new ArrayList<>();

        try {
            Parent root = (Parent) newQuestionView.load();
            primaryStage.setTitle("Mivhanet");
            primaryStage.setScene(new Scene(root, 700, 700));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void back(){
        CourseView cv = new CourseView(primaryStage, (InstructionEmployee)user, controller, selectedCourse);
    }

}
