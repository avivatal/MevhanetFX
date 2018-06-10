import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader login = new FXMLLoader(getClass().getResource("Login.fxml"));
        View view = new View();
        login.setController(view);

        Parent root = (Parent)login.load();
        primaryStage.setTitle("Mivhanet");
        primaryStage.setScene(new Scene(root, 300, 275));
        view.setPrimaryStage(primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
