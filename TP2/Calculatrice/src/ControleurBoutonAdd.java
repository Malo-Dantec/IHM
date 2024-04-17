import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class ControleurBoutonAdd implements EventHandler<ActionEvent> {
    
    private Nombre nombre1;
    private Nombre nombre2;
    private Calculette calculette;

    public ControleurBoutonAdd(Nombre nb1, Nombre nb2, Calculette calc) {
        this.nombre1 = nb1;
        this.nombre2 = nb2;
        this.calculette = calc;
    }

    @Override
    public void handle(ActionEvent event) {




    }





}
