package Questions.KafkaQueue.strategy;

import Questions.KafkaQueue.enums.MessageType;

public interface IMessageContent {
    boolean doesSupport(MessageType messageType);
}
