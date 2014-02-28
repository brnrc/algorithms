package algorithms.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ribeirob on 03/02/14.
 *
 * Sort a list of N lists of P elements.
 * M = N*P
 * O(n log(M))    Time complexity
 *
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
        PriorityQueue<Node<T>> pq = new PriorityQueue<Node<T>>();

        //add first element of every list to the heap and remove from the list
        int i = 0;
        for(List<T> subList : mListOfLists){
            if(subList != null){
                T value = subList.get(0);
                if(value != null){
                    pq.add(new Node<T>(value, i));
                    subList.remove(0);
                }
            }
            i++;
        }
        return pq;
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
