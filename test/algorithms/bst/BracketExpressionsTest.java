package algorithms.bst;


import org.junit.Assert;
import org.junit.Test;

public class BracketExpressionsTest {

    @Test
    public void testIfPossible() throws Exception {
        Assert.assertEquals("possible", BracketExpressions.ifPossible("([]{})"));
        Assert.assertEquals("possible", BracketExpressions.ifPossible("(())[]"));
        Assert.assertEquals("impossible", BracketExpressions.ifPossible("({])"));
        Assert.assertEquals("impossible", BracketExpressions.ifPossible("[]X"));
        Assert.assertEquals("possible", BracketExpressions.ifPossible("[]XX"));
        Assert.assertEquals("impossible", BracketExpressions.ifPossible("XXX"));
        Assert.assertEquals("possible", BracketExpressions.ifPossible("XX"));
        Assert.assertEquals("impossible", BracketExpressions.ifPossible("X"));
        Assert.assertEquals("possible", BracketExpressions.ifPossible(""));
        Assert.assertEquals("possible", BracketExpressions.ifPossible("[{}X"));
        Assert.assertEquals("possible", BracketExpressions.ifPossible("([]X()[()]XX}[])X{{}}]"));
        Assert.assertEquals("impossible", BracketExpressions.ifPossible("(X{{{{{{{{{}}}}}}}}})}"));
        Assert.assertEquals("possible", BracketExpressions.ifPossible("XXXX()()()()()()()()()()()()()()()()()()()()()()(X"));
    }
}