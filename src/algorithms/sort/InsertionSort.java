package algorithms.sort;

/**
 * Created with IntelliJ IDEA.
 * User: Bruno
 * Date: 10/4/13
 * Time: 11:02 PM
 */
public class InsertionSort extends AbstractSort {
    public static Comparable[] sort (Comparable [] c){
        Comparable key;
        int j;
        for (int i = 1; i < c.length; i++){
            key = c[i];
            for (j = i - 1; (j >= 0) && (less(key,c[j])); j--)
                c[j + 1] = c[j];
            c[j+1] = key;
        }
        return c;
    }
}
