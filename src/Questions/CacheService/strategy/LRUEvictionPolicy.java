package Questions.CacheService.strategy;

import Questions.CacheService.algorithms.DoublyLinkedList;
import Questions.CacheService.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K>{
    private final DoublyLinkedList<K> dll;
    private final Map<K, DoublyLinkedListNode<K>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {
        if(mapper.containsKey(key)){
            // get operation on key
            DoublyLinkedListNode<K> node = mapper.get(key);

            dll.detachNode(node);
            dll.addNodeAtStart(node);
        }else{
            // put operation on key
            DoublyLinkedListNode<K> node = dll.addElementAtStart(key);
            mapper.put(key, node);
        }
    }

    @Override
    public K evictKey() {
        DoublyLinkedListNode<K> lastNode = dll.getLastNode();
        if(lastNode.getKey() == null){
            return null;
        }

        dll.detachNode(lastNode);
        return lastNode.getKey();
    }

    @Override
    public List<K> getKeys() {
        return dll.getKeys();
    }
}
