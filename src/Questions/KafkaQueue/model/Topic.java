package Questions.KafkaQueue.model;

import Questions.KafkaQueue.enums.TopicName;
import Questions.KafkaQueue.strategy.IMessageContent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Topic {
    private final TopicName topicName;
    private final Set<String> producerList;
    private final Set<String> consumerList;
    private final List<IMessageContent> messages;
    private final Map<String, Integer> consumerMessageOffset;

    public Topic(TopicName topicName) {
        this.topicName = topicName;
        this.producerList = new HashSet<>();
        this.consumerList = new HashSet<>();
        this.messages = new ArrayList<>();
        this.consumerMessageOffset = new ConcurrentHashMap<>();
    }

    public TopicName getTopicName() {
        return topicName;
    }

    public Set<String> getProducerList() {
        return producerList;
    }

    public Set<String> getConsumerList() {
        return consumerList;
    }

    public List<IMessageContent> getMessages() {
        return messages;
    }

    public Integer getConsumerMessageOffset(String consumerId) {
        return consumerMessageOffset.get(consumerId);
    }

    public void addProducer(String producerId){
        producerList.add(producerId);
    }

    public void addConsumer(String consumerId){
        consumerList.add(consumerId);
    }

    public void addMessage(IMessageContent message){
        messages.add(message);
    }

    public void updateConsumerOffset(String consumerId, Integer lastProcessedMsgIdx){
        consumerMessageOffset.put(consumerId, lastProcessedMsgIdx);
    }
}
