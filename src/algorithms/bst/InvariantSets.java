package algorithms.bst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bruno Cardoso on 23/07/2014.
 */
public class InvariantSets {
    public static long countSets(int[] f) {
        long invariants = 0;

        Set<Integer> E = new HashSet<>();
        int n = f.length;
        for (int i = 0; i < n; i++) {
            E.add(i);
        }

        Set<Set<Integer>> subs = powerSet(E);
        for (Set<Integer> S : subs) {
            boolean skip = false;
            for (Integer x : S) {
                if (!(x >= 0 && x <= n - 1 && S.contains(f[x]))) {
                    skip = true;
                    break;
                }
            }
            if (!skip) invariants++;
        }
        return invariants;
    }

    // StackOverflow: http://stackoverflow.com/questions/1670862/obtaining-a-powerset-of-a-set-in-java
    private static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }


}
