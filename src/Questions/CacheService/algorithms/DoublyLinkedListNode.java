package Questions.CacheService.algorithms;

public class DoublyLinkedListNode<K> {
    K key;
    DoublyLinkedListNode<K> next;
    DoublyLinkedListNode<K> prev;

    public DoublyLinkedListNode(K key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }

    public K getKey() {
        return key;
    }
}
