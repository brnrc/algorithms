package algorithms.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Bruno Cardoso on 03/09/2014.
 */
public class SeparateChainingLinkedHashMap<K, V> implements IMap<K, V>, Iterable{

    private int N;
    private Node<K, V> first;
    private Node<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public SeparateChainingLinkedHashMap(int capacity) {
        N = capacity;
        this.buckets = new Node[N];
    }

    @Override
    public V get(K key) {
        // compute hash and select bucket
        int index = hash(key);
        Node<K, V> bHEAD = buckets[index];

        // search element on the bucket linked list
        for (Node<K, V> n = bHEAD; n != null ; n = n.next) {
            if(n.key.equals(key)) {
                Node<K, V> tmp = first;
                first = n;

                // Unlink matched key from the linked list
                if(first.prevRU != null) {
                    first.prevRU.nextRU = first.nextRU;
                    if(first.nextRU != null) first.nextRU.prevRU = first.prevRU;
                }

                // update pointer to the first node
                first.nextRU = tmp;
                first.prevRU = null;
                tmp.prevRU = first;

                return n.value;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);

        // Update pointer to the first node,
        // and update the parallel recently used ordered linked list
        Node<K, V> tmp = first;
        first = newNode;
        first.nextRU = tmp;
        if(tmp != null) tmp.prevRU = first;

        // compute hash and select bucket
        int index = hash(key);
        Node bucketHead = buckets[index];

        // add a new entry if it is an empty bucket
        if(bucketHead == null){
            buckets[index] = newNode;
        } else { // avoid collision by Separate Chaining
            for (Node i = bucketHead; i != null; i = i.next) {
                if(i.next == null) {
                    i.next = newNode;
                    break;
                }
            }
        }
    }

    private int hash(K key) {
        return key.hashCode() % buckets.length;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new SeparateChainingHashMapIterator();
    }

    private class Node<K, V>{
        public K key;
        public V value;
        public Node<K, V> next;

        //LinkedHashMap specific pointers
        public Node<K, V> prevRU; //RU = recently used
        public Node<K, V> nextRU;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {return "{" + key + ", " + value + '}';}
    }

    private class SeparateChainingHashMapIterator implements Iterator<Object> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return (current.nextRU != null);
        }

        @Override
        public Object next() {
            if(current == null) throw new NoSuchElementException();
            return current.key;
        }
    }
}
