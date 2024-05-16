import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton info
 */
public class ControleurInfos implements EventHandler<ActionEvent> {

    private Pendu appliPendu;

    /**
     * @param p vue du jeu
     */
    public ControleurInfos(Pendu appliPendu) {
        this.appliPendu = appliPendu;
    }

    /**
     * L'action consiste à afficher une fenêtre popup précisant les règles du jeu.
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.appliPendu.popUpReglesDuJeu().showAndWait();
    }
}
