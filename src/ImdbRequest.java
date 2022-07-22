import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class ImdbRequest implements FilmeRequest {

    private static final String ENDPOINT = "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json";

    private final HttpClient httpClient;
    private JsonParser jsonParser;

    public ImdbRequest(HttpClient httpClient, JsonParser jsonParser) {
        this.httpClient = httpClient;
        this.jsonParser = jsonParser;
    }

    @Override
    public List<Map<String, String>> search() throws Exception {

        HttpRequest request = HttpRequest.newBuilder(URI.create(ENDPOINT))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

        String body = response.body();

        return this.jsonParser.parse(body);
    }
}
