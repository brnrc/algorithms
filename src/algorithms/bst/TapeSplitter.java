package algorithms.bst;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ribeirob on 11/03/14.
 */
public class TapeSplitter {
    public static int solution(int[] A){
        int sum = 0;
        int sumLeft = 0;
        ArrayList<Integer> diff = new ArrayList<Integer>();

        for(int i = 0; i < A.length; i++) sum += A[i];

        for(int j = 1; j < A.length; j++){
            sumLeft += A[j-1];
            int sumRight = sum - sumLeft ;
            diff.add(Math.abs(sumLeft - sumRight));
            System.out.println("diff: " + diff );
        }
        System.out.println();
        return Collections.min(diff);
    }
}
