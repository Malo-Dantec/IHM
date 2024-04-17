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

public class Calculette {

    protected TextField textFieldNb1;
    protected TextField textFieldNb2;
    private Nombre nombre;

    @Override init() {
        this.nombre = new Nombre();
    }

    @Override start(Stage stage) throws Exception {
        VBox root = new VBox();
        

        this.ajouteRes(root);
        this.ajouteBoutons(root);
        this.ajouteRes(root);

        Scene scene = new Scene(root);
        stage.setTitle("Calculette");
        stage.setScene(scene);
        stage.show();
    }

    public double getValueNb1() throws NumberFormatException {
        return Double.parseDouble(textFieldNb1.getText());
    }

    public double getValueNb2() throws NumberFormatException {
        return Double.parseDouble(textFieldNb2.getText());
    }

    private void ajouteRes(Pane root){
        HBox hbTitre = new HBox(20);
        Label res = new Label("Resultat : " + new ControleurBoutonADD(this.nombre, this));
        hbTitre.setAlignment(Pos.CENTER);
        image.setPreserveRatio(true);
        image.setFitHeight(10);
        hbTitre.getChildren().addAll(res);
        root.getChildren().add(hbTitre);
    }

    private void ajouteNb(Pane root){
        HBox hbADD = new HBox(20);
        hbADD.setPadding(new Insets(10, 10, 0, 10));
        this.textFieldNb1 = new TextField();
        this.textFieldNb2 = new TextField();
        hbADD.getChildren().addAll(this.textFieldNb1, this.textFieldNb2);
        // On connecte un controleur       
        this.textFieldNb2.setOnKeyReleased(new ControleurBoutonADD(this.nombre, this));
        root.getChildren().add(hbADD);
    }

    private void ajouteBoutons(Pane root){
        HBox hbButtons = new HBox(3);
        hbButtons.setPadding(new Insets(10, 10, 10, 10));
        Button buttonADD = new Button("+");
        // On connecte des controleurs        
        buttonADD.setOnAction(new ControleurBoutonAdd(this.temperature, this));
        hbButtons.getChildren().addAll(buttonADD);
        hbButtons.setAlignment(Pos.BASELINE_RIGHT);
        root.getChildren().add(hbButtons);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
