package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.model.News_Feed;
import main.model.News_Feed_Germany;
import main.model.News_Feed_Switzerland;
import main.model.News_Feed_TechCrunch;
import main.view.LanguageChanger;
import main.view.ViewChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StatsticController implements Initializable {

    @FXML
    private BarChart<?, ?> barChartTech;

    @FXML
    private Button returnButton;


    LanguageChanger languageChanger;


    @FXML
    private PieChart pieChart;


    News_Feed_Switzerland news_feed_switzerland = new News_Feed_Switzerland();
    News_Feed_TechCrunch news_feed_techCrunch = new News_Feed_TechCrunch();
    News_Feed_Germany news_feed_germany = new News_Feed_Germany();




    @FXML
    public void checkTiemsSwiss(){
        this.news_feed_switzerland = new News_Feed_Switzerland();
        for(int i = 0; i< news_feed_switzerland.getArticleNumber(); i++){
            news_feed_switzerland.date(i);
        }
        this.news_feed_switzerland.reset();
    }

    public void checkTiemsTech(){
        this.news_feed_techCrunch = new News_Feed_TechCrunch();
        for(int i=0; i<news_feed_techCrunch.getArticleNumber();i++){
            news_feed_techCrunch.date(i);
        }
        news_feed_techCrunch.reset();
    }

    public void checkTiemsGermany(){
        this.news_feed_germany = new News_Feed_Germany();
        for(int i=0; i<news_feed_germany.getArticleNumber();i++){
            news_feed_germany.date(i);
        }
        System.out.println(this.news_feed_germany.getArticleNumber());
        news_feed_germany.reset();
    }


    public int numArticleTech(){
        this.news_feed_germany.reset();
        this.news_feed_switzerland.reset();
        this.news_feed_techCrunch = new News_Feed_TechCrunch();
        return this.news_feed_techCrunch.getArticleNumber();
    }

    public int numArticleSwiss(){
        this.news_feed_techCrunch.reset();
        this.news_feed_germany.reset();
        this.news_feed_switzerland = new News_Feed_Switzerland();
        return this.news_feed_switzerland.getArticleNumber();
    }

    public int numArticleGerman(){
        this.news_feed_switzerland.reset();
        this.news_feed_techCrunch.reset();
        this.news_feed_germany = new News_Feed_Germany();
        return this.news_feed_germany.getArticleNumber();
    }


    @FXML
    public void changeToMain(ActionEvent event) throws IOException {
        languageChanger = new LanguageChanger();
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("main/resources/view/main.fxml"),languageChanger.getBundle());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(parent, 1100, 750));
        window.show();    }




    public void setStatstic(){
        XYChart.Series swissSet = new XYChart.Series<>();
        XYChart.Series techSet = new XYChart.Series<>();
        XYChart.Series germanSet = new XYChart.Series<>();

        String dataNameGerman = ViewChanger.getLanguage().getString("main.german");
        String dataNameSwiss = ViewChanger.getLanguage().getString("main.swiss");
        String dataNameTech = "TechChrunch";
        int dataGerman = numArticleGerman();
        int dataSwiss = numArticleSwiss();
        int dataTech = numArticleTech();
        swissSet.setName(dataNameSwiss);
        germanSet.setName(dataNameGerman);
        techSet.setName("TechChrunch");


        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data(dataNameSwiss,dataSwiss),
                new PieChart.Data(dataNameTech,dataTech),
                new PieChart.Data(dataNameGerman,dataGerman ));
        checkTiemsSwiss();
        swissSet.getData().add(new XYChart.Data(">1", news_feed_switzerland.getLess1hour()));
        swissSet.getData().add(new XYChart.Data("1-2", news_feed_switzerland.getBetween1and2hours()));
        swissSet.getData().add(new XYChart.Data("2-3", news_feed_switzerland.getBetween2and3hours()));
        swissSet.getData().add(new XYChart.Data(">4", news_feed_switzerland.getLess4hours()));

        checkTiemsTech();
        techSet.getData().add(new XYChart.Data(">1",news_feed_techCrunch.getLess1hour()));
        techSet.getData().add(new XYChart.Data("1-2",news_feed_techCrunch.getBetween1and2hours()));
        techSet.getData().add(new XYChart.Data("2-3",news_feed_techCrunch.getBetween2and3hours()));
        techSet.getData().add(new XYChart.Data(">4",news_feed_techCrunch.getLess4hours()));

        checkTiemsGermany();
        germanSet.getData().add(new XYChart.Data(">1", news_feed_germany.getLess1hour()));
        germanSet.getData().add(new XYChart.Data("1-2", news_feed_germany.getBetween1and2hours()));
        germanSet.getData().add(new XYChart.Data("2-3", news_feed_germany.getBetween2and3hours()));
        germanSet.getData().add(new XYChart.Data(">4", news_feed_germany.getLess4hours()));
        barChartTech.getData().addAll(swissSet,techSet,germanSet);

        pieChart.setData(pieChartData);

    }

    public void setLabelLanguages(){
        barChartTech.getYAxis().setLabel(ViewChanger.getLanguage().getString("statstic.article"));
        barChartTech.getXAxis().setLabel(ViewChanger.getLanguage().getString("statstic.hours"));
        barChartTech.setTitle(ViewChanger.getLanguage().getString("statstic.timeFrame"));
        pieChart.setTitle(ViewChanger.getLanguage().getString("statstic.numberOfArticle"));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLabelLanguages();
        setStatstic();

    }
}
