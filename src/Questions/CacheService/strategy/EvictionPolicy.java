package Questions.CacheService.strategy;

import java.util.List;

public interface EvictionPolicy<K> {
    void keyAccessed(K key);
    K evictKey(); // Evict key from eviction policy and return it
    List<K> getKeys();
}
