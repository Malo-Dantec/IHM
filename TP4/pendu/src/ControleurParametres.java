import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton pararmetre
 */
public class ControleurParametres implements EventHandler<ActionEvent> {

    private Pendu vuePendu;

    /**
     * @param p vue du jeu
     */
    public ControleurParametres(Pendu vuePendu) {
        this.vuePendu = vuePendu;
    }

    /**
     * L'action consiste à afficher une fenêtre des parametres
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.vuePendu.modeParametres();
        this.vuePendu.majAffichage();
    }
}