package algorithms.bst.topcoder;

/**
 * Created by Bruno on 05/08/2014.
 */
public class BubbleSortWithReversals {
    public int getMinSwaps(int[] A, int K){
        int swaps = 0;
        int k = 0;
        while(k < A.length -1){
            for (int i = 0; i < A.length - 2; i++) {
                if(A[i] >= A[i+1]){
                    int j = i;
                    while (j < A.length-1 && A[j] >= A[j+1]) {
                        j++;
                    }
                    if(j != i && K > 0){
                        K--;
                        A = reverse(A, i, j);
                    } else {
                        if(A[i] > A[i+1]){
                            A = swap(A, i, i+1);
                            swaps++;
                        }
                    }
                }
            }
            k++;
        }

        return swaps;
    }

    private int[] swap(int[] array, int a, int b) {
        int tmp = array[b];
        array[b] = array[a];
        array[a] = tmp;
        return array;
    }

    public int[] reverse(int[] array, int start, int end) {
        int length = (end - start)/2;
        length += length % 2 == 0 ? 0 : 1;

        for (int i = 0; i < length; i++) {
            array = swap(array, start + i, end-i);
        }
        return array;
    }
}
