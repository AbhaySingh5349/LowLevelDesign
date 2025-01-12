package Questions.KafkaQueue.service;

import Questions.KafkaQueue.enums.TopicName;
import Questions.KafkaQueue.model.Topic;
import Questions.KafkaQueue.repository.TopicRepository;

public class TopicService {
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic createTopic(TopicName topicName){
        Topic topic = new Topic(topicName);
        topicRepository.add(topic);
        return topic;
    }

    public Topic getTopic(TopicName topicName){
        return topicRepository.get(topicName);
    }
}
