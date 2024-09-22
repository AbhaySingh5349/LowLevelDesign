package Questions.CacheService;

import Questions.CacheService.exceptions.NotFoundException;
import Questions.CacheService.exceptions.StorageFullException;
import Questions.CacheService.strategy.EvictionPolicy;
import Questions.CacheService.strategy.Storage;

public class Cache<K, V> {
    private final EvictionPolicy<K> evictionPolicy;
    private final Storage<K, V> storage;

    public Cache(EvictionPolicy<K> evictionPolicy, Storage<K, V> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(K key, V value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            System.out.println("Got storage full. Will try to evict.");
            K keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            this.storage.remove(keyToRemove);
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(key, value);
        }
    }

    public V get(K key) {
        try {
            V value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException notFoundException) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}
