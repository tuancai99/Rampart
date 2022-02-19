import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class PlayerConfig extends Application {

    /**
     *
     * @param theStage stage
     * @throws Exception handler
     */
    @Override
    public void start(Stage theStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane);

        theStage.setScene(scene);
        theStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
