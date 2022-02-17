import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class main extends Application {

    private int screenWidth = 850;
    private int screenHeight = 700;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {



        // Welcome Screen
        StackPane startStack = new StackPane();
        GridPane startRoot = new GridPane();
        BorderPane bpStart = new BorderPane();
        bpStart.setPadding(new Insets(10,10,10,10));
        // Background Image
        Image background = new Image("welcome.jpeg");
        ImageView backgroundView = new ImageView(background);
        startStack.getChildren().add(backgroundView);
        // Header
        Text header = new Text(175, 60,"The Scarlet Tower");
        header.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
        header.setFill(Color.BLACK);
        bpStart.setTop(header);
        BorderPane.setAlignment(header, Pos.CENTER);
        startStack.getChildren().add(bpStart);
        //Buttons
        startRoot.setPadding(new Insets(5, 5, 5, 5));
        startRoot.setVgap(1);
        startRoot.setHgap(8);
        startRoot.setAlignment(Pos.CENTER);

        Font font = Font.font("Courier New", FontWeight.BOLD, 20);

        Button start = new Button("Start");
        start.setFont(font);
        start.setMinSize(20, 50);
        startRoot.add(start, 1, 20);

        Button quit = new Button("Quit");
        quit.setFont(font);
        quit.setMinSize(20, 50);
        startRoot.add(quit, 30, 20);

        startStack.getChildren().add(startRoot);

        // Player Configuration Screen
        GridPane configRoot = new GridPane();

        Scene startScene = new Scene(startStack, screenWidth, screenHeight);
        Scene ConfigScene = new Scene(configRoot, screenWidth, screenHeight);

        start.setOnAction(e-> {
            primaryStage.setScene(ConfigScene);
        });
        quit.setOnAction(e-> {
            primaryStage.close();
        });

        primaryStage.setScene(startScene);
        primaryStage.setTitle("Scarlet Tower");
        primaryStage.show();

    }

}
