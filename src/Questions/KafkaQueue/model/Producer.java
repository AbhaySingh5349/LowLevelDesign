package Questions.KafkaQueue.model;

import Questions.KafkaQueue.enums.TopicName;

import java.util.HashSet;
import java.util.Set;

public class Producer {
    private final String id;
    private final Set<TopicName> topics; // topics which producer publishes to

    public Producer(String id) {
        this.id = id;
        this.topics = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public Set<TopicName> getTopics() {
        return topics;
    }

    public void addTopic(TopicName topic){
        topics.add(topic);
    }
}
