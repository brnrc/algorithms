package algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bruno
 * Date: 10/15/13
 * Time: 1:33 AM
 */
public class ShellSortTest {
    @Test
    public void testSort() throws Exception {

        Integer[] list = new Integer[5];
        list[0] = 7;
        list[1] = 623;
        list[2] = 16;
        list[3] = 36;
        list[4] = 62;
        Integer[] expectedInt = {7,16,36,62,623};
        Assert.assertArrayEquals(expectedInt, SelectionSort.sort(list));


        String s[] = {"D4","C3","B2","A12"};
        String[] expected = {"A12", "B2", "C3", "D4"};
        Assert.assertArrayEquals(expected, SelectionSort.sort(s));

        List<String> listString = new ArrayList<String>();
        listString.add("A1");
        listString.add("A5");
        listString.add("A3");
        listString.add("B1");
        expected = new String[]{"A1", "A3", "A5", "B1"};

        Assert.assertArrayEquals(expected, SelectionSort.sort(listString.toArray(new String[listString.size()])));
    }
}
