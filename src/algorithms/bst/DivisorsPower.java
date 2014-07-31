package algorithms.bst;

import java.util.ArrayList;

/**
 * Created by Bruno Cardoso on 30/07/2014.
 */
public class DivisorsPower {
    public static long findArgument(long n){
        double sqrtN = Math.sqrt(n);
        ArrayList<Long> nDivisors = new ArrayList<>();
        for (long i = 1; i <= sqrtN; i++) {
            if(n % i == 0){
                nDivisors.add(i);
                long divisors = 0;
                for (Long l : nDivisors){
                    if(i % l == 0) divisors++;
                }
                double result = h(i, divisors);
                if(result == n){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Pow x by the number of distinct positive divisors in x.
     * h(x) = x^d(x)
     */
    static double h(long x, long divisors) {
        return Math.pow(x, divisors);
    }
}
