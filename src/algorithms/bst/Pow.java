package algorithms.bst;

/**
 * Created by ribeirob on 11/03/14.
 */
public class Pow {
    public static int pow(int x, int y){
        int result = 1;
        while(y > 0){
            if(y % 2 > 0) result *= x;
            y /= 2;
            x *= x;
        }
        return result;
    }
    public static int pow2(int x, int y){
        int result = 1;
        for(int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }
}
