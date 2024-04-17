import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class ControleurBoutonConvertirK implements EventHandler<ActionEvent>{ 

    private AppliConverter appli;
    private Temperature temperature;
    
    public ControleurBoutonConvertirK(Temperature temperature, AppliConverter appli){
        this.appli = appli;
        this.temperature = temperature;
    }

    @Override
    public void handle(ActionEvent event) {
        double value;
        try{
            value = this.appli.getValueKelvin();
            this.temperature.setvaleurKelvin(value);;
            this.appli.majTF();                
        }
        catch (NumberFormatException exp) {
            this.appli.effaceTF();
        }
    }
}