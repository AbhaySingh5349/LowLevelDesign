package Questions.KafkaQueue.model;

import Questions.KafkaQueue.enums.TopicName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Consumer {
    private final String id;
    private final Set<TopicName> topics; // topics which consumer listens to

    public Consumer(String id) {
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
