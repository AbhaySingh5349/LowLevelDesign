package Questions.KafkaQueue.strategy;

import Questions.KafkaQueue.enums.MessageType;

public class PlainTextMessageContent implements IMessageContent{
    private final String text;

    public PlainTextMessageContent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "PlainTextMessageContent{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean doesSupport(MessageType messageType) {
        return messageType.equals(MessageType.PLAIN_TEXT);
    }
}
