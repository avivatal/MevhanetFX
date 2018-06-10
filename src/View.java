import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class View {


    @FXML public javafx.scene.control.TextField username;
    @FXML public javafx.scene.control.TextField password;
    @FXML Button login;

    Stage primaryStage;
    Controller controller;

    public View(){
        controller = new Controller(this, new Model());
    }

    public void login(){
        User user = controller.login();
        if(user == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Parameters");
            alert.setContentText("Please enter valid username and password");
            alert.show();
        }
        else {
            primaryStage.close();
            HomeView hv = new HomeView(primaryStage, user, controller);
        }
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
