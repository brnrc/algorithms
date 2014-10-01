package algorithms.bst.topcoder;

/**
 * Complexity:
 *  Time : O(NM)
 *  Space: O(1)
 * Created by Bruno Cardoso on 01/10/2014.
 */
public class ShoppingSurveyDiv2 {
    public static int minValue(int N, int[] s){
        int M = s.length;
        for (int r = 0; r < N; r++) {
            int remainingCustomers = N - r;
            int max = 0;
            int sum = 0;
            for (int y : s){
                y -= r;
                max = ((max < y) ? y : max);
                sum += y;
            }
            if(max <= remainingCustomers) {
                if (remainingCustomers * (M - 1) >= sum){
                    return r;
                }
            }
        }
        return N;
    }
}
