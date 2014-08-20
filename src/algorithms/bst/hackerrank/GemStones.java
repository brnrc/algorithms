package algorithms.bst.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Complexity:
 *  Time : O(N*M)
 *  Space: O(N*M)
 *
 * Created by Bruno Cardoso on 20/08/2014.
 */
public class GemStones {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        Set<Character> common = new HashSet<>();

        String firstStone = scan.next();
        for (char a : firstStone.toCharArray()) common.add(a);

        for (int i = 0; i < N - 1; i++) {
            String stone = scan.next();
            Set<Character> stoneSet = new HashSet<>();
            for (char a : stone.toCharArray()) stoneSet.add(a);

            common = intersect(common, stoneSet);
        }

        System.out.println(common.size());
    }

    private static <T> Set<T> intersect(Set<T> set1, Set<T> set2) {
        int size1 = set1.size();
        int size2 = set2.size();
        Set<T> result = new HashSet<>();

        if (size1 > size2) {
            for (T c : set1) if (set2.contains(c)) result.add(c);
        } else {
            for (T c : set2) if (set1.contains(c)) result.add(c);
        }
        return result;
    }
}
