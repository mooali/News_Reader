package main.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import main.Main;

import java.net.URL;

public class FxmlLoader  {



    private HBox hBox;


    public HBox getHbox(String fileName){
        try {
            URL url = Main.class.getResource("/main/view/"+fileName+".fxml");
            if(url == null){
                System.out.println("ERROR! FXML File not found!");
            }
            hBox = new FXMLLoader().load(url);
        }
        catch (Exception e){
            System.out.println("No page "+fileName+" ! please check FxmlLoader!");
        }
        return hBox;
    }

}