package Questions.CacheService.strategy;

import Questions.CacheService.exceptions.NotFoundException;
import Questions.CacheService.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{
    private final Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.storage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull()) throw new StorageFullException("Capacity Full.....");
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) throw new NotFoundException(key + "doesn't exist in cache.");
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) throw new NotFoundException(key + "doesn't exist in cache.");
        return storage.get(key);
    }

    @Override
    public Boolean isStorageFull() {
        return storage.size() == capacity;
    }
}
