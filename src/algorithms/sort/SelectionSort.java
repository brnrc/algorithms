/**
 * Created with IntelliJ IDEA.
 * User: Bruno
 * Date: 10/1/13
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
package algorithms.sort;

public class SelectionSort extends AbstractSort{
    /**
     * In-place selection sort
     * @param c
     */
    public static Comparable[] sort(Comparable[] c){
        int min;
        for (int i = 0; i < c.length-1; i++){
            min = minFor(c, i+1);
            if(c[i].compareTo(c[min]) > 0) {
                swap(c, i, min);
            }
        }
        return c;
    }
}
