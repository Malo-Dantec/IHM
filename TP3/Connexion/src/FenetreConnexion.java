import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FenetreConnexion extends Application {

    @Override
    public void start(Stage stage){ 
        GridPane grid = new GridPane();
        grid.add(new Text("Entrez votre identifiant et votre mot de passe"), 0, 0, 2, 1);
        grid.add(new Label("Identifiant"), 0, 1);
        grid.add(new TextField(), 1, 1);
        grid.add(new Label("Mot de passe"), 0, 2);
        grid.add(new PasswordField(), 1, 2); 
        grid.add(new Button("Connexion"), 1, 3);

        grid.setPadding(new Insets(20));
        grid.setHgap(50);
        grid.setVgap(10);

        Scene scene = new Scene(grid);
        stage.setTitle("Connexion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}








