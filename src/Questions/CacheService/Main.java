package Questions.CacheService;

import Questions.CacheService.strategy.EvictionPolicy;
import Questions.CacheService.strategy.HashMapBasedStorage;
import Questions.CacheService.strategy.LRUEvictionPolicy;
import Questions.CacheService.strategy.Storage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EvictionPolicy<String> evictionPolicy = new LRUEvictionPolicy<>();
        Storage<String, Integer> storage = new HashMapBasedStorage<>(4);

        Cache<String, Integer> cache = new Cache<>(evictionPolicy, storage);
        cache.put("a", 1);
        cache.put("b", 2);
        cache.put("c", 3);
        cache.put("d", 4);
        cache.put("e", 5);
        cache.put("f", 6);

        List<String> keys = evictionPolicy.getKeys();
        for(String key : keys){
            System.out.println("key: " + key + " -> " + storage.get(key));
        }
    }
}
