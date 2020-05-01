package main.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.view.LanguageChanger;
import main.view.ViewChanger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    Button showMain;

    @FXML
    Button languageButton;

    @FXML
    Button aboutButton;


    public static LanguageChanger languageChanger;






    @FXML
    public void changeToMain(ActionEvent event) throws IOException{
        languageChanger = new LanguageChanger();
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("main/resources/view/main.fxml"),languageChanger.getBundle());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(parent, 1150, 750));
        window.show();    }


    @FXML
    public void changeLanguage(){
        ViewChanger.changeLanguage();
        this.updateLanguageOnButtons();
    }


    private void updateLanguageOnButtons() {
        this.showMain.setText(ViewChanger.getLanguage().getString("mainMenu.start"));
        this.languageButton.setText(ViewChanger.getLanguage().getString("mainMenu.language"));
        this.aboutButton.setText(ViewChanger.getLanguage().getString("mainMenu.about"));

    }

    @FXML
    public void showAbout(){

    }



    public void setButtons(){
        this.languageButton.setOnAction(e -> changeLanguage());
        this.updateLanguageOnButtons();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    System.out.println("hello");
    updateLanguageOnButtons();
    }
}
