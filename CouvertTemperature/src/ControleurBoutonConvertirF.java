import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class ControleurBoutonConvertirF implements EventHandler<ActionEvent>{ 

    private AppliConverter appli;
    private Temperature temperature;
    
    public ControleurBoutonConvertirF(Temperature temperature, AppliConverter appli){
        this.appli = appli;
        this.temperature = temperature;
    }

    @Override
    public void handle(ActionEvent event) {
        double value;
        try{
            value = this.appli.getValueFahrenheit();
            this.temperature.setvaleurFahrenheit(value);
            this.appli.majTF();                
        }
        catch (NumberFormatException exp) {
            this.appli.effaceTF();
        }
    }
}