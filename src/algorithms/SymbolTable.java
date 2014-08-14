package algorithms;

/**
 * Created by Bruno Cardoso on 12/08/2014.
 */
public interface SymbolTable<Key extends Comparable<Key>, Value>{
    public void put(Key key, Value val);
    public Value get(Key key);
    public boolean contains(Key key);
    public Key min();
    public Key max();
    public Key floor(Key key);
    public Key ceiling(Key key);
//    public Value delete(Key key);
//    public Key select(Value value);
}
