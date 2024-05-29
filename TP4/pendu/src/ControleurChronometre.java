import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Contrôleur du chronomètre
 */
public class ControleurChronometre implements EventHandler<ActionEvent> {
    /**
     * temps enregistré lors du dernier événement
     */
    private long tempsPrec;
    /**
     * temps écoulé depuis le début de la mesure
     */
    private long tempsEcoule;
    /**
     * Vue du chronomètre
     */
    private Chronometre chrono;

    /**
     * Constructeur du contrôleur du chronomètre
     * noter que le modèle du chronomètre est tellement simple
     * qu'il est inclus dans le contrôleur
     * @param chrono Vue du chronomètre
     */
    public ControleurChronometre (Chronometre chrono){
        // A implémenter
        this.duree = 0;
        this.tempsCourant = -1; // le Chrono n’est pas encore lanc´e
        this.temps = temps;

    }

    /**
     * Actions à effectuer tous les pas de temps
     * essentiellement mesurer le temps écoulé depuis la dernière mesure
     * et mise à jour de la durée totale
     * @param actionEvent événement Action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        // A implémenter
        long heureDuSysteme = System.currentTimeMillis();
        if (this.tempsCourant != -1){
            // calcul du tps ´ecoul´e depuis la derni`ere frame
            long tempsEcoule = heureDuSysteme - this.tempsCourant;
            this.duree += tempsEcoule;
            this.temps.setText(duree/1000 +"");
        }
        this.tempsCourant = heureDuSysteme;
    }

    /**
     * Remet la durée à 0
     */
    public void reset(){
        // A implémenter
        this.duree = 0;
    }
}
