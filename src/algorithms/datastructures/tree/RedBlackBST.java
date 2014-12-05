package algorithms.datastructures.tree;

import algorithms.SymbolTable;
import algorithms.datastructures.Pair;

import java.util.*;

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
        public Node left, right;
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

        if (isRed(h.left) && isRed(h.right)) colorFlip(h);

        int cmp = key.compareTo(h.key);
        if(cmp < 0)      h.left = put(h.left, key, val);
        else if(cmp > 0) h.right = put(h.right, key, val);
        else             h.val = val;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(!isRed(h.right) && isRed(h.left)) h = rotateRight(h);

        return h;
    }


    private void colorFlip(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
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
        if      (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
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
        if(node.left == null) return node;
        return min(node.left);
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if(node.right == null) return node;
        return max(node.right);
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
        else if(cmp < 0) return floor(node.left, key);
        Node t = floor(node.right, key);
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
        if (cmp > 0)  return ceiling(node.right, key);
        Node t = ceiling(node.left, key);
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
        if(cmp < 0) node.left = delete(node.left, key);
        else if(cmp > 0) node.right = delete(node.right, key);
        else {
            if(node.right == null) return node.left;
            if(node.left == null) return node.right;
            else { //Found node with Key key.
                //Now need to find the min of node.right
                Node min = min(node.right);

                // Reconstruct min left and right links, to point to node's left and right.
                // (the last excluding itself)
                min.right = deleteMin(node.right);
                min.left = node.left;
            }
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if(node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
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
            case ZIGZAG_ORDER:
                return zigzagOrderIterator();
            case LEVEL_ORDER:
                return levelOrderIterator();
            default:
                return preOrderIterator();
        }
    }

    private Iterator<Key> levelOrderIterator() {
        return new Iterator<Key>(){
            Node p;
            Queue<Node> q = new LinkedList<>();
            {
                q.add(root);
            }

            @Override
            public boolean hasNext() {
                return !q.isEmpty();
            }

            @Override
            public Key next() {
                p = q.poll();
                Key ans = null;
                if(p != null){
                    ans = p.key;
                    if(p.left != null) q.add(p.left);
                    if(p.right != null) q.add(p.right);
                }
                return ans;
            }
        };
    }

    private Iterator<Key> zigzagOrderIterator() {
        return new Iterator<Key>(){
            boolean reversed;
            Node p;
            Queue<Node> q = new LinkedList<>();
            Stack<Node> s = new Stack<>();
            {
                s.push(root);
            }

            @Override
            public boolean hasNext() {
                return !q.isEmpty() || !s.isEmpty();
            }

            @Override
            public Key next() {
                Key ans = null;
                if(!q.isEmpty() && !reversed){
                    p = q.poll();
                    if(p != null){
                        ans = p.key;
                        if(p.left != null) s.push(p.left);
                        if(p.right != null) s.push(p.right);
                    }
                } else {
                    reversed = true;
                    p = s.pop();
                    if(p != null){
                        ans = p.key;
                        if(p.left != null) q.add(p.left);
                        if(p.right != null) q.add(p.right);
                    }
                    if(s.isEmpty()) reversed = false;
                }
                return ans;
            }
        };
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
                                if (node.right != null)
                                    s.push(new Pair<>(node.right, false));
                                if (node.left != null)
                                    s.push(new Pair<>(node.left, false));
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
        return node.left != null || node.right != null;
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
                    if(p != null && p.left != null) {
                        s.push(p.left);
                        p = p.left;
                    }
                    else {
                        p = s.pop();
                        if(p.right != null) s.push(p.right);

                        // save return value
                        Key next = p.key;

                        // update the pointer
                        p = p.right;
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
                    if(p.right != null) stack.push(p.right);
                    if(p.left != null) stack.push(p.left);
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
            case ZIGZAG_ORDER:
                break;
        }
        return l;
    }

    private void preWalk(Node node, List<Value> list) {
        if(node == null) return;
        list.add(node.val);
        preWalk(node.left, list);
        preWalk(node.right, list);
    }

    private void inWalk(Node node, List<Value> list) {
        if(node == null) return;
        inWalk(node.left, list);
        list.add(node.val);
        inWalk(node.right, list);
    }

    private void postWalk(Node node, List<Value> list) {
        if(node == null) return;
        postWalk(node.left, list);
        postWalk(node.right, list);
        list.add(node.val);
    }

    public List<Value> printWalk(TreeIteratorOrder order) {
        List<Value> l = new ArrayList<>();

        switch (order){
            case PRE_ORDER:
//                preWalk(root);
                break;
            case IN_ORDER:
//                inWalk(root);
                break;
            case POST_ORDER:
                l = postWalkFast();
                break;
            case ZIGZAG_ORDER:
                break;
        }
        return l;
    }

    private List<Value> postWalkFast() {
        List<Value> result = new ArrayList<>();

        Pair<Node, Boolean> p;
        Stack<Pair<Node, Boolean>> s = new Stack<>();

        if(root == null)
            return null;

        s.push(new Pair<>(root, false));
        while (!s.isEmpty()){
            p = s.peek();

            //check if it is marked
            if(p.second){
                result.add(p.first.val);
                s.pop();
            }
            else {
                //mark node
                p.second = true;
                if(hasChildren(p.first)){
                    if(p.first.right != null) s.push(new Pair<>(p.first.right, false));
                    if(p.first.left != null) s.push(new Pair<>(p.first.left, false));
                } else {
                    // remove
                    p = s.pop();
                    result.add(p.first.val);
                }
            }
        }

        return result;
    }

    public enum TreeIteratorOrder {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        ZIGZAG_ORDER,
        LEVEL_ORDER
    }
}
