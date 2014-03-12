package algorithms.bst;

/**
 * Created by ribeirob on 11/03/14.
 */
public class FrogJump {
    public static int solution(int X, int Y, int D){
        int rest = (Y - X) % D;
        int result = (Y - X) / D;

        if(rest > 0)
            result += 1;
        return result;
    }
}
