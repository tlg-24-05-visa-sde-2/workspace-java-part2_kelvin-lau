package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv1;

    @Before
    public void setUp() {
        tv1 = new Television();
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
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_upperBound() {
        tv1.setVolume(100);
        assertEquals(100, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldNotStoreValue_whenInvalid_lowerBound() {

    }

    @Test
    public void setVolume_shouldNotStoreValue_whenInvalid_upperBound() {
    }

    @Test
    public void testChangeChannel() {
    }

    @Test
    public void testChangeChannelInvalidChannelException() {
    }
}