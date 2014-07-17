package algorithms.bst;

/**
 * Created by ribeirob on 17/07/2014.
 */
public class Diamond {
    public static void main(String[] args) {
        print(Integer.parseInt(args[0]));
    }
    public static void print(int size){
        int depth = (size*2) - 1;

        int mid = depth/2;
        int left = mid, right = mid;

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < depth; j++) {
                if(j >= left && j <= right){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if(i < mid){
                //grow
                left--;
                right++;
            } else {
                //shrink
                left++;
                right--;
            }
        }
    }
}
