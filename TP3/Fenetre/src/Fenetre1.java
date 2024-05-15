import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

 
 
public class Fenetre1 extends BorderPane {
    
    private Button bouton;
    
    public Fenetre1(Button bouton){
        super();
        this.bouton = bouton;
        
        this.setPadding(new Insets(10));
        this.setTop(this.enHaut());
        this.setLeft(this.bouton);       
        this.setCenter(this.uneVBox());
        this.setRight(new ImageView(new Image("https://publicdomainvectors.org/photos/Calculator-Icon.png")));
    }
    
    private Pane enHaut(){
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20,20,20,10));        
        Text title = new Text("Fenêtre 1 (borderPane)");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        hbox.getChildren().add(title);
        hbox.setStyle("-fx-background-color: #7fffd4;");
        return hbox;
    }

    private VBox uneVBox() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().add(new Text("Tables de multiplication"));
        for (int i=0; i<10; i++){
            vbox.getChildren().add(new Text(i+" * 5 = " +(i*5)));
        }
        vbox.setStyle("-fx-background-color: #98fb98;");        
        return vbox;
    }
}
