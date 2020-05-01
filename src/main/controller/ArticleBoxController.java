package main.controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.view.ViewChanger;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class ArticleBoxController{

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
    String url;


    public ArticleBoxController(String titleStr, String authorNameStr, String dateStr, String contentStr, String urlToImagem, String url) {
        this.titleStr = titleStr;
        this.authorNameStr = authorNameStr;
        this.dateStr = dateStr;
        this.contentStr = contentStr;
        this.urlToImage = urlToImagem;
        this.url = url;
    }


    public HBox gethBox() {
        this.hBox = new HBox();
        this.hBox.setId("hBox");
        this.hBox.getStylesheets().add("main/resources/style.css");
        this.hBox.setMinHeight(325);
        this.authorName = new Label();
        this.date = new Label();
        this.title = new Label();
        this.title.setId("title");
        this.title.getStylesheets().add("main/resources/style.css");
        this.anchorPane = new AnchorPane();
        this.content = new Text();
        this.content.setId("content");
        this.imageView = new ImageView();
        this.readMore = new Button("Read More");
        this.readMore.setText(ViewChanger.getLanguage().getString("main.readMore"));
        this.readMore.setId("readMoreButton");
        this.title.setText(this.titleStr);
        this.authorName.setText(this.authorNameStr);
        this.content.setText(this.contentStr);
        this.date.setText(this.dateStr);
        this.imageView.setFitWidth(200);
        this.imageView.setFitHeight(200);
        this.imageView.isSmooth();
        this.imageView.setLayoutX(800);
        this.imageView.setLayoutY(75);
        this.content.setWrappingWidth(700);
        this.anchorPane.prefHeight(200);
        this.anchorPane.prefWidth(300);
        this.authorName.setLayoutX(40);
        this.authorName.setLayoutY(60);
        this.content.setLayoutX(40);
        this.content.setLayoutY(120);
        this.title.setLayoutX(40);
        this.title.setLayoutY(10);
        this.title.setWrapText(true);
        this.date.setLayoutX(130);
        this.date.setLayoutY(225);
        this.readMore.setLayoutX(35);
        this.readMore.setLayoutY(225);
        Image image = new Image(this.urlToImage);
        this.imageView.setImage(image);
        this.imageView.setStyle("-fx-padding: 6em");
        this.readMore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(url));
                }catch (IOException e){
                    e.printStackTrace();
                }catch (URISyntaxException e){
                    e.printStackTrace();
                }
            }
        });
        this.anchorPane.getChildren().addAll(this.title,this.authorName,this.date,this.content,this.imageView,this.readMore);
        this.hBox.getChildren().add(anchorPane);
        return this.hBox;
    }



}