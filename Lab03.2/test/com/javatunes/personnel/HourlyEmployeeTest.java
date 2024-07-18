package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee hourlyEmployee;

    @Before
    public void setUp() {
        hourlyEmployee = new HourlyEmployee("Billy", Date.valueOf("2014-08-16"), 32.50, 40.0);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(325, hourlyEmployee.payTaxes(), .001);
    }

    @Test
    public void testPay() {
        assertEquals(1300, hourlyEmployee.pay(), .001);
    }
}