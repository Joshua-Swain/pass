package com.acme.pass;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.*;

public class ValidationTest {
    private static Validator v;

    @BeforeClass
    public static void makeValidator() {
        v = new Validator();
    }

    @Test
    public void passTwo() {
        try {
            assertEquals(2, v.validate("ble ep"));
        }
        catch (Exception e) { e.getStackTrace(); }
    }

    @Test
    public void passThree() {
        try {
            assertEquals(3, v.validate("bleep"));
    }
        catch (Exception e) { e.getStackTrace(); }
    }

    @Test
    public void passFour() {
        try {
            assertEquals(4, v.validate("celebraterightnow"));
        }
        catch (Exception e) { e.getStackTrace(); }
    }

    @Test
    public void passFive() {
        try {
            assertEquals(5, v.validate("celbrateringhtnow44"));
        }
        catch (Exception e) { e.getStackTrace(); }
    }

    @Test
    public void passSix() {
        try {
            assertEquals(6, v.validate("Brander9"));
        }
        catch (Exception e) { e.getStackTrace(); }
    }
}
