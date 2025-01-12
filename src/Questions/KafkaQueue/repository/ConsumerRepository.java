package Questions.KafkaQueue.repository;

import Questions.KafkaQueue.model.Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumerRepository {
    private final Map<String, Consumer> consumerMap;

    public ConsumerRepository() {
        this.consumerMap = new HashMap<>();
    }

    public void add(Consumer consumer){
        this.consumerMap.put(consumer.getId(), consumer);
    }

    public Consumer getConsumerById(String id){
        return consumerMap.get(id);
    }

    public List<Consumer> getAllConsumers(){
        return new ArrayList<>(consumerMap.values());
    }
}
