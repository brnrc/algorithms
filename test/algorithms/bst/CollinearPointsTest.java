package algorithms.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CollinearPointsTest {


    private Point[] input;

    @Before
    public void setUp() throws Exception{
        IntStream xs = new Random().ints(0,10).limit(50000);
        IntStream ys = new Random().ints(0,10).limit(50000);
        java.util.List<Integer> xList = xs.boxed().collect(Collectors.toList());
        java.util.List<Integer> yList = ys.boxed().collect(Collectors.toList());

        input = new Point[xList.size()];
        for (int i = 0; i < yList.size(); i++) {
            Integer y = yList.get(i);
            Integer x = xList.get(i);
            input[i] = new Point(x,y);
        }
    }


    @Test
    public void testCollinearWith3Points() throws Exception {
        HashSet<Point> result = CollinearPoints.count(new Point[]{
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
        });
        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(1, 1));
        expected.add(new Point(2, 2));
        expected.add(new Point(3, 3));

        assertThat(expected, is(result));
    }

    @Test
    public void testCollinear5PointsVS4Points() throws Exception {

        Point[] input = {
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4),
                new Point(1, 2),
                new Point(2, 4),
                new Point(3, 6),
                new Point(4, 8),
                new Point(5, 10)
        };

        HashSet<Point> result = CollinearPoints.count(input);
        Assert.assertEquals(5, result.size());
    }

    @Test
    public void testBigInput() throws Exception {
        // just to test the check the running time ~ 11s for 50k
        Assert.assertTrue(CollinearPoints.count(input).size() > 0);
    }
}