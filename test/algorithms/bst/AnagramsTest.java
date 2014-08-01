package algorithms.bst;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class AnagramsTest extends TestCase {

    @Test
    public void testSolve() throws Exception {
        ArrayList expected = new ArrayList();
        expected.add("heros");
        expected.add("horse");
        expected.add("shore");
        Assert.assertEquals(expected, Anagrams.solve("horse"));

        expected.clear();
        expected.add("appel");
        expected.add("apple");
        Assert.assertEquals(expected, Anagrams.solve("apple"));
    }
}