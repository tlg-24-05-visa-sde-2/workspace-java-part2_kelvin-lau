package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    private TelevisionBrandChannelComparator comparator;
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        comparator = new TelevisionBrandChannelComparator();
        tv1 = new Television("Samsung");
        tv2 = new Television("Samsung");
    }

    @Test
    public void compare_shouldReturnZero_sameBrand_sameChannel() {
        int result = comparator.compare(tv1, tv2);
        assertEquals(0, result);
    }

    @Test
    public void compare_shouldReturnNegative_when1stBrandLessThan2ndBrand() {
        tv1.setBrand("A_lessThan");
        tv2.setBrand("B_greaterThan");
        assertTrue(comparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldReturnPositive_when1stBrandGreaterThan2ndBrand() {
        tv1.setBrand("B_lessThan");
        tv2.setBrand("A_greaterThan");
        assertTrue(comparator.compare(tv1, tv2) > 0);
    }

    @Test
    public void compare_shouldReturnPositive_sameBrand_differentChannel_firstGreaterThanSecond() {
        try {
            tv1.changeChannel(999);
            int result = comparator.compare(tv1, tv2);
            assertTrue(result > 0);
        } catch (InvalidChannelException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void compare_shouldReturnPositive_sameBrand_differentChannel_firstLessThanSecond() {
        try {
            tv2.changeChannel(999);
            int result = comparator.compare(tv1, tv2);
            assertTrue(result < 0);
        } catch (InvalidChannelException e) {
            System.out.println(e.getMessage());
        }
    }
}