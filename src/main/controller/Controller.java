package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import main.model.News_Feed_TechCrunch;
import main.view.FxmlLoader;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public VBox vBox;

    @FXML
    public BorderPane borderPane;

    @FXML
    public ScrollPane scrollPane;


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
            String url =news_feed_techCrunch.getUrlToImage(i);
            this.articleBoxController = new ArticleBoxController(title,authorName,date,content,url);
            this.vBox.getChildren().add(articleBoxController.init());
        }
        this.scrollPane.setContent(vBox);
        this.scrollPane.setFitToHeight(true);
        this.scrollPane.setFitToWidth(true);

    }


}