package Questions.CacheService.algorithms;

import Questions.CacheService.algorithms.exceptions.InvalidElementException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoublyLinkedList<K> {
    DoublyLinkedListNode<K> dummyHead;
    DoublyLinkedListNode<K> dummyTail;

    public DoublyLinkedList() {
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);

        // Initially there are no items
        // so just join dummyHead and Tail, we can add items in between them easily.
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public Boolean isItemPresent() {
        return dummyHead.next != dummyTail;
    }

    public DoublyLinkedListNode<K> getFirstNode() throws NoSuchElementException {
        if (!isItemPresent()) {
            return dummyTail;
        }
        return dummyHead.next;
    }

    public DoublyLinkedListNode<K> getLastNode() throws NoSuchElementException {
        if (!isItemPresent()) {
            return dummyTail;
        }
        return dummyTail.prev;
    }

    public void detachNode(DoublyLinkedListNode<K> node) {
        // modifying the pointers.
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtStart(DoublyLinkedListNode<K> node){
        DoublyLinkedListNode<K> curHeadNext = getFirstNode();

        dummyHead.next = node;
        node.prev = dummyHead;

        node.next = curHeadNext;
        curHeadNext.prev = node;
    }

    public DoublyLinkedListNode<K> addElementAtStart(K key) {
        if (key == null) {
            throw new InvalidElementException("element is not valid");
        }

        DoublyLinkedListNode<K> newNode = new DoublyLinkedListNode<>(key);
        addNodeAtStart(newNode);
        return newNode;
    }

    public List<K> getKeys() {
        if(!isItemPresent()){
            System.out.println("No keys in cache");
            return new ArrayList<>();
        }

        DoublyLinkedListNode<K> node = getFirstNode();

        List<K> keys = new ArrayList<>();
        while (node.getKey() != null){
            keys.add(node.getKey());
            node = node.next;
        }

        return keys;
    }
}
