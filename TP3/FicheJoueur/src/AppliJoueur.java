import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.paint.Color;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;

public class AppliJoueur extends Application{
    public BorderPane root() {
        BorderPane bPane = new BorderPane();
        bPane.setTop(labelTop());
        bPane.setLeft(vboxLeft());
        bPane.setCenter(gridPaneCenter());
        bPane.setBottom(bPaneBottom());
        return bPane;
    }

    public Label labelTop() {
        Label labelTop = new Label("Consultation/modification d'une fiche joueur");
        labelTop.setFont(Font.font("Arial",FontWeight.NORMAL, 26));
        labelTop.setPadding(new Insets(10));
        return labelTop;
    }

    public VBox vboxLeft() {
        VBox vbox = new VBox();
        Button buttonDebut = new Button("Début");
        buttonDebut.setMinSize(80, 20);
        Button buttonPrec = new Button("Prec");
        buttonPrec.setMinSize(80, 20);
        Button buttonValider = new Button("Valider");
        buttonValider.setMinSize(80, 20);
        Button buttonNouveau = new Button("Nouveau");
        buttonNouveau.setMinSize(80, 20);
        Button buttonSuiv = new Button("Suiv");
        buttonSuiv.setMinSize(80, 20);
        Button buttonDern = new Button("Dern");
        buttonDern.setMinSize(80, 20);

        vbox.setSpacing(2);
        vbox.setMinWidth(90);
        vbox.getChildren().addAll(buttonDebut, buttonPrec, buttonValider, buttonNouveau, buttonSuiv, buttonDern);
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(new Background(new BackgroundFill(Color.LAVENDERBLUSH, CornerRadii.EMPTY, Insets.EMPTY)));
        return vbox;

    }

    public GridPane gridPaneCenter() {
        Label labelPseudo = new Label("Pseudo :");
        TextField fieldPseudo = new TextField();
        fieldPseudo.setPromptText("Entrer votre pseudo");

        Label labelMDP = new Label("Mot de passe :");
        PasswordField fieldPassword = new PasswordField();
        fieldPassword.setPromptText("Entrer votre mot de passe");


        Label labelPoste = new Label("Poste :");
        String combo_item[] = {"a", "b", "c", "d", "e", "f", "g"};
        ComboBox<String> combobox = new ComboBox<String>(FXCollections.observableArrayList(combo_item));
        combobox.setMinWidth(120);

        ImageView img = new ImageView(new Image("file:img/shrek.jpg"));
        img.setFitHeight(100);
        img.setFitWidth(100);
        img.setPreserveRatio(true);

        GridPane gPane = new GridPane();
        gPane.add(labelPseudo, 0, 0);
        gPane.add(fieldPseudo, 1, 0, 2, 1);
        gPane.add(labelMDP, 0, 1);
        gPane.add(fieldPassword, 1, 1, 2, 1);
        gPane.add(labelPoste, 0, 2);
        gPane.add(combobox, 1, 2, 2, 1);
        gPane.add(titlePane(), 1, 4, 2, 1);
        gPane.add(img, 3, 0, 2, 3);

        gPane.setPadding(new Insets(20));
        gPane.setHgap(20);
        gPane.setVgap(10);
        gPane.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, CornerRadii.EMPTY, Insets.EMPTY)));

        return gPane;
    }

    public TitledPane titlePane() {
        RadioButton radioButton1 = new RadioButton("Débutant");
        RadioButton radioButton2 = new RadioButton("Medium");
        RadioButton radioButton3 = new RadioButton("Expert");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(radioButton1, radioButton2, radioButton3);
        
        TitledPane ttpane = new TitledPane("Niveau", vbox);
        return ttpane;
    }


    public BorderPane bPaneBottom() {
        BorderPane bPane = new BorderPane();
        Label labelLeft = new Label("Nb de fiches : 102");
        Label labelCenter = new Label("Numéro de la fiche : 10");
        Label labelRight = new Label("Fiche modifiée*");
        bPane.setLeft(labelLeft);
        bPane.setCenter(labelCenter);
        bPane.setRight(labelRight);
        bPane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
        return bPane;
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(root());
        stage.setTitle("Gestion d'un club de Quidditch");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
