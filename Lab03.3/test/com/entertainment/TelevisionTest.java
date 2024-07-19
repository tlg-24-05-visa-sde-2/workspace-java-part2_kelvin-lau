package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 50, DisplayType.PLASMA);
        tv2 = new Television("Sony", 50, DisplayType.PLASMA);
    }

    @Test
    public void equals_shouldReturnTrue_sameBrand_sameVolume_sameDisplay() {
        assertEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_sameVolume_differentDisplay() {
        tv2.setDisplay(DisplayType.LED);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_differentVolume_sameDisplay() {
        tv2.setVolume(49);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_differentBrand_sameVolume_sameDisplay() {
        tv2.setBrand("LG");
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws Exception {
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws Exception {
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() {
        try {
            tv1.changeChannel(0);
            fail("Should have thrown InvalidChannelException");
        } catch (InvalidChannelException e){
            String expected = "Invalid channel: 0. Allowed range: [1,999].";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_upperBound() {
        try {
            tv1.changeChannel(1000);
            fail("Should have thrown InvalidChannelException");
        } catch (InvalidChannelException e){
            String expected = "Invalid channel: 1000. Allowed range: [1,999].";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tv1.setVolume(100);
        assertEquals(100, tv1.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv1.setVolume(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        tv1.setVolume(101);
    }
}