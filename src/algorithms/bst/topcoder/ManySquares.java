package algorithms.bst.topcoder;

import java.util.HashMap;

/**
 * Created by Bruno on 04/08/2014.
 */
public class ManySquares {
    public static int howManySquares(int[] sticks){
        int squares = 0;
        HashMap<Integer, Integer> map = new HashMap<>(sticks.length);

        for (int s : sticks){
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
                if(map.get(s) >= 4){
                    map.remove(s);
                    squares++;
                }
            }

        }

        return squares;
    }
}
