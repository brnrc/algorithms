package algorithms.bst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by ribeirob on 12/01/2015.
 *
 * Complexity
 * Time : O(n!) - backtrack
 * Space: O(n)  - recursion
 */
public class GeneratePermutations {
    private static int count = 0;

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        permutations(list);
        System.out.println("total: " + count);
    }

    public static void permutations(ArrayList<Object> n) {
        permute(n, 0, n.size());
    }

    private static void permute(ArrayList<Object> n, int start, int target) {
        if (start == target) {
            processSolution(n);
        } else {
            for (int j = start; j < n.size(); j++) {
                Collections.swap(n, start, j);
                permute(n, start + 1, target);
                Collections.swap(n, j, start); //backtrack
            }
        }
    }

    private static void processSolution(Collection<Object> candidate) {
        System.out.println(candidate);
        count++;
    }
}
