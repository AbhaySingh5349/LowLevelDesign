package Questions.KafkaQueue.repository;

import Questions.KafkaQueue.model.Producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProducerRepository {
    private final Map<String, Producer> producerMap;

    public ProducerRepository() {
        this.producerMap = new HashMap<>();
    }

    public void add(Producer producer){
        this.producerMap.put(producer.getId(), producer);
    }

    public Producer getProducerById(String id){
        return producerMap.get(id);
    }

    public List<Producer> getAllProducers(){
        return new ArrayList<>(producerMap.values());
    }
}
