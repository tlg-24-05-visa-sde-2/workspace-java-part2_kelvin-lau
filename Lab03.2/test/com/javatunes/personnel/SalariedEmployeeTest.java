package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    private SalariedEmployee salariedEmployee1;
    private SalariedEmployee salariedEmployee2;

    @Before
    public void setUp() {
        salariedEmployee1 = new SalariedEmployee("Logan", Date.valueOf("2014-10-03"), 1600.0);
        salariedEmployee2 = new SalariedEmployee("Logan", Date.valueOf("2014-10-03"), 1600.0);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        salariedEmployee2.setName("Lester");
        assertNotEquals(salariedEmployee1, salariedEmployee2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        salariedEmployee2.setHireDate(Date.valueOf("2014-09-03"));
        assertNotEquals(salariedEmployee1, salariedEmployee2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentSalary() {
        salariedEmployee2.setSalary(1599.0);
        assertNotEquals(salariedEmployee1, salariedEmployee2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(salariedEmployee1, salariedEmployee2);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(480, salariedEmployee1.payTaxes(), .001);
    }

    @Test
    public void testPay() {
        assertEquals(1600.0, salariedEmployee1.pay(), .001);
    }
}