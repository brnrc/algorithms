package algorithms.bst.hackerrank;

import java.util.*;

/**
 * Complexity:
 * Time  :  O(N + M)
 * Space :  O(N + M)
 * Created by Bruno Cardoso on 19/08/2014.
 */
public class MissingNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Construct A
        int N = scan.nextInt();
        Map<Integer, Integer> A = new HashMap<>(N);
        for (int i = 0; i < N; i++) {
            int e = scan.nextInt();
            if(A.containsKey(e))    A.put(e, A.get(e) + 1);
            else                    A.put(e, 1);
        }

        //Construct B
        int M = scan.nextInt();
        Set<Integer> B = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            int e = scan.nextInt();
            if(A.containsKey(e)){
                if(A.get(e) > 1)    A.put(e, A.get(e) - 1);
                else                A.remove(e);
            }
            else B.add(e);
        }

        // Print missing elements
        for (Integer missing : B){
            System.out.print(missing + " ");
        }
    }
}
