package main.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class News_Feed extends Connection implements News  {
    private static StringBuffer responseContent = getResponseContent();



    public int articleNumber;

    @Override
    public void connect(String inputURL) {
        super.connect(inputURL);
    }

    @Override
    public void disconnect(String inputURL) {
        super.disconnect(inputURL);
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


    public static void main(String[] args) {
        News_Feed_TechCrunch news_feedTechCrunch = new News_Feed_TechCrunch();
        news_feedTechCrunch.connect("http://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=1c488ff068774a759c2b59ba4f93e146");
        System.out.println(news_feedTechCrunch.getAuthor(0));
        System.out.println(news_feedTechCrunch.getTitle(0));
        System.out.println(news_feedTechCrunch.getDescription(0));
        System.out.println(news_feedTechCrunch.getContent(0));
        System.out.println(news_feedTechCrunch.getDate(0));
        System.out.println(news_feedTechCrunch.getUrlToImage(0));

        System.out.println(responseContent.toString());


    }
}
