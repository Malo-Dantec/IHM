import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ControleurCouleur implements EventHandler<ActionEvent> {
    private Pendu vuePendu;
    private ColorPicker colorPicker;
    

    public ControleurCouleur(Pendu vuePendu, ColorPicker myColorPicker){
        this.vuePendu=vuePendu;
        this.colorPicker=myColorPicker;
    }

    @Override
    public void handle(ActionEvent event){
        Color myColor = colorPicker.getValue();
        vuePendu.setCouleur(myColor);
        vuePendu.getBanniere().setBackground(new Background(new BackgroundFill(myColor,null, null)));
        vuePendu.getRectangleCouleur().setFill(myColor);
        vuePendu.setCouleur(myColor);
    }

}