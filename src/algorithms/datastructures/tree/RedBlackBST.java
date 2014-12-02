package algorithms.datastructures.tree;

import algorithms.SymbolTable;
import algorithms.datastructures.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Bruno Cardoso on 15/08/2014.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node{

        public Value val;
        public Key key;
        public Node l, r;
        public boolean color;
        public Node(Key key, Value val) {
            this.val = val;
            this.key = key;
            this.color = RED;
        }

        @Override
        public String toString() {
            return this.val.toString();
        }

    }
    // Delegates put operation to BST's put.
    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }


    // Recursive implementation of put operation in a BST.
    private Node put(Node h, Key key, Value val) {
        if(h == null) return new Node(key, val);

        if (isRed(h.l) && isRed(h.r)) colorFlip(h);

        int cmp = key.compareTo(h.key);
        if(cmp < 0)      h.l = put(h.l, key, val);
        else if(cmp > 0) h.r = put(h.r, key, val);
        else             h.val = val;

        if(isRed(h.r) && !isRed(h.l)) h = rotateLeft(h);
        if(!isRed(h.r) && isRed(h.l)) h = rotateRight(h);

        return h;
    }

    private void colorFlip(Node h) {
        h.color = !h.color;
        h.l.color = !h.l.color;
        h.r.color = !h.r.color;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
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
        if      (cmp < 0) return get(node.l, key);
        else if (cmp > 0) return get(node.r, key);
        else return node.val;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if(node.l == null) return node;
        return min(node.l);
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if(node.r == null) return node;
        return max(node.r);
    }

    @Override
    public Key floor(Key key) {
        Node node = floor(root, key);
        if(node == null) return null;
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        else if(cmp < 0) return floor(node.l, key);
        Node t = floor(node.r, key);
        if (t != null) return t;
        else return node;
    }

    @Override
    public Key ceiling(Key key) {
        Node ceil = ceiling(root, key);
        if(ceil == null) return null;
        return ceil.key;
    }

    private Node ceiling(Node node, Key key) {
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp > 0)  return ceiling(node.r, key);
        Node t = ceiling(node.l, key);
        if (t != null) return t;
        return node;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0) node.l = delete(node.l, key);
        else if(cmp > 0) node.r = delete(node.r, key);
        else {
            if(node.r == null) return node.l;
            if(node.l == null) return node.r;
            else { //Found node with Key key.
                //Now need to find the min of node.r
                Node min = min(node.r);

                // Reconstruct min l and r links, to point to node's l and r.
                // (the last excluding itself)
                min.r = deleteMin(node.r);
                min.l = node.l;
            }
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if(node.l == null) return node.r;
        node.l = deleteMin(node.l);
        return node;
    }

    private Node rotateLeft(Node h){
        Node x = h.r;
        h.r = x.l;
        x.l = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.l;
        h.l = x.r;
        x.r = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    public Iterator<Key> getIterator(){
        return getIterator(TreeIteratorOrder.PRE_ORDER);
    }

    public Iterator<Key> getIterator(TreeIteratorOrder order){
        switch (order) {
            case PRE_ORDER:
                return preOrderIterator();
            case IN_ORDER:
                return inOrderIterator();
            case POST_ORDER:
                return postOrderIterator();
            default:
                return preOrderIterator();
        }
    }

    private Iterator<Key> postOrderIterator() {
        return new Iterator<Key>(){

            private Pair<Node, Boolean> p;
            private Stack<Pair<Node, Boolean>> s = new Stack<>();
            {
                s.push(new Pair<>(root, false));
            }

            @Override
            public boolean hasNext() {
                return !s.isEmpty();
            }

            @Override
            public Key next() {

                while(!s.isEmpty()){
                    p = s.peek();

                    if(p.second) {
                        s.pop();
                        return p.first.key;
                    }
                    else {
                        // mark as visited
                        p.second = true;
                        while (p != null) {
                            Node node = p.first;
                            if(hasChildren(node)){
                                if (node.r != null)
                                    s.push(new Pair<>(node.r, false));
                                if (node.l != null)
                                    s.push(new Pair<>(node.l, false));
                            } else {
                                node = s.pop().first;
                                return node.key;
                            }
                            p = s.peek();
                        }
                    }
                }
                return null;
            }
        };
    }

    private boolean hasChildren(Node node) {
        return node.l != null || node.r != null;
    }

    private Iterator<Key> inOrderIterator() {
        return new Iterator<Key>(){
            private Node p = root;
            private Stack<Node> s = new Stack<>();
            {
                s.push(root);
            }

            @Override
            public boolean hasNext() {
                return !s.isEmpty();
            }

            @Override
            public Key next() {
                while(!s.isEmpty() || p != null){
                    if(p != null && p.l != null) {
                        s.push(p.l);
                        p = p.l;
                    }
                    else {
                        p = s.pop();
                        if(p.r != null) s.push(p.r);

                        // save return value
                        Key next = p.key;

                        // update the pointer
                        p = p.r;
                        return next;
                    }
                }
                return null;
            }
        };
    }

    private Iterator<Key> preOrderIterator() {
        return new Iterator<Key>(){
            private Node p;
            public Stack<Node> stack = new Stack<>();
            {
                stack.push(root);
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Key next() {
                p = stack.pop();
                if(p != null) {
                    if(p.r != null) stack.push(p.r);
                    if(p.l != null) stack.push(p.l);
                    return p.key;
                }
                return null;
            }
        };
    }

    public List<Value> walk(TreeIteratorOrder order) {
        List<Value> l = new ArrayList<>();

        switch (order){
            case PRE_ORDER:
                preWalk(root, l);
                break;
            case IN_ORDER:
                inWalk(root, l);
                break;
            case POST_ORDER:
                postWalk(root, l);
                break;
            case LEVEL_ORDER:
                break;
        }
        return l;
    }

    private void preWalk(Node node, List<Value> list) {
        if(node == null) return;
        list.add(node.val);
        preWalk(node.l, list);
        preWalk(node.r, list);
    }

    private void inWalk(Node node, List<Value> list) {
        if(node == null) return;
        inWalk(node.l, list);
        list.add(node.val);
        inWalk(node.r, list);
    }

    private void postWalk(Node node, List<Value> list) {
        if(node == null) return;
        postWalk(node.l, list);
        postWalk(node.r, list);
        list.add(node.val);
    }

    public enum TreeIteratorOrder {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        LEVEL_ORDER
    }
}
