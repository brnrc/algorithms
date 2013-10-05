package algorithms.sort;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bruno
 * Date: 10/1/13
 * Time: 1:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class SelectionSortTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void testSort() throws Exception {
        Integer[] list = new Integer[5];
        list[0] = 7;
        list[1] = 623;
        list[2] = 16;
        list[3] = 36;
        list[4] = 62;
        SelectionSort.sort(list);
        Integer[] ans1 = {7,16,36,62,623};
        Assert.assertArrayEquals(ans1, SelectionSort.sort(list));

        String s[] = {
            new String("D4"),
            new String("C3"),
            new String("B2"),
            new String("A12")
        };
        String[] ans = {"A12", "B2", "C3", "D4"};
        Assert.assertArrayEquals(ans, SelectionSort.sort(s));

        List<String> listString = new ArrayList<String>();
        listString.add("A1");
        listString.add("A5");
        listString.add("A3");
        listString.add("B1");
        ans = new String[]{"A1", "A3", "A5", "B1"};

        Assert.assertArrayEquals(ans, SelectionSort.sort(listString.toArray(new String[listString.size()])));
    }
}
