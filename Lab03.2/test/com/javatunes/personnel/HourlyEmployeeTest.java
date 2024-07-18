package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee hourlyEmployee1;
    private HourlyEmployee hourlyEmployee2;
    private HourlyEmployee hourlyEmployee3;

    @Before
    public void setUp() {
        hourlyEmployee1 = new HourlyEmployee("Billy", Date.valueOf("2014-08-16"), 32.50, 40.0);
        hourlyEmployee2 = new HourlyEmployee("Billy", Date.valueOf("2014-08-16"), 32.50, 40.0);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_sameRate_differentHours() {
        hourlyEmployee2.setHours(38.0);
        assertNotEquals(hourlyEmployee1, hourlyEmployee2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameRate_sameHours() {
        hourlyEmployee2.setName("Bobby");
        assertNotEquals(hourlyEmployee1, hourlyEmployee2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameRate_sameHours() {
        hourlyEmployee2.setHireDate(Date.valueOf("2014-05-16"));
        assertNotEquals(hourlyEmployee1, hourlyEmployee2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentRate_sameHours() {
        hourlyEmployee2.setRate(28.75);
        assertNotEquals(hourlyEmployee1, hourlyEmployee2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(hourlyEmployee1, hourlyEmployee2);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(325, hourlyEmployee1.payTaxes(), .001);
    }

    @Test
    public void testPay() {
        assertEquals(1300, hourlyEmployee1.pay(), .001);
    }
}