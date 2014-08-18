    package algorithms.bst.hackerrank;

    import java.util.Comparator;
    import java.util.PriorityQueue;
    import java.util.Queue;
    import java.util.Scanner;

    /**
     * Created by Bruno on 05/08/2014.
     */
    public class FindMedian {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            long N = scan.nextLong();

            // To reverse compare Integers.
            Comparator<Integer> REVERSE_COMPARE = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            };

            int capacity = (int) N/2;
            Queue<Integer> max = new PriorityQueue<>(capacity, REVERSE_COMPARE); // 0.. (N/2)-1
            Queue<Integer> min = new PriorityQueue<>(capacity);                  // N/2..N-1

            for (int i = 0; i < N; i++) {
                int e = scan.nextInt();

                if (min.peek() != null && e > min.peek()) min.offer(e);
                else                                      max.offer(e);

                // Balance PQs
                int size_differ = Math.abs(max.size() - min.size());
                if(size_differ >= 2){
                    int maxSize = max.size();
                    int minSize = min.size();
                    if(maxSize > minSize)   min.offer(max.poll());
                    else                    max.offer(min.poll());
                }
            }

            // Print median
            int median = 0;

            int maxSize = max.size();
            int minSize = min.size();
            if      (maxSize > minSize) median = max.peek();
            else if (minSize < maxSize) median = min.peek();
            else {
                if(min.peek() - max.peek() == 0) median = min.peek();
                else                             median = (min.peek() - max.peek()) / 2;
            }

            System.out.println(median);
        }
    }
