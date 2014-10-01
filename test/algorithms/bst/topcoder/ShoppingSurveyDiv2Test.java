package algorithms.bst.topcoder;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingSurveyDiv2Test {

    @Test
    public void testMinValue() throws Exception {
        Assert.assertEquals(1, ShoppingSurveyDiv2.minValue(5, new int[]{3,3}));
        Assert.assertEquals(97, ShoppingSurveyDiv2.minValue(100, new int[]{97}));
        Assert.assertEquals(5, ShoppingSurveyDiv2.minValue(10, new int[]{9,9,9,9,9}));
        Assert.assertEquals(0, ShoppingSurveyDiv2.minValue(7, new int[]{1,2,3}));
        Assert.assertEquals(0, ShoppingSurveyDiv2.minValue(5, new int[]{3,3,3}));
    }
}