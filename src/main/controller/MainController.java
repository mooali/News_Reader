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
import main.model.*;
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
    Button germanButton;


    @FXML
    private ArticleBoxController articleBoxController;



    private News_Feed_TechCrunch news_feed_techCrunch = new News_Feed_TechCrunch();
    private News_Feed_Switzerland news_feed_switzerland = new News_Feed_Switzerland();
    private News_Feed_Germany news_feed_germany = new News_Feed_Germany();

    private String swissApiNews = "http://newsapi.org/v2/top-headlines?country=ch&apiKey=1c488ff068774a759c2b59ba4f93e146";
    private String techChrunchApi ="http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=1c488ff068774a759c2b59ba4f93e146";
    private String germanApi = "http://newsapi.org/v2/top-headlines?country=de&apiKey=1c488ff068774a759c2b59ba4f93e146";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.mainMenuButton.setText(ViewChanger.getLanguage().getString("main.mainMenu"));
        this.swissButton.setText(ViewChanger.getLanguage().getString("main.swiss"));
        this.germanButton.setText(ViewChanger.getLanguage().getString("main.german"));
        this.statisticButton.setText(ViewChanger.getLanguage().getString("main.statistic"));
        this.scrollPane.setContent(initTechCrunch());
    }






    public VBox initTechCrunch(){
        this.news_feed_switzerland.reset();
        this.news_feed_germany.reset();
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
        this.news_feed_germany.reset();
        this.news_feed_switzerland = new News_Feed_Switzerland();
        for(int i = 0; i< news_feed_switzerland.getArticleNumber(); i++) {
            String title = news_feed_switzerland.getTitle(i);
            String authorName = news_feed_switzerland.getAuthor(i);
            String date = news_feed_switzerland.getDate(i);
            String content = news_feed_switzerland.getContent(i);
            String urlToImage = news_feed_switzerland.getUrlToImage(i);
            String url = news_feed_switzerland.getUrl(i);
            this.articleBoxController = new ArticleBoxController(title,authorName,date,content,urlToImage,url);
            this.vBox.getChildren().add(articleBoxController.gethBox());
        }
        return this.vBox;
    }


    public VBox initGermany(){
        this.news_feed_switzerland.reset();
        this.news_feed_techCrunch.reset();
        this.news_feed_germany = new News_Feed_Germany();
        for(int i = 0; i< news_feed_germany.getArticleNumber(); i++) {
            String title = news_feed_germany.getTitle(i);
            String authorName = news_feed_germany.getAuthor(i);
            String date = news_feed_germany.getDate(i);
            String content = news_feed_germany.getContent(i);
            String urlToImage = news_feed_germany.getUrlToImage(i);
            String url = news_feed_germany.getUrl(i);
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
    public void showGermanNews() {
        this.vBox.getChildren().clear();
        this.scrollPane.setContent(initGermany());
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
        window.setScene(new Scene(parent, 1200, 750));
        window.show();
    }

    @FXML
    public void showStatstics(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("main/resources/view/statsticGUI.fxml"),MainMenuController.languageChanger.getBundle());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(parent, 1200, 750));
        window.show();
    }







}


