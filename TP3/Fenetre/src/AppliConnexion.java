import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

public class AppliConnexion extends GridPane{

    private Button bouton;

    public AppliConnexion(Button bouton){
        super();
        this.bouton = bouton;
        Label p = new Label("Entrez votre identifiant et votre mot de passe");
        Label lid = new Label("Identifiant");
        Label lmdp = new Label("Mot de passe");
        TextField id = new TextField();
        PasswordField mdp = new PasswordField();

        this.add(p, 0, 0);
        this.add(lid, 0, 1);
        this.add(lmdp, 0, 2);
        this.add(id, 1, 1);
        this.add(mdp, 1, 2);
        this.add(this.bouton, 1, 3);
        this.setVgap(10);
        this.setHgap(10);
        this.setPadding(new Insets(10));
    }
}