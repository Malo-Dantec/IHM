import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AppliFenetre extends Application{

    private Label textTop;
    private Button deco;
    private Label textCenter;
    private ComboBox<String> combo;
    private PieChart pie;
    private Button prec;
    private Button suiv;

    @Override
    public void init() {
        this.textTop = new Label("Allo 45 - Module Analyste");
        textTop.setFont(Font.font("Arial",FontWeight.BOLD, 28));
        this.deco = new Button("Deconnexion", new ImageView(new Image("file:graphics/user.png")));

        this.textCenter = new Label("Analyse du Sondage sur les habitudes alimentaires");
        textCenter.setFont(Font.font("Arial",FontWeight.NORMAL, 26));
        String combo_item[] = {"Pie", "Line", "Bar", "Data", "Localisation", "Area", "Relative"};
        this.combo = new ComboBox<String>(FXCollections.observableArrayList(combo_item));
        combo.getSelectionModel().selectFirst();
        this.pie = new PieChart();
        pie.setTitle("Que lisez-vous au petit déjeuner ?");
        pie.getData().setAll(
        new PieChart.Data("Le journal", 21),
        new PieChart.Data("Un livre", 3),
        new PieChart.Data("Le courier", 7),
        new PieChart.Data("La boîte de céréales", 75));
        pie.setLegendSide(Side.LEFT);
        this.prec = new Button("Question précédente", new ImageView(new Image("file:graphics/back.png")));
        this.suiv = new Button("Question suivante", new ImageView(new Image("file:graphics/next.png")));

    }

    public BorderPane top(){
        BorderPane pane = new BorderPane();
        pane.setLeft(textTop);
        pane.setRight(deco);
        pane.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        pane.setPadding(new Insets(10));
        return pane;
    }

    public VBox center(){
        VBox pane = new VBox();
        HBox boutton = new HBox(prec, suiv);
        boutton.setSpacing(10);
        pane.getChildren().addAll(textCenter,combo,pie,boutton);
        pane.setPadding(new Insets(10));
        pane.setSpacing(10);
        return pane;
    }

    public TilePane right(){
        TilePane pane = new TilePane();
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        for (int i = 1; i < 9; i++) {
            String nomImg = "file:graphics/chart_"+i+".png";
            pane.getChildren().add(new ImageView(new Image(nomImg)));
        }
        pane.setPadding(new Insets(10));
        pane.setVgap(5);
        pane.setHgap(5);
        return pane;
    }

    private BorderPane root() {
        BorderPane pane = new BorderPane();
        pane.setTop(top());
        pane.setCenter(center());
        pane.setRight(right());
        pane.setPrefWidth(1000);
        return pane;
    }


    @Override
    public void start(Stage stage) {
        Scene scene =new Scene(root());
        stage.setTitle("Allo 45");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}