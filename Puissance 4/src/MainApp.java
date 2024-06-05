import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //--- Chargement du fichier FXML
        VBox root = FXMLLoader.load(getClass().getResource("Puissance4.fxml"));
        //BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Puissance 4");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
