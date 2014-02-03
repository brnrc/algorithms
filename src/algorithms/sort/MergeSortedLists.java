package algorithms.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ribeirob on 03/02/14.
 */
public class MergeSortedLists<T extends Comparable<T>> {

    private final List<List<T>> mListOfLists;
    private PriorityQueue<Node<T>> mHeap;

    public MergeSortedLists(List<List<T>> listOfLists){
        this.mListOfLists = listOfLists;

        // initialize support heap
        this.mHeap = createHeap();
    }

    public List<T> sort(){
        ArrayList<T> l = new ArrayList<T>();

        while(mHeap.size() > 0){
            l.add(next());
        }
        return l;
    }

    private PriorityQueue<Node<T>> createHeap(){
        PriorityQueue<Node<T>> p = new PriorityQueue<Node<T>>();

        //add first element of every list to the heap
        for(int i = 0; i < mListOfLists.size(); i++){
            List<T> subList = mListOfLists.get(i);
            if(subList != null){
                T value = subList.get(0);
                if(value != null){
                    Node<T> n = new Node<T>(value, i);
                    p.add(n);
                    subList.remove(0);
                }
            }
        }
        return p;
    }

    private T next() {
        // dequeue
        Node<T> head = mHeap.poll();

        // inserts next element from listOfLists to the heap
        int dequeuedPosition = head.getPosition();
        List<T> dequeuedFromList = mListOfLists.get(dequeuedPosition);
        if(dequeuedFromList != null){
            if(dequeuedFromList.size() > 0)  {
                T value = dequeuedFromList.get(0);
                dequeuedFromList.remove(0);
                if(value != null){
                    Node<T> e = new Node<T>(value, dequeuedPosition);
                    // queue
                    mHeap.add(e);
                }
            }
        }
        return head.getElement();
    }

    private class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        int position;
        T element;

        public Node(T element, int position) {
            this.position = position;
            this.element = element;
        }

        public int getPosition() {
            return position;
        }

        public T getElement() {
            return element;
        }

        @Override
        public int compareTo(Node<T> o) {
            return element.compareTo(o.element);
        }
    }
}
