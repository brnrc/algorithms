package algorithms.bst;

import org.junit.Assert;
import org.junit.Test;

public class DivisorsPowerTest {

    @Test
    public void testFindArguments() throws Exception {
        Assert.assertEquals(2, DivisorsPower.findArgument(4), 0);
        Assert.assertEquals(-1, DivisorsPower.findArgument(10), 0);
        Assert.assertEquals(4, DivisorsPower.findArgument(64), 0);
        Assert.assertEquals(10, DivisorsPower.findArgument(10000), 0);
//        Assert.assertEquals(49983883, DivisorsPower.findArgument(2498388559757689L), 0);
//        Assert.assertEquals(-1, DivisorsPower.findArgument(999999999999999996L), 0);
    }
}