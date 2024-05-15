import javafx.event.EventHandler;
import javafx.event.ActionEvent ;
import javafx.scene.control.Button;


public class ControleBouton implements EventHandler<ActionEvent>{
    
    private AppliPlusieursFenetres appli;
    
    public ControleBouton(AppliPlusieursFenetres appli){
        this.appli = appli;
    }
    
    @Override
    public void handle(ActionEvent event){
        Button button = (Button) (event.getSource());
        if (button.getText().contains("1"))
            this.appli.afficheFenetre1();
        else
            this.appli.afficheFenetre2();
    }
}
