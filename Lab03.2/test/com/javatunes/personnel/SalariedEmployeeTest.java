package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee salariedEmployee;

    @Before
    public void setUp() {
        salariedEmployee = new SalariedEmployee("Logan", Date.valueOf("2014-10-03"), 1600.0);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(480, salariedEmployee.payTaxes(), .001);
    }

    @Test
    public void testPay() {
        assertEquals(1600.0, salariedEmployee.pay(), .001);
    }
}