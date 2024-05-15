import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fenetre2 extends GridPane {
    private Button bouton;
       
    public Fenetre2(Button bouton){
        super();
        this.bouton = bouton;
       
        this.setPadding(new Insets(20));
        this.setHgap(25);
        this.setVgap(20);
        this.setStyle("-fx-background-color: #ffe4b5;");

        Text title = new Text("Fenêtre 2 (gridPane)");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 32));

        // Le titre à la position (0,0) sur 2 colonnes et 1 ligne.
        this.add(title, 0, 0, 2, 1);
        
        // Texte à la position (0,1) sur 2 colonnes et 1 ligne.
        this.add(new Text("Tables de multiplication"), 0, 1, 2, 1);
        
        // Image à la position (1, 3) sur 1 colonnes et 10 lignes.
        this.add(new ImageView(new Image("https://publicdomainvectors.org/photos/Calculator-Icon.png")), 1, 2, 1, 11);
        
        for (int i=0; i<10; i++){
           Text text = new Text(i+" * 5 = " +(i*5));
           this.add(text, 0, i+2);
        }
        
        // Bouton à la position (1, 13)
        this.add(this.bouton, 1, 13);
   }
}
