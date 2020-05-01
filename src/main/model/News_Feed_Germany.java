package main.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class News_Feed_Germany extends Connection implements News  {

    int less1hour = 0;
    int between1and2hours = 0;
    int between2and3hours = 0;
    int less4hours = 0;

    String germanApi = "http://newsapi.org/v2/top-headlines?country=de&apiKey=1c488ff068774a759c2b59ba4f93e146";

    private static StringBuffer responseContent;
    private Connection connection = new Connection();
    public int articleNumber;

    public News_Feed_Germany(){
        this.connection.connect(germanApi);
        this.responseContent = connection.getResponseContent();

    }

    @Override
    public void connect(String inputURL) {
        super.connect(inputURL);
    }

    @Override
    public void disconnect(){
        super.disconnect();
    }


    public String getAuthor(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        try {
            String authorname = authorObj.getString("author");
            return authorname;
        }catch (JSONException e){
            return " ";
        }
    }


    public int getArticleNumber(){
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        this.articleNumber = jsonArray.length();
        return this.articleNumber;
    }

    public String getTitle(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        try {
            String title = authorObj.getString("title");
            return title;
        }catch (JSONException e){
            return " ";
        }
    }

    public String getDescription(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        try {
            String description = authorObj.getString("description");
            return description;
        }catch (JSONException e){
            return " ";
        }

    }

    public String getContent(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        try {
            String description = authorObj.getString("content");
            return description;
        }catch (JSONException e){
            return " ";
        }
    }

    public String getDate(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        try {
            String publishedAt = authorObj.getString("publishedAt");
            LocalDateTime datetime = LocalDateTime.parse(publishedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
            String dateTime = datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy' T'HH:MM"));
            return dateTime;
        }catch (JSONException e){
            return " ";
        }

    }


    public String getUrlToImage(int index){
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        try {
            String urlToImage = authorObj.getString("urlToImage");
            return urlToImage;
        }catch (JSONException e){
            return "main/resources/pics/noImage.png";
        }
    }
    @Override
    public String getUrl(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        try {
            String url = authorObj.getString("url");
            return url;
        }catch (JSONException e){
            return "http://404.com/";
        }
     }

    public void reset(){
        this.responseContent = responseContent.delete(0, responseContent.length());
        this.connection.disconnect();
    }

    public LocalDateTime getDateTime(int index){
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        String publishedAt = authorObj.getString("publishedAt");
        LocalDateTime datetime = LocalDateTime.parse(publishedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        return datetime;
    }

    @Override
    public void date(int index) {
        LocalDateTime articleTime = getDateTime(index);
        LocalDateTime before1hour = articleTime.minusHours(1);
        LocalDateTime dateTime2=LocalDateTime.now();
        if(articleTime.isAfter(dateTime2.minusHours(1))){
            this.less1hour++;
        }else if(articleTime.isAfter(dateTime2.minusHours(2)) && articleTime.isBefore(dateTime2.minusHours(1))) {
            between1and2hours++;
        }else if(articleTime.isAfter(dateTime2.minusHours(3)) && articleTime.isBefore(dateTime2.minusHours(2))){
            this.between2and3hours++;
        }
        else {
            this.less4hours++;
        }

    }

    public int getLess1hour() {
        return less1hour;
    }

    public int getBetween1and2hours() {
        return between1and2hours;
    }

    public int getBetween2and3hours() {
        return between2and3hours;
    }

    public int getLess4hours() {
        return less4hours;
    }
}
