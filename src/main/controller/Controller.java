package main.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
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
    ArticleBoxController articleBoxController;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        News_Feed_TechCrunch news_feed_techCrunch = new News_Feed_TechCrunch();
        news_feed_techCrunch.connect("http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=1c488ff068774a759c2b59ba4f93e146");
        for(int i = 0; i<news_feed_techCrunch.getArticleNumber();i++) {
            Label title = new Label();
            Label authorName = new Label();
            Label date = new Label();
            Text content = new Text();
            ImageView imageView = new ImageView();
            Button readMore = new Button();
            ImageView imageView1 = new ImageView();
            this.articleBoxController = new ArticleBoxController();
            this.articleBoxController.passInfo(title, authorName, date, content, imageView1, readMore);
            articleBoxController.init(i);
            this.vBox.getChildren().add(articleBoxController.getHbox());
        }
        this.scrollPane.setContent(vBox);
        this.scrollPane.setFitToHeight(true);
        this.scrollPane.setFitToWidth(true);

    }


}