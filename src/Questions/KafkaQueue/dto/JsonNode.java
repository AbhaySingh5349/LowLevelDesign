package Questions.KafkaQueue.dto;

import java.util.HashMap;
import java.util.Map;

public class JsonNode {
    private final Map<String, Object> jsonData;

    public JsonNode() {
        this.jsonData = new HashMap<>();
    }

    public void add(String key, Object value) {
        jsonData.put(key, value);
    }

    public Object get(String key) {
        return jsonData.get(key);
    }
}
