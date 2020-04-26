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
import main.model.News_Feed_TechCrunch;


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
    private Button mainMenuButton;


    @FXML
    private ArticleBoxController articleBoxController;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        News_Feed_TechCrunch news_feed_techCrunch = new News_Feed_TechCrunch();
        news_feed_techCrunch.connect("http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=1c488ff068774a759c2b59ba4f93e146");
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
        this.scrollPane.setContent(vBox);
        this.scrollPane.setFitToHeight(true);
        this.scrollPane.setFitToWidth(true);
    }


    @FXML
    public void changeToMainMenu(ActionEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("main/view/mainMenu.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(parent, 1000, 750));
        window.show();





    }


}