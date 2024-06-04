import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Génère la vue d'un clavier et associe le contrôleur aux touches
 * le choix ici est d'un faire un héritié d'un TilePane
 */
public class Clavier extends TilePane{
    /**
     * il est conseillé de stocker les touches dans un ArrayList
     */
    private List<Button> clavier;

    /**
     * constructeur du clavier
     * @param touches une chaine de caractères qui contient les lettres à mettre sur les touches
     * @param actionTouches le contrôleur des touches
     * @param tailleLigne nombre de touches par ligne
     */
    public Clavier(String touches, EventHandler<ActionEvent> actionTouches) {
        super();
        this.clavier = new ArrayList<>();
        for (char lettre : touches.toCharArray()) {
            Button bouton = new Button(String.valueOf(lettre));
            bouton.setOnAction(actionTouches);
            this.clavier.add(bouton);
        }
        this.getChildren().addAll(clavier);
        this.setPadding(new Insets(10));
    }

    public List<Button> getClavier() {
        return clavier;
    }

    /**
     * permet de désactiver certaines touches du clavier (et active les autres)
     * @param touchesDesactivees une chaine de caractères contenant la liste des touches désactivées
     */
    public void desactiveTouches(Set<String> touchesDesactivees){
        for (Button bouton : this.clavier) {
            if (touchesDesactivees.contains(bouton.getText())) {
                bouton.setDisable(true);
            }
            else {
                bouton.setDisable(false);
            }
        }
    }
}