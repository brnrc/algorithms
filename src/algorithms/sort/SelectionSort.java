/**
 * Created with IntelliJ IDEA.
 * User: Bruno
 * Date: 10/1/13
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
package algorithms.sort;

public class SelectionSort {
    public SelectionSort(){
    }

    /**
     * In-place selection sort
     * @param c
     */
    public static void sort(Comparable[] c){
        int min;
        for (int i = 0; i < c.length-1; i++){
            min = minFor(c, i+1);
            if(c[i].compareTo(c[min]) > 0) {
                swap(c, i, min);
            }
        }
        printList(c);
        return ;
    }

    private static void printList(Comparable[] c) {
        for (int i = 0; i < c.length; i++)
            System.out.print(c[i]+" ");
    }

    private static void swap(Comparable[] c, int i, int j) {
        Comparable aux = c[i];
        c[i] = c[j];
        c[j] = aux;
    }

    private static int minFor(Comparable[] comparable, int start) {
        int min = start;
        for (int i = start; i < comparable.length; i++)
            if (less(comparable[i], comparable[min])) min = i;
        return min;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


}
