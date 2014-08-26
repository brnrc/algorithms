package algorithms.bst.hackerrank;

import java.util.Scanner;

/**
 * Complexity:
 *  Time : O(N) * O(Euclidean's)
 *  Space: O(N)
 *
 * Created by Bruno Cardoso on 26/08/2014.
 */
public class SherlockAndGCD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();

            int possible_gcd = 0;
            for (int j = 0; j < N; j++) {
                possible_gcd = gcd(possible_gcd, scan.nextInt());
            }
            if(possible_gcd == 1) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static int gcd(int a, int b) {
        int t;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
