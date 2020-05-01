package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.view.LanguageChanger;

import java.util.ArrayList;

public class Main extends Application {

    LanguageChanger languageChanger = new LanguageChanger();



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/view/mainMenu.fxml"),languageChanger.getBundle());
        primaryStage.setTitle("News Reeader");
        primaryStage.setScene(new Scene(root, 1000, 750));
        primaryStage.setResizable(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
