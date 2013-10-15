package algorithms.sort;

/**
 * Created with IntelliJ IDEA.
 * User: Bruno
 * Date: 10/5/13
 * Time: 6:41 PM
 */
public abstract class AbstractSort {
    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected static void swap(Comparable[] c, int i, int j) {
        Comparable aux = c[i];
        c[i] = c[j];
        c[j] = aux;
    }

    protected static int minFor(Comparable[] comparable, int start) {
        int min = start;
        for (int i = start; i < comparable.length; i++)
            if (less(comparable[i], comparable[min])) min = i;
        return min;
    }

    protected static void printList(Comparable[] c) {
        for (int i = 0; i < c.length; i++)
            System.out.print(c[i]+" ");
        System.out.println();
    }
}
