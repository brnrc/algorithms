package algorithms.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Bruno
 * Date: 10/19/13
 * Time: 8:23 PM
 */
public class SortTest {
    private Integer[] testArray;
    private Integer[] testArraySorted;
    private int size = 10000;
    private int range = 10;

    @Before
    public void setUp() throws Exception {
        testArray = new Integer[size];
        Random r = new Random();

        //populate the test testArray
        for (int i = 0; i < testArray.length; i++){
            testArray[i] = r.nextInt(range);
        }
        //sort testArray to compare with the results of sorting algorithms
        testArraySorted = Arrays.copyOf(testArray, size);
        Arrays.sort(testArraySorted);
    }

    @Test
    public void testInsertionSort() throws Exception {
        Assert.assertArrayEquals(testArraySorted, InsertionSort.sort(testArray));
    }
    @Test
    public void testMergeSort() throws Exception {
        Assert.assertArrayEquals(testArraySorted, MergeSort.sort(testArray));
    }
    @Test
    public void testShellSort() throws Exception {
        Assert.assertArrayEquals(testArraySorted, ShellSort.sort(testArray));
    }
    @Test
    public void testSelectionSort() throws Exception {
        Assert.assertArrayEquals(testArraySorted, SelectionSort.sort(testArray));
    }
}
