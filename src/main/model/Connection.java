package main.model;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class Connection {

    private static HttpURLConnection connection;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static StringBuffer responseContent = new StringBuffer();
    BufferedReader reader;
    String line;

    public  StringBuffer getResponseContent() {
        return responseContent;
    }

    public Connection(){
    }

    public  void connect(String inputURL){
        try {
            URL url = new URL(inputURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            System.out.println(status); //200 means connection successful
            if(status > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine())!= null){
                    responseContent.append(line);
                }
                reader.close();
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), UTF8));
                while ((line = reader.readLine())!= null){
                    responseContent.append(line);
                }
                reader.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            connection.disconnect();
        }
    }


    public void disconnect(){
        connection.disconnect();
}

    public static String parse(String responseBody){
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONArray albums = jsonObject.getJSONArray("articles");
        System.out.print("ID "+"Title "+"UserID\n");
        for(int i= 0; i < albums.length(); i++){
            JSONObject album = albums.getJSONObject(i);
            String author = album.getString("author");
            String title = album.getString("title");
            System.out.println(author);
        }
        return null;
    }

}
