package algorithms.bst;

import org.junit.Assert;
import org.junit.Test;

public class BishopMoveTest {

    @Test
    public void testHowManyMoves() throws Exception {
        Assert.assertEquals(1 , BishopMove.howManyMoves(4, 6, 7, 3));
        Assert.assertEquals(0 , BishopMove.howManyMoves(2, 5, 2, 5));
        Assert.assertEquals(2 , BishopMove.howManyMoves(1, 3, 5, 5));
        Assert.assertEquals(-1 , BishopMove.howManyMoves(4, 6, 7, 4));
        Assert.assertEquals(-1 , BishopMove.howManyMoves(0, 0, 0, 1));
        Assert.assertEquals(2 , BishopMove.howManyMoves(0, 0, 2, 0));
        Assert.assertEquals(-1 , BishopMove.howManyMoves(0, 0, 1, 0));
    }

}