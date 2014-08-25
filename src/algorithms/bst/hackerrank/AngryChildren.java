package algorithms.bst.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Complexity:
 *  Time : O(N logN)
 *  Space: O(N)
 *
 * Created by Bruno Cardoso on 25/08/2014.
 */
public class AngryChildren {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int K = scan.nextInt();

        List<Integer> packs = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            packs.add(scan.nextInt());
        }

        Collections.sort(packs);

        long result = 10000000000L;
        for (int i = K-1; i < N; i++) {
            long diff = packs.get(i) - packs.get(i-K+1);
            if(diff < result) result = diff;
        }

        System.out.println(result);
    }
}
