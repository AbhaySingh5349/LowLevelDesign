package Questions.KafkaQueue.service;

import Questions.KafkaQueue.enums.TopicName;
import Questions.KafkaQueue.model.Consumer;
import Questions.KafkaQueue.model.Topic;
import Questions.KafkaQueue.repository.ConsumerRepository;
import Questions.KafkaQueue.strategy.IMessageContent;

import java.util.List;
import java.util.Set;

public class ConsumerService {
    private final ConsumerRepository consumerRepository;
    private final TopicService topicService;

    public ConsumerService(ConsumerRepository consumerRepository, TopicService topicService) {
        this.consumerRepository = consumerRepository;
        this.topicService = topicService;
    }

    public Consumer createConsumer(String id){
        Consumer consumer = new Consumer(id);
        consumerRepository.add(consumer);
        return consumer;
    }

    public void subscribeToTopic(String consumerId, TopicName topicName){
        Consumer consumer = consumerRepository.getConsumerById(consumerId);
        consumer.addTopic(topicName);

        Topic topic = topicService.getTopic(topicName);
        topic.addConsumer(consumerId);
        topic.updateConsumerOffset(consumerId, -1);
    }

    public void consumeMessage(String consumerId){
        Consumer consumer = consumerRepository.getConsumerById(consumerId);

        System.out.println("##############################################");

        System.out.println("Checking messages for consumer: " + consumerId);

        Set<TopicName> topicNames = consumer.getTopics();
        for(TopicName topicName : topicNames){
            Topic topic = topicService.getTopic(topicName);

            List<IMessageContent> messages = topic.getMessages();
            int latestMsgIdx = messages.size() - 1;

            Integer lastProcessedMsgIdx = topic.getConsumerMessageOffset(consumerId);

            if(lastProcessedMsgIdx == latestMsgIdx){
                continue;
            }

            System.out.println("**********************************************");
            System.out.println("consuming from topic: " + topicName);

            while (lastProcessedMsgIdx < latestMsgIdx){
                IMessageContent messageContent = messages.get(lastProcessedMsgIdx+1);
                System.out.println(messageContent);
                lastProcessedMsgIdx++;
            }

            topic.updateConsumerOffset(consumerId, lastProcessedMsgIdx);
        }
    }

    public void pullMessages(){
        List<Consumer> consumers = consumerRepository.getAllConsumers();
        consumers.forEach(consumer -> consumeMessage(consumer.getId()));
    }
}
