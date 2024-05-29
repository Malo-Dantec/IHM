import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.scene.control.ButtonBar.ButtonData ;

import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;

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

/**
 * Vue du jeu du pendu
 */
public class Pendu extends Application {
    private Stage stage;
    /**
     * modèle du jeu
     **/
    private MotMystere modelePendu;
    /**
     * Liste qui contient les images du jeu
     */
    private ArrayList<Image> lesImages;
    /**
     * Liste qui contient les noms des niveaux
     */
    public List<String> niveaux;

    // les différents contrôles qui seront mis à jour ou consultés pour l'affichage
    /**
     * le dessin du pendu
     */
    private ImageView dessin;
    /**
     * le mot à trouver avec les lettres déjà trouvé
     */
    private Text motCrypte;
    /**
     * la barre de progression qui indique le nombre de tentatives
     */
    private ProgressBar pg;
    /**
     * le clavier qui sera géré par une classe à implémenter
     */
    private Clavier clavier;
    /**
     * le text qui indique le niveau de difficulté
     */
    private Text leNiveau;
    /**
     * le chronomètre qui sera géré par une clasee à implémenter
     */
    private Chronometre chrono;
    /**
     * le panel Central qui pourra être modifié selon le mode (accueil ou jeu)
     */
    private BorderPane panelCentral;
    /**
     * le bouton Info / Rond avec un I dedans
     */
    private Button boutonInfo;
    /**
     * le bouton Paramètre / Engrenage
     */
    private Button boutonParametres;
    /**
     * le bouton Accueil / Maison
     */
    private Button boutonMaison;
    /**
     * le bouton qui permet de (lancer ou relancer une partie
     */
    private Button bJouer;

    /**
     * initialise les attributs (créer le modèle, charge les images, crée le chrono
     * ...)
     */
    @Override
    public void init() {
        this.modelePendu = new MotMystere("./dict/french", 3, 10, MotMystere.FACILE, 10);
        this.lesImages = new ArrayList<Image>();
        this.chargerImages("./img");

        ImageView imageHome = new ImageView(new Image("file:img/home.png", 50, 50, true, true));
        this.boutonMaison = new Button("", imageHome);
        RetourAccueil retourAccueil = new RetourAccueil(modelePendu, this);
        this.boutonMaison.setOnAction(retourAccueil);
        this.desacBoutonAccueil();

        ImageView imageParam = new ImageView(new Image("file:img/parametres.png", 50, 50, true, true));
        this.boutonParametres = new Button("", imageParam);

        ImageView imageInfo = new ImageView(new Image("file:img/info.png", 50, 50, true, true));
        this.boutonInfo = new Button("", imageInfo);

        this.bJouer = new Button("Lancer une partie");
        ControleurLancerPartie controleurLancerPartie = new ControleurLancerPartie(modelePendu, this);
        this.bJouer.setOnAction(controleurLancerPartie);

        this.niveaux = Arrays.asList("Facile", "Médium", "Difficile", "Expert");

        this.motCrypte = new Text(modelePendu.getMotCrypte());
        motCrypte.setFont(Font.font("Arial", FontWeight.NORMAL, 28));

        this.pg = new ProgressBar(0);

        this.leNiveau = new Text("Niveau " + modelePendu.nomNiveau());

        // A terminer d'implementer
    }

    /**
     * @return le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene() {
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.titre());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }

    /**
     * @return le panel contenant le titre du jeu
     */
    private HBox titre() {
        // A implementer

        HBox banniere = new HBox();
        Label titre = new Label("Jeu du Pendu");
        titre.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        Region espace = new Region();
        HBox.setHgrow(espace, Priority.ALWAYS);
        banniere.getChildren().addAll(titre, espace, boutonMaison, boutonParametres, boutonInfo);
        banniere.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        banniere.setSpacing(2);
        banniere.setPadding(new Insets(15));
        banniere.setAlignment(Pos.CENTER);
        return banniere;
    }

    // /**
    // * @return le panel du chronomètre
    // */
    // private TitledPane leChrono(){
    // A implementer
    // TitledPane res = new TitledPane();
    // return res;
    // }

