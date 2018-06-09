package com.acme.pass;

public class Validator {

    public void Validator() {}

    /*
    Make each test it's own method that returns a pass/fail boolean
    Run the tests from the ExpressoTests class, and count how many pass from over there

    Make each test in Validator increment a passCount if it succeeds.
    Then return that passCount to ExpressoTests
     */


    public int validate(String password) throws Exception {
        int passCount = 0;
        // Test rule 1: cannot be a case-variant of "password"
        String lowercasePassword = new String();
        lowercasePassword = password.toLowerCase();
        if (!(lowercasePassword.equals("password"))) {
            passCount++;
        }

        // Test rule 2: must be at least 8 characters in length
        if (password.length() > 7) {
            passCount++;
        }

        // Test rule 3: must not contain any spaces
        if (!password.matches(".*[ ].*")) {
            passCount++;
        }

        // Test rule 4: must contain at least one digit
        if (password.matches(".*[0-9].*")) {
            passCount++;
        }

        // Test rule 5: must be less than 33 characters
        if (password.length() < 33) {
            passCount++;
        }

        // Test rule 6: must contain both upper-case and lower-case characters
        if (password.matches("(.*[a-z].*[A-Z].*)|(.*[A-Z].*[a-z].*)")) {
            passCount++;
        }
        return passCount;
    }
}