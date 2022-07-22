import java.net.http.HttpClient;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();

        FilmeRequest request = new ImdbRequest(httpClient, new JsonParser());

        try {
            List<Map<String, String>> list = request.search();

            list.forEach(item -> System.out.println(item.get("title") + " -> " + item.get("year")));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
