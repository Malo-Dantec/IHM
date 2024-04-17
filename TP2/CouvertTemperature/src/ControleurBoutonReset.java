import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class ControleurBoutonReset implements EventHandler<ActionEvent>{ 

    private AppliConverter appli;
    
    public ControleurBoutonReset(AppliConverter appli){
        this.appli = appli;
    }

    @Override
    public void handle(ActionEvent event) {
        this.appli.effaceTF();
    }
          
}
