package main.model;

public interface News {

    public int getArticleNumber();
    public String getAuthor(int index);
    public String getTitle(int index);
    public String getDescription(int index);
    public String getContent(int index);
    public String getDate(int index);
    public String getUrlToImage(int index);
    public String getUrl(int index);
}
