package main.model;

public class News_Feed_WallStreet extends News_Feed_TechCrunch {

    @Override
    public void connect(String inputURL) {
        super.connect(inputURL);
    }

    @Override
    public String getAuthor(int index) {
        return super.getAuthor(index);
    }

    @Override
    public String getTitle(int index) {
        return super.getTitle(index);
    }

    @Override
    public String getContent(int index) {
        return super.getContent(index);
    }

    @Override
    public String getDescription(int index) {
        return super.getDescription(index);
    }

    public static void main(String[] args) {
        News_Feed_WallStreet news = new News_Feed_WallStreet();
        news.connect("http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=1c488ff068774a759c2b59ba4f93e146");
        System.out.println(news.getAuthor(1));
        System.out.println(news.getTitle(1));
    }
}
