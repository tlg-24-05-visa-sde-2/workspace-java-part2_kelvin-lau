package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    private TelevisionChannelComparator comparator;
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        comparator = new TelevisionChannelComparator();
        tv1 = new Television();
        tv2 = new Television();
    }

    @Test
    public void compare_shouldReturnZero_whenChannelsAreEqual() {
        int result = comparator.compare(tv1, tv2);
        assertEquals(0, result);
    }

    @Test ()
    public void compare_shouldReturnPositive_whenChannelsNotEqual_firstGreaterThanSecond() throws Exception {
        tv1.changeChannel(999);
        int result = comparator.compare(tv1, tv2);
        assertTrue(result > 0);
    }

    @Test
    public void compare_shouldReturnNegative_whenChannelsNotEqual_firstLessThanSecond() throws Exception{
        tv2.changeChannel(999);
        int result = comparator.compare(tv1, tv2);
        assertTrue(result < 0);

    }
}