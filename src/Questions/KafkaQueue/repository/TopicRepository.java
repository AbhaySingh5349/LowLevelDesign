package Questions.KafkaQueue.repository;

import Questions.KafkaQueue.enums.TopicName;
import Questions.KafkaQueue.model.Topic;

import java.util.HashMap;
import java.util.Map;

public class TopicRepository {
    private final Map<TopicName, Topic> topicMap;

    public TopicRepository() {
        this.topicMap = new HashMap<>();
    }

    public void add(Topic topic){
        topicMap.put(topic.getTopicName(), topic);
    }

    public Topic get(TopicName topicName){
        return topicMap.get(topicName);
    }
}
