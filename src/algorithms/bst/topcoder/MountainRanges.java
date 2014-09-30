package algorithms.bst.topcoder;

/**
 * Created by Bruno Cardoso on 29/09/2014.
 */
public class MountainRanges {
    public static int countPeaks(int[] heights){
        int peaks = 0;
        if(heights.length == 0) return 0;
        else if (heights.length == 1) return 1;

        int N = heights.length - 1;
        for (int i = 1; i < N; i++) {
            int before = heights[i - 1];
            int after = heights[i + 1];
            int current = heights[i];
            if (current > before && current > after) peaks++;
        }
        //test first and last
        if (heights[0] > heights[1]) peaks++;
        if (heights[N] > heights[N - 1]) peaks++;
        return peaks;
    }
}
