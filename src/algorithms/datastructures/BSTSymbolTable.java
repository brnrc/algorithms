package algorithms.datastructures;

import algorithms.SymbolTable;

/**
 * Created by Bruno Cardoso on 12/08/2014.
 */
public class BSTSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    private Node root;

    private class Node{
        public Value val;
        public Key key;
        public Node left, right;

        public Node(Key key, Value val) {
            this.val = val;
            this.key = key;
            left = null;
            right = null;
        }
    }

    // Delegates put operation to BST's put.
    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    // Recursive implementation of put operation in a BST.
    private Node put(Node node, Key key, Value val) {
        if(node == null) return new Node(key, val);
        int cmp = key.compareTo(node.key);
        if(cmp < 0) node.left = put(node.left, key, val);
        else if(cmp > 0) node.right = put(node.right, key, val);
        else node.val = val;
        return node;
    }

    // Delegates get operation to BST's put.
    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    // Recursive implementation of get operation in a BST.
    private Value get(Node node, Key key) {
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else return node.val;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }
}
