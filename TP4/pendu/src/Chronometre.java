import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


/**
 * Permet de gérer un Text associé à une Timeline pour afficher un temps écoulé
 */
public class Chronometre extends Text{
    /**
     * timeline qui va gérer le temps
     */
    private Timeline timeline;
    /**
     * la fenêtre de temps
     */
    private KeyFrame keyFrame;
    /**
     * le contrôleur associé au chronomètre
     */
    private ControleurChronometre controleur;

    /**
     * Constructeur permettant de créer le chronomètre
     * avec un label initialisé à "0:0:0"
     * Ce constructeur créer la Timeline, la KeyFrame et le contrôleur
     */
    public Chronometre(){
        // A implémenter
        this.setText("0:0:0");
        this.controleur = new ControleurChronometre(this.temps);
        this.keyFrame = new KeyFrame(Duration.millis(100), this.controleur);
        this.timeline =new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Permet au controleur de mettre à jour le text
     * la durée est affichée sous la forme m:s
     * @param tempsMillisec la durée depuis à afficher
     */
    public void setTime(long tempsMillisec){
        // A implémenter
    }

    /**
     * Permet de démarrer le chronomètre
     */
    public void start(){
        // A implémenter
        HBox root = new HBox(5);
        root.getChildren().addAll(new Text("Il s’est ´ecoul´e"), this .temps, new Text("secondes"));
        Chronometre();
        Scene scene = new Scene(root, 350, 500);
        primaryStage.setTitle("Test de chronometre");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet d'arrêter le chronomètre
     */
    public void stop(){
        // A implémenter
        this.timeline.stop();
    }

    /**
     * Permet de remettre le chronomètre à 0
     */
    public void resetTime(){
        // A implémenter
        this.timeline.stop();

    }
}
