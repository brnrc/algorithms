package algorithms.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Bruno on 07/09/2014.
 */
public class QuickSort extends AbstractSort {

    public static Comparable[] sort(Comparable[] c){
        Collections.shuffle(Arrays.asList(c));
        return sort(c, 0, c.length-1);
    }

    private static Comparable[] sort(Comparable[] c, int lo, int hi) {
        if(lo >= hi) return c;
        int p = partition(c, lo, hi);
        sort(c, lo, p-1);
        sort(c, p+1, hi);
        return c;
    }

    private static int partition(Comparable[] c, int lo, int hi) {
        int i = lo, j = hi+1;
        Comparable p = c[lo];

        while(true)
        {
            while (less(c[++i], p)) if( i == hi) break;
            while (less(p, c[--j])) if( j == lo) break;
            if(i >= j) break;
            swap(c, i, j);
        }
        swap(c, lo, j);
        return j;
    }
}
