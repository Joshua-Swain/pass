package com.acme.pass;

public class Validator {

    public void Validator() {}

    public int validate(String password) throws Exception {
        int passCount = 0;

        String lowercasePassword = password.toLowerCase();
        if (!(lowercasePassword.equals("password"))) {
            passCount++;
        }

        if (password.length() > 7) {
            passCount++;
        }

        if (!password.matches(".*[ ].*")) {
            passCount++;
        }

        if (password.matches(".*[0-9].*")) {
            passCount++;
        }

        if (password.length() < 33) {
            passCount++;
        }

        if (password.matches("(.*[a-z].*[A-Z].*)|(.*[A-Z].*[a-z].*)")) {
            passCount++;
        }
        return passCount;
    }
}