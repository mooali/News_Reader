package main.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import javafx.scene.text.Text;
import main.model.News_Feed_TechCrunch;


public class ArticleBoxController  {

    @FXML
    public HBox hBox;

    @FXML
    public AnchorPane anchorPane;

    @FXML
    public Label title;

    @FXML
    public Label authorName;

    @FXML
    public Label date;

    @FXML
    public Text content;

    @FXML
    public ImageView imageView;

    @FXML
    public Button readMore;




    public void passInfo(Label title, Label authorName, Label date, Text content, ImageView imageView, Button readMore){
        this.title = title;
        this.authorName = authorName;
        this.date = date;
        this.content = content;
        this.imageView = imageView;
        this.readMore = readMore;
    }


    public void init(int i) {
        News_Feed_TechCrunch news_feed_techCrunch = new News_Feed_TechCrunch();
        this.title.setText(news_feed_techCrunch.getTitle(i));
        this.authorName.setText(news_feed_techCrunch.getAuthor(i));
        this.date.setText(news_feed_techCrunch.getDate(i));
        this.content.setText(news_feed_techCrunch.getContent(i));
        Image image = new Image(news_feed_techCrunch.getUrlToImage(i));
        this.imageView.setImage(image);
        this.readMore = new Button("read Me");
        anchorPane.getChildren().addAll(this.title, this.authorName, this.date, this.content, this.imageView, this.readMore);
        this.hBox.getChildren().add(anchorPane);

    }

    public HBox getHbox(){
        return this.hBox;
    }



}