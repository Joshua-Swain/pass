package com.acme.pass;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Validator {

    @BeforeClass
    public void setUp(String password) {
        String lowercasePassword = new String();
        lowercasePassword = password.toLowerCase();
    }

    @Test
    public void validatePasswordStrength(String password) throws Exception {
        // Test rule 1: cannot be a case-variant of "password"
        String lowercasePassword = new String();
        lowercasePassword = password.toLowerCase();
        assertFalse(lowercasePassword.equals("password"));

        // Test rule 2: must be at least 8 characters in length
        assertTrue(password.length() > 7);

        // Test rule 3: must not contain any spaces
        assertFalse(password.matches(".*[ ].*"));

        // Test rule 4: must contain at least one digit
        assertTrue(password.matches(".*[0-9].*"));

        // Test rule 5: must be less than 33 characters
        assertTrue(password.length() < 33);

        // Test rule 6: must contain both upper-case and lower-case characters
        assertTrue(password.matches("(.*[a-z].*[A-Z].*)|(.*[A-Z].*[a-z].*)"));
    }
}