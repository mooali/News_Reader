package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import javafx.scene.text.Text;
import main.model.News_Feed_TechCrunch;

import java.net.URL;
import java.util.ResourceBundle;


public class ArticleBoxController {

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


    String titleStr;
    String authorNameStr;
    String dateStr;
    String contentStr;
    String urlToImage;


    public ArticleBoxController(String titleStr, String authorNamestr, String dateStr, String contentStr, String urlToImage) {
        this.titleStr = titleStr;
        this.authorNameStr = authorNamestr;
        this.dateStr = dateStr;
        this.contentStr = contentStr;
        this.urlToImage = urlToImage;
    }


    public void init() {
        this.title.setText(this.titleStr);
          this.authorName.setText(this.authorNameStr);
        this.content.setText(this.contentStr);
        this.date.setText(this.dateStr);
        Image image = new Image(this.urlToImage);
        this.imageView.setImage(image);
    }



    /*

    public void passInfo(Label title, Label authorName, Label date, Text content, ImageView imageView, Button readMore){
        this.title = title;
        this.authorName = authorName;
        this.date = date;
        this.content = content;
        this.imageView = imageView;
        this.readMore = readMore;
    }

     */

    public HBox getHbox(){
        return this.hBox;
    }

}