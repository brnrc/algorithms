package algorithms.bst.topcoder;

import org.junit.Assert;
import org.junit.Test;

public class HappyLetterDiv2Test {

    @Test
    public void testGetHappyLetter() throws Exception {
        Assert.assertEquals('a', HappyLetterDiv2.getHappyLetter("aacaaa"));
        Assert.assertEquals('.', HappyLetterDiv2.getHappyLetter("dcdjx"));
        Assert.assertEquals('.', HappyLetterDiv2.getHappyLetter("aabc"));
        Assert.assertEquals('b', HappyLetterDiv2.getHappyLetter("bcbbbbba"));
        Assert.assertEquals('.', HappyLetterDiv2.getHappyLetter("ovcoocvoocujovovccooocccooocucccoooccoccocococco"));
        Assert.assertEquals('.', HappyLetterDiv2.getHappyLetter("babaabababababababababbbabacccccccdddddddcccbababa"));
        Assert.assertEquals('x', HappyLetterDiv2.getHappyLetter("xxrxxxahxxxxaanxxhxxxhhnaxxxxeaxhxxx"));
    }
}