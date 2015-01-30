package algorithms.bst;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Bruno on 13/12/2014.
 */
public class Knapsack {
    public static void solve(int[] s, int target){
        Arrays.sort(s);
        walk(s, 0, target, new Stack<>());
    }

    private static void walk(int[] s, int start, int target, Stack<Integer> ans) {
        if(target < 0)
            return;
        else if(target == 0)
            System.out.println(ans.toString());
        else
        {
            for (int i = start; i < s.length; i++) {
                if(s[i] <= target){
                    ans.push(s[i]);
                    walk(s, i, target - s[i], ans);
                    ans.pop();
                } else return;
            }
        }
    }

    public static void main(String[] args) {
        Knapsack.solve(new int[]{1,2}, 8);
    }
}
