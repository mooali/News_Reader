package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.text.html.parser.ContentModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    Button showMain;


    @FXML
    Label copyRightLabel;


    @FXML
    public void changeToMain(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("main/view/main.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(parent, 1000, 750));
        window.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
