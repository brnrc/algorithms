package algorithms.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by ribeirob on 12/03/14.
 */
public class BoatAlignment {

    public static int solution(int[] R, int X, int M) {
        int max_distance = -1;
        int boat_size = 2*X;
        HashMap<Integer, ArrayList<Integer>> dock_hash = new HashMap<Integer, ArrayList<Integer>>(R.length);

        for(int i = 0; i < R.length ; i++){
            int attach_point = 0;

            if(R[i] - X < 0){
                attach_point = -(R[i] - X);
            }
            attach_point += R[i];

            //middle elements
            if(i > 0){
                // end of Dock
                boolean pushed_back = false;
                if(R[i] + X > M){
                    int need_to_back = R[i] + X - M;
                    attach_point -= need_to_back;
                    pushed_back = true;
                }

                //for bollards on the same place
                if(R[i-1] == R[i]){
                    attach_point = Collections.max(dock_hash.get(R[i - 1])) + 2*X;
                }

                int last_boat_front = Collections.max(dock_hash.get(R[i - 1])) + X;
                int current_boat_back = attach_point - X;

                if(last_boat_front >= current_boat_back){
                    if(pushed_back) return -1;
                    attach_point = last_boat_front + X;
                }
            }

            if(attach_point - R[i] > max_distance)
                max_distance = attach_point - R[i];

            if(dock_hash.containsKey(R[i])){
                ArrayList<Integer> values = dock_hash.get(R[i]);
                values.add(attach_point);
                dock_hash.put(R[i], values);
                //TODO: I probably need to normalize the Boats here so they don't grow for one side only
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(attach_point);
                dock_hash.put(R[i], list);
            }
        }

        return max_distance;
    }

    private static HashMap<Integer,ArrayList<Integer>> moveTop() {
        return null;
    }

    private static boolean shouldITop(HashMap<Integer, ArrayList<Integer>> hash, int start, int finish, int X){
        final Integer top = Collections.min(hash.get(start));
        final Integer bottom = Collections.max(hash.get(finish));
        return Math.abs(top - bottom) > X;
    }

}
