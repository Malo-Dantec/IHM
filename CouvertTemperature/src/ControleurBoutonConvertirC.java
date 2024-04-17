import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class ControleurBoutonConvertirC implements EventHandler<ActionEvent>{ 

    private AppliConverter appli;
    private Temperature temperature;
    
    public ControleurBoutonConvertirC(Temperature temperature, AppliConverter appli){
        this.appli = appli;
        this.temperature = temperature;
    }

    @Override
    public void handle(ActionEvent event) {
        double value;
        try{
            value = this.appli.getValueCelcius();
            this.temperature.setvaleurCelcius(value);
            this.appli.majTF();                
        }
        catch (NumberFormatException exp) {
            this.appli.effaceTF();
        }
    }
}