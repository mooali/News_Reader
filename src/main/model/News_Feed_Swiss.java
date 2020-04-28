package main.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class News_Feed_Swiss extends Connection implements News {

    private static StringBuffer responseContent = getResponseContent();
    private int articleNumber;

    @Override
    public int getArticleNumber() {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        this.articleNumber = jsonArray.length();
        return this.articleNumber;
    }

    @Override
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

    @Override
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

    @Override
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


    @Override
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

    @Override
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

    @Override
    public String getUrlToImage(int index) {
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
}
