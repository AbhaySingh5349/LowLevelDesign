package Questions.KafkaQueue.strategy;

import Questions.KafkaQueue.dto.JsonNode;
import Questions.KafkaQueue.enums.MessageType;

public class JsonMessageContent implements IMessageContent{
    private final JsonNode jsonNode;

    public JsonMessageContent(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public JsonNode getJsonNode(){
        return jsonNode;
    }

    @Override
    public String toString() {
        return "JsonMessageContent{" +
                "jsonNode=" + jsonNode +
                '}';
    }

    @Override
    public boolean doesSupport(MessageType messageType) {
        return messageType.equals(MessageType.JSON);
    }
}
