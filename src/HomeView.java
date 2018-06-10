import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeView {

    Stage primaryStage;
    User user;
    Controller controller;


    @FXML MenuButton courses;
    @FXML Label username;

    @FXML
    public void initialize() {
        username.setText(user.userName);
        ArrayList<String> courseList = controller.getCourses(user.getID());
        for(String s : courseList){
            MenuItem item = new MenuItem(s);
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    selectCourse(event);
                }
            });
            courses.getItems().addAll(item);
        }

    }

    public void selectCourse(ActionEvent event){
        MenuItem source = (MenuItem) event.getSource();
        String courseName = source.getText();
        Course course = new Course();
        course.setCourseName(courseName);
        controller.getCourseDetails(course);
        primaryStage.close();
        CourseView cv = new CourseView(primaryStage, (InstructionEmployee)user, controller, course);
    }


    public HomeView(Stage stage, User user, Controller controller){
        FXMLLoader home = new FXMLLoader(getClass().getResource("Home.fxml"));
        home.setController(this);
        primaryStage = stage;
        this.user = user;
        this.controller = controller;

        try {
            Parent root = (Parent) home.load();
            primaryStage.setTitle("Mivhanet");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setUser(User user) {
        this.user = user;
        username.setText(user.userName);
    }
}
