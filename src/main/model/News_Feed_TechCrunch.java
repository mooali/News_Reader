package main.model;

import org.json.JSONArray;
import org.json.JSONObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class News_Feed_TechCrunch extends Connection implements News  {
    private static StringBuffer responseContent = getResponseContent();



    public int articleNumber;
    public String author;
    public String title;

    @Override
    public void connect(String inputURL) {
        super.connect(inputURL);
    }



    public String getAuthor(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        String authorname = authorObj.getString("author");
        return authorname;
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
        String title = authorObj.getString("title");
        return title;
    }

    public String getDescription(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        String description = authorObj.getString("description");
        return description;
    }

    public String getContent(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        String description = authorObj.getString("content");
        return description;
    }

    public String getDate(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        String publishedAt = authorObj.getString("publishedAt");
        LocalDateTime datetime = LocalDateTime.parse(publishedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        String dateTime = datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy' T'HH:MM"));
        return dateTime;
    }


    public String getUrlToImage(int index){
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        String urlToImage = authorObj.getString("urlToImage");
        return urlToImage;
    }

    @Override
    public String getUrl(int index) {
        JSONObject jsonObject = new JSONObject(responseContent.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        JSONObject authorObj =jsonArray.getJSONObject(index);
        String url = authorObj.getString("url");
        return url;    }


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
