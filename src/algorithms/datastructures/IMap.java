package algorithms.datastructures;

/**
 * Created by Bruno Cardoso on 03/09/2014.
 */
public interface IMap<K, V> {
    public V    get(K key);
    public void put(K key, V value);
}
