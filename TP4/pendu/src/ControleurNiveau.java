import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

/**
 * Controleur des radio boutons gérant le niveau
 */
public class ControleurNiveau implements EventHandler<ActionEvent> {

    /**
     * modèle du jeu
     */
    private MotMystere modelePendu;


    /**
     * @param modelePendu modèle du jeu
     */
    public ControleurNiveau(MotMystere modelePendu) {
        this.modelePendu = modelePendu;
    }

    /**
     * gère le changement de niveau
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        // A implémenter
        RadioButton radiobouton = (RadioButton) actionEvent.getTarget();
        if (radiobouton.getText().equals("Facile")) {
            this.modelePendu.setNiveau(0);
        }
        if (radiobouton.getText().equals("Moyen")) {
            this.modelePendu.setNiveau(1);
        }
        if (radiobouton.getText().equals("Difficile")) {
            this.modelePendu.setNiveau(2);
        }
        if (radiobouton.getText().equals("Expert")) {
            this.modelePendu.setNiveau(3);
        }
    }
}