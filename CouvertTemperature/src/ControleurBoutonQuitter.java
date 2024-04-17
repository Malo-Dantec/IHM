import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class ControleurBoutonQuitter implements EventHandler<ActionEvent>{ 

    private AppliConverter appli;
    
    public ControleurBoutonQuitter(AppliConverter appli){
        this.appli = appli;
    }

    @Override
    public void handle(ActionEvent event) {
        this.appli.quitte();
    }
}
