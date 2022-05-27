import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class EjemploParse {
    static String json = "{\n" +
            "    \"pageInfo\": {\n" +
            "            \"pageName\": \"Homepage\",\n" +
            "            \"logo\": \"https://www.example.com/logo.jpg\"\n" +
            "    },\n" +
            "    \"posts\": [\n" +
            "            {\n" +
            "                \"post_id\": \"345678932\",\n" +
            "                \"actor_id\": \"101\",\n" +
            "                \"author_name\": \"DAMIAN\",\n" +
            "                \"post_title\": \"How to parse JSON in Java\",\n" +
            "                \"comments\": [{\"comment\": \"VA BIEN EL JSON\"}],\n" +
            "                \"time_of_post\": \"1234567890\"\n" +
            "            },\n" +
            "           {\n" +
            "                \"post_id\": \"034567\",\n" +
            "                \"actor_id\": \"100\",\n" +
            "                \"author_name\": \"ROI MARTINEZ\",\n" +
            "                \"post_title\": \"How to parse JSON in Java\",\n" +
            "                \"comments\": [{\"comment\": \"ESTA PERIQUITO\"}],\n" +
            "                \"time_of_post\": \"1234567890\"\n" +
            "            },\n" +
            "{\n" +
            "                \"post_id\": \"57456\",\n" +
            "                \"actor_id\": \"200\",\n" +
            "                \"author_name\": \"Yago Simoes Fernández\",\n" +
            "                \"post_title\": \"How to parse JSON in Java\",\n" +
            "                \"comments\": [{\"comment\": \"Anda joya\"}],\n" +
            "                \"time_of_post\": \"023456670\"\n" +
            "            },\n" +
            "    ]\n" +

            "}";
    public static void main(String[] args) {
        JSONObject obj = new JSONObject(json);
        String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        System.out.println(pageName);

        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
            JSONArray arr2 = arr.getJSONObject(i).getJSONArray("comments");
            for (int j = 0; j < arr2.length(); j++) {
                String comments= arr2.getJSONObject(j).getString("comment");
                System.out.println(comments);
            }
        }
    }
}


