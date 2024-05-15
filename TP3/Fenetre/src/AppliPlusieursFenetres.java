import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


 
public class AppliPlusieursFenetres extends Application {
    
    private Button btn1;
    private Button btn2;
    private Scene scene;
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(AppliPlusieursFenetres.class, args);
    }
    
    @Override
    public void init(){
        this.btn1 = new Button("Vers la fenêtre 2");        
        this.btn2 = new Button("Vers la fenetre 1");

        ControleBouton controleur = new ControleBouton(this);        
        this.btn1.setOnAction(controleur);
        this.btn2.setOnAction(controleur);
        
    }
    
    @Override
    public void start(Stage stage) {
        Pane root = new Fenetre1(this.btn1);
        this.scene = new Scene(root, 900, 700);
        stage.setScene(scene);
        stage.setTitle("Appli avec deux fenêtres");
        stage.show();
    }
 
    public void afficheFenetre1(){
        Pane root = new Fenetre1(this.btn1);
        this.scene.setRoot(root);
    }
    
    public void afficheFenetre2(){
        Pane root = new Fenetre2(this.btn2);    
        this.scene.setRoot(root);
    }
}
