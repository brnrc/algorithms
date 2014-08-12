package algorithms;

/**
 * Created by Bruno Cardoso on 12/08/2014.
 */
public interface SymbolTable<Key extends Comparable<Key>, Value>{
    public void put(Key key, Value val);
    public Value get(Key key);
    public boolean contains(Key key);
}
