package algorithms.sort;

/**
 * Created with IntelliJ IDEA.
 * User: Bruno
 * Date: 10/13/13
 * Time: 3:52 PM
 */
public class ShellSort extends AbstractSort{
    public static Comparable[] sort(Comparable[] c){
        Integer N = c.length;
        // Set the h-sort incremental sequence,
        // using 3x + 1 Knuth's sequence
        Integer h = 1;
        while (h < N/3) h = 3*h + 1; //1, 4, 13, 40, 121, 364 ...

        while (h >= 1){
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && less(c[j], c[j - h]); j -= h)
                    swap(c, j, j - h);
            h /= 3;
        }
        return c;
    }
}
