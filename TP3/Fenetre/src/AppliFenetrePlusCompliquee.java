import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Side;
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

public class AppliFenetrePlusCompliquee extends BorderPane{

    private Button bouton;

    public AppliFenetrePlusCompliquee(Button bouton){
        super();
        this.bouton = bouton;
        this.setTop(top());
        this.setCenter(center());
        this.setRight(right());
        this.setPrefWidth(1000);
    }

    public BorderPane top(){
        BorderPane pane = new BorderPane();
        Label textTop = new Label("Allo 45 - Module Analyste");
        textTop.setFont(Font.font("Arial",FontWeight.BOLD, 28));
        pane.setLeft(textTop);
        pane.setRight(this.bouton);
        pane.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        pane.setPadding(new Insets(10));
        return pane;
    }

    public VBox center(){
        VBox pane = new VBox();
        Label textCenter = new Label("Analyse du Sondage sur les habitudes alimentaires");
        textCenter.setFont(Font.font("Arial",FontWeight.NORMAL, 26));
        String combo_item[] = {"Pie", "Line", "Bar", "Data", "Localisation", "Area", "Relative"};
        ComboBox<String> combo = new ComboBox<String>(FXCollections.observableArrayList(combo_item));
        combo.getSelectionModel().selectFirst();
        PieChart pie = new PieChart();
        pie.setTitle("Que lisez-vous au petit déjeuner ?");
        pie.getData().setAll(
        new PieChart.Data("Le journal", 21),
        new PieChart.Data("Un livre", 3),
        new PieChart.Data("Le courier", 7),
        new PieChart.Data("La boîte de céréales", 75));
        pie.setLegendSide(Side.LEFT);
        Button prec = new Button("Question précédente", new ImageView(new Image("file:graphics/back.png")));
        Button suiv = new Button("Question suivante", new ImageView(new Image("file:graphics/next.png")));

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
}