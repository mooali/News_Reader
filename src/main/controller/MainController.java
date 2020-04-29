package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.model.Connection;
import main.model.News_Feed;
import main.model.News_Feed_Swiss;
import main.model.News_Feed_TechCrunch;
import main.view.ViewChanger;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public VBox vBox;

    @FXML
    public BorderPane borderPane;

    @FXML
    public ScrollPane scrollPane;

    @FXML
    Button mainMenuButton;


    @FXML Button swissButton;

    @FXML
    Button techChrunchButton;


    @FXML
    Button statisticButton;


    @FXML
    private ArticleBoxController articleBoxController;
    private Connection connection;



    News_Feed_TechCrunch news_feed_techCrunch = new News_Feed_TechCrunch();
    News_Feed_Swiss news_feed_swiss = new News_Feed_Swiss();

    String swissApiNews = "http://newsapi.org/v2/top-headlines?country=ch&apiKey=1c488ff068774a759c2b59ba4f93e146";
    String techChrunchApi ="http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=1c488ff068774a759c2b59ba4f93e146";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.mainMenuButton.setText(ViewChanger.getLanguage().getString("main.mainMenu"));
        this.swissButton.setText(ViewChanger.getLanguage().getString("main.swiss"));
        this.statisticButton.setText(ViewChanger.getLanguage().getString("main.statistic"));
        this.scrollPane.setContent(initTechCrunch());
    }






    public VBox initTechCrunch(){
        this.news_feed_swiss.reset();
        this.news_feed_techCrunch = new News_Feed_TechCrunch();
        for(int i = 0; i<news_feed_techCrunch.getArticleNumber();i++) {
            String title = news_feed_techCrunch.getTitle(i);
            String authorName = news_feed_techCrunch.getAuthor(i);
            String date = news_feed_techCrunch.getDate(i);
            String content = news_feed_techCrunch.getContent(i);
            String urlToImage =news_feed_techCrunch.getUrlToImage(i);
            String url = news_feed_techCrunch.getUrl(i);
            this.articleBoxController = new ArticleBoxController(title,authorName,date,content,urlToImage,url);
            this.vBox.getChildren().add(articleBoxController.gethBox());
        }
        return this.vBox;
    }


    public VBox initSwiss(){
        this.news_feed_techCrunch.reset();
        this.news_feed_swiss= new News_Feed_Swiss();
        for(int i = 0; i<news_feed_swiss.getArticleNumber();i++) {
            String title = news_feed_swiss.getTitle(i);
            String authorName = news_feed_swiss.getAuthor(i);
            String date = news_feed_swiss.getDate(i);
            String content = news_feed_swiss.getContent(i);
            String urlToImage =news_feed_swiss.getUrlToImage(i);
            String url = news_feed_swiss.getUrl(i);
            this.articleBoxController = new ArticleBoxController(title,authorName,date,content,urlToImage,url);
            this.vBox.getChildren().add(articleBoxController.gethBox());
        }
        return this.vBox;
    }



    @FXML
    public void showSwissNews() {
        this.vBox.getChildren().clear();
        this.scrollPane.setContent(initSwiss());
    }


    @FXML
    public void showTechChrunch(){
        this.vBox.getChildren().clear();
        this.scrollPane.setContent(initTechCrunch());
    }

    @FXML
    public void changeToMainMenu(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("main/resources/view/mainMenu.fxml"),MainMenuController.languageChanger.getBundle());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(parent, 1000, 750));
        window.show();
    }


}


