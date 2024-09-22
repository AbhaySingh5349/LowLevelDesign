package Questions.CacheService.strategy;

import Questions.CacheService.exceptions.NotFoundException;
import Questions.CacheService.exceptions.StorageFullException;

public interface Storage<Key, Value> {
    void add(Key key, Value value) throws StorageFullException;
    void remove(Key key) throws NotFoundException;
    Value get(Key key) throws NotFoundException;
    Boolean isStorageFull();
}
