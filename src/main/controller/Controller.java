package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import main.model.News_Feed_TechCrunch;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public VBox vBox;

    @FXML
    public BorderPane borderPane;

    @FXML
    public ScrollPane scrollPane;







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
            ArticleBoxController articleBoxController = new ArticleBoxController(title,authorName,date,content,url);
            articleBoxController.init();
            this.vBox.getChildren().add(articleBoxController.title);
        }
        this.scrollPane.setContent(vBox);
        this.scrollPane.setFitToHeight(true);
        this.scrollPane.setFitToWidth(true);

    }


}