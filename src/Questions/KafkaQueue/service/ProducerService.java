package Questions.KafkaQueue.service;

import Questions.KafkaQueue.enums.TopicName;
import Questions.KafkaQueue.model.Producer;
import Questions.KafkaQueue.model.Topic;
import Questions.KafkaQueue.repository.ProducerRepository;
import Questions.KafkaQueue.strategy.IMessageContent;

public class ProducerService {
    private final ProducerRepository producerRepository;
    private final TopicService topicService;

    public ProducerService(ProducerRepository producerRepository, TopicService topicService) {
        this.producerRepository = producerRepository;
        this.topicService = topicService;
    }

    public Producer createProducer(String id){
        Producer producer = new Producer(id);
        producerRepository.add(producer);
        return producer;
    }

    public boolean publish(String producerId, IMessageContent message, TopicName topicName){
        Producer producer = producerRepository.getProducerById(producerId);
        producer.addTopic(topicName);

        Topic topic = topicService.getTopic(topicName);
        topic.addMessage(message);
        topic.addProducer(producerId);

        return true;
    }
}