    /**
     * @return la fenêtre de jeu avec le mot crypté, l'image, la barre
     *         de progression et le clavier
     */
    private BorderPane fenetreJeu() {
        // Milieu
        BorderPane pane = new BorderPane();
        VBox centre = new VBox();
        ImageView dessinPendu = new ImageView(lesImages.get(modelePendu.getNbEssais()));
        TilePane tile = new TilePane();
        tile.setPrefColumns(8);
        tile.setMaxWidth(400);
        for (char c = 'A'; c <= 'Z'; c++) {
            Button b = new Button("" + c);
            b.autosize();
            tile.getChildren().add(b);
        }
        tile.setPadding(new Insets(10));
        centre.setAlignment(Pos.CENTER);
        centre.getChildren().addAll(motCrypte, dessinPendu, pg, tile);
        pane.setCenter(centre);

        // Droite
        VBox droite = new VBox();

        // TitledPane titledPane = new TitledPane("Chronomètre");
        droite.setAlignment(Pos.CENTER);
        droite.getChildren().addAll(leNiveau);
        pane.setRight(droite);
        return pane;
    }

    /**
     * @return la fenêtre d'accueil sur laquelle on peut choisir les paramètres de
     *         jeu
     */
    private BorderPane fenetreAccueil() {
        BorderPane pane = new BorderPane();
        VBox vbox = new VBox();
        VBox difficulte = new VBox();
        ToggleGroup group = new ToggleGroup();
        boolean d = false;
        for (String s : niveaux) {
            RadioButton r = new RadioButton(s);
            r.setToggleGroup(group);
            difficulte.getChildren().add(r);
            if (!d) {
                r.setSelected(true);
                d = true;
            }
        }
        // RadioButton facile = new RadioButton("Facile");
        // facile.setToggleGroup(group);
        // facile.setSelected(true);
        // RadioButton medium = new RadioButton("Médium");
        // medium.setToggleGroup(group);
        // RadioButton difficile = new RadioButton("Difficile");
        // difficile.setToggleGroup(group);
        // RadioButton expert = new RadioButton("Expert");
        // expert.setToggleGroup(group);
        // difficulte.getChildren().addAll(facile, medium, difficile, expert);
        TitledPane titledPane = new TitledPane("Niveau de difficulté", difficulte);
        titledPane.setCollapsible(false);
        vbox.getChildren().addAll(bJouer, titledPane);
        vbox.setSpacing(10);
        difficulte.setSpacing(10);
        pane.setCenter(vbox);
        pane.setPadding(new Insets(15));
        return pane;
    }

    /**
     * charge les images à afficher en fonction des erreurs
     * 
     * @param repertoire répertoire où se trouvent les images
     */
    private void chargerImages(String repertoire) {
        for (int i = 0; i < this.modelePendu.getNbErreursMax() + 1; i++) {
            File file = new File(repertoire + "/pendu" + i + ".png");
            System.out.println(file.toURI().toString());
            this.lesImages.add(new Image(file.toURI().toString()));
        }
    }

    public void modeAccueil() {
        this.panelCentral = fenetreAccueil();
        stage.setScene(this.laScene());
        stage.show();
    }

    public void modeJeu() {
        this.panelCentral = fenetreJeu();
        stage.setScene(this.laScene());
        stage.show();
    }

    public void modeParametres() {
        // A implémenter
    }

    /** lance une partie */
    public void lancePartie() {
        // A implementer
    }

    /**
     * raffraichit l'affichage selon les données du modèle
     */
    public void majAffichage() {
        // A implementer
    }

    /**
     * accesseur du chronomètre (pour les controleur du jeu)
     * 
     * @return le chronomètre du jeu
     */
    public Chronometre getChrono() {
        // A implémenter
        return null; // A enlever
    }

    public Alert popUpPartieEnCours() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "La partie est en cours!\n Etes-vous sûr de l'interrompre ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public Alert popUpReglesDuJeu() {
        // A implementer
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        return alert;
    }

    public Alert popUpMessageGagne() {
        // A implementer
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        return alert;
    }

    public Alert popUpMessagePerdu() {
        // A implementer
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        return alert;
    }

    /**
     * créer le graphe de scène et lance le jeu
     * 
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("IUTEAM'S - La plateforme de jeux de l'IUTO");
        this.modeAccueil();
        // this.modeJeu();
        stage.setScene(this.laScene());
        stage.show();
    }

    public void desacBoutonAccueil() {
        this.boutonMaison.setDisable(true);
    }

    public void activerBoutonAccueil() {
        this.boutonMaison.setDisable(false);
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }
}