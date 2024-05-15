
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.chart.*;
import javafx.geometry.Side;


public class FenetreAnalyste extends Application{
    
    private BorderPane root() throws FileNotFoundException {

        BorderPane bpane = new BorderPane();


        BorderPane bpaneTop = new BorderPane();
        Text textTop = new Text("Allo 45 - Module Analyste");
        
        Button buttonDeconnect = new Button("Déconnexion");
        Image imageDeconnect = new Image(new FileInputStream("graphics/user.png"));
        buttonDeconnect.setGraphic(new ImageView(imageDeconnect));

        bpaneTop.setRight(buttonDeconnect);
        bpaneTop.setLeft(textTop);
        bpaneTop.setPadding(new Insets(20));


        VBox vboxCenter = new VBox();
        Text textCenter = new Text("Analyse du Sondage sur les habitudes alimentaires");
        ComboBox<String> comboboxCenter = new ComboBox<>();
        PieChart chart = new PieChart () ;
        chart.setTitle("Que lisez-vous au petit déjeuner ?");
        chart.getData().setAll(
            new PieChart.Data( "Le journal", 21),
            new PieChart.Data( "Un livre", 3),
            new PieChart.Data( "Le courier", 7),
            new PieChart.Data( "La boîte de céréales", 75));
        chart.setLegendSide(Side.LEFT); // pour mettre la légende à gauche
        HBox hboxButtonCenter = new HBox();
        Button buttonLastCenter = new Button("Question précédente");
        Button buttonNextCenter = new Button("Question suivante");
        hboxButtonCenter.getChildren().addAll(buttonLastCenter, buttonNextCenter);
        vboxCenter.getChildren().addAll(textCenter, comboboxCenter, chart, hboxButtonCenter);


        TilePane tilePaneRight = new TilePane();
        

        bpane.setTop(bpaneTop);
        bpane.setCenter(vboxCenter);
        bpane.setRight(tilePaneRight);

        return bpane;
    }
    
    @Override
    public void start(Stage stage){
        Scene scene = new Scene(root());
        stage.setTitle("Fenetre Analyste");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
