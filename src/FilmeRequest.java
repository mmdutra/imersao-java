import java.util.List;
import java.util.Map;

public interface FilmeRequest {
    List<Map<String, String>> search() throws Exception;
}
