import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import java.util.ArrayList;


public class Shop extends Application {
    private ArrayList<Tower> towerForSale;
    private int select = -1;

    @FXML
    private CheckBox tower1Check;
    @FXML
    private CheckBox tower2Check;
    @FXML
    private CheckBox tower3Check;
    @FXML
    private Button purchaseBtn;
    @FXML
    private Button leaveBtn;

    public void start(Stage stage) throws Exception {
        storeInitialize();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Shop.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Shop");
        stage.setScene(scene);
        stage.show();
    }
    public void storeInitialize(){
        towerForSale = new ArrayList<Tower>();
        towerForSale.add(new Tower1());
        towerForSale.add(new Tower2());
        towerForSale.add(new Tower3());
        select = -1;
    }
    @FXML
    private void pressPurchaseButton(ActionEvent event) throws Exception {
        if (select == -1) {
            Alert myAlert = new Alert(Alert.AlertType.INFORMATION);
            myAlert.setHeaderText("Invalid Tower");
            myAlert.setContentText("Please select tower you want to purchase!");
            myAlert.showAndWait();
        } else {
            // purchase successfully
            if (towerForSale.get(select).getPrice() < Player.getMoney()) {
                Player.setMoney(Player.getMoney() - towerForSale.get(select).getPrice());
//                Player.setTowersOwned(towerForSale.get(select));
            } else {
                Alert myAlert = new Alert(Alert.AlertType.INFORMATION);
                myAlert.setHeaderText("Not enough money");
                myAlert.setContentText("Please select a tower that you can afford!");
                myAlert.showAndWait();
            }
        }
    }

    @FXML
    private void pressLeaveButton(ActionEvent event) throws Exception {
        Stage goBack;
        goBack = (Stage) leaveBtn.getScene().getWindow();
        GameConfig gameScreen = new GameConfig();
        gameScreen.start(goBack);
    }
    @FXML
    private void pressCheckBox1(ActionEvent event) throws Exception {
        tower1Check.setSelected(true);
        tower2Check.setSelected(false);
        tower3Check.setSelected(false);
        select = 0;
    }
    @FXML
    private void pressCheckBox2(ActionEvent event) throws Exception {
        tower1Check.setSelected(false);
        tower2Check.setSelected(true);
        tower3Check.setSelected(false);
        select = 1;
    }
    @FXML
    private void pressCheckBox3(ActionEvent event) throws Exception {
        tower1Check.setSelected(false);
        tower2Check.setSelected(false);
        tower3Check.setSelected(true);
        select = 2;
    }
    public static void main(String[] args) {
        launch(args);
    }
}