package algorithms.sort;

/**
 * Created with IntelliJ IDEA.
 * User: Bruno
 * Date: 10/19/13
 * Time: 6:03 PM
 */
public class MergeSort extends AbstractSort{
    private static Comparable[] aux;

    private static void merge(Comparable[] c, int lo, int mid, int hi){
        int i = lo, j = mid+1;

        // copy a[lo..hi] to aux[lo..hi]
        for (int k = lo; k <= hi; k++)
            aux[k] =  c[k];

        // Merge back to a[lo..hi].
        for (int k = lo; k <= hi; k++){
            if      (i > mid)               c[k] = aux[j++];
            else if (j > hi )               c[k] = aux[i++];
            else if (less(aux[j], aux[i]))  c[k] = aux[j++];
            else                            c[k] = aux[i++];
        }
    }

    public static Comparable[] sort (Comparable[] c){
        aux = new Comparable[c.length];
        sort(c, 0, c.length - 1);
        return c;
    }

    private static void sort(Comparable[] c, int lo, int hi) {
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(c, lo, mid);   // sort left half
        sort(c, mid+1, hi); // sort right half
        merge(c, lo, mid, hi);
        return;
    }
}
