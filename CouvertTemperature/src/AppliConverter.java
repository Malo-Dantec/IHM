import javafx.application.Application;
import javafx.application.Platform;
// import javafx.beans.binding.Bindings;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class AppliConverter extends Application {

    protected TextField textFieldC ;
    protected TextField textFieldF ;
    private Temperature temperature;

    @Override
    public void init(){
        // Initialisation des objects qui ne sont pas dans la scène
        // cad des éléments non graphiques
        this.temperature = new Temperature();
    }

    @Override
    public void start(Stage stage) throws Exception{
        // Construction du graphe de scène
        VBox root = new VBox();

        this.ajouteTitre(root);
        this.ajouteCelscius(root);
        this.ajouteFahrenheit(root);
        this.ajouteBoutons(root);
        
        Scene scene = new Scene(root);
        stage.setTitle("Convertisseur de temperatures");
        stage.setScene(scene);
        stage.show();
    }

    public void effaceTF(){
        this.textFieldF.setText("");
        this.textFieldC.setText("");
    }
    
    public double getValueCelcius() throws NumberFormatException{
        return Double.parseDouble(textFieldC.getText());
    }

    public double getValueFahrenheit() throws NumberFormatException{
        return Double.parseDouble(textFieldF.getText());
    }    

    public void majTF(){
        this.textFieldC.setText(this.temperature.valeurCelcius()+"");
        this.textFieldF.setText(this.temperature.valeurFahrenheit()+"");
    }

    public void quitte(){
        Platform.exit();
    }

    private void ajouteTitre(Pane root){
        HBox hbTitre = new HBox(20);
        Label titre = new Label("Pour convertir des °C en °F\nappuie sur ENTRER");
        ImageView image = new ImageView("thermometer.png");
        hbTitre.setAlignment(Pos.CENTER);
        image.setPreserveRatio(true);
        image.setFitHeight(100);
        hbTitre.getChildren().addAll(image, titre);
        root.getChildren().add(hbTitre);
    }

    private void ajouteCelscius(Pane root){
        HBox hbCelsius = new HBox(20);
        hbCelsius.setPadding(new Insets(10, 10, 0, 10));
        Label labelC = new Label("Celsius");
        this.textFieldC = new TextField();
        hbCelsius.getChildren().addAll(labelC, this.textFieldC);
        // On connecte un controleur       
        this.textFieldC.setOnKeyReleased(new ControleurTFC(this.temperature, this));
        root.getChildren().add(hbCelsius);
    }

    private void ajouteFahrenheit(Pane root){
        HBox hbFarhen = new HBox(20);
        hbFarhen.setPadding(new Insets(10, 10, 0, 10));
        Label labelF = new Label("Fahrenheit");
        this.textFieldF  = new TextField();
        hbFarhen.getChildren().addAll(labelF, this.textFieldF);
        // On connecte un controleur       
        this.textFieldF.setOnKeyReleased(new ControleurTFF(this.temperature, this));
        root.getChildren().add(hbFarhen);
    }

    private void ajouteBoutons(Pane root){
        HBox hbButtons = new HBox(3);
        hbButtons.setPadding(new Insets(10, 10, 10, 10));
        Button buttonReset = new Button("Reset");
        Button buttonQuitter = new Button("Quitter");
        // On connecte des controleurs        
        buttonQuitter.setOnAction(new ControleurBoutonQuitter(this));
        buttonReset.setOnAction(new ControleurBoutonReset(this));
        
        hbButtons.getChildren().addAll(buttonReset, buttonQuitter);
        hbButtons.setAlignment(Pos.BASELINE_RIGHT);
        root.getChildren().add(hbButtons);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
