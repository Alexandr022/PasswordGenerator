package com.lab.passwordgenerator.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class PasswordGenerator {

    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

    private static final int MIN_PASSWORD_LENGTH = 8;

    public String generatePassword(int length, boolean includeUppercase, boolean includeNumbers, boolean includeSpecial) {
        if (length < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password length should be at least " + MIN_PASSWORD_LENGTH + " characters.");
        }

        StringBuilder password = new StringBuilder();
        String allCharacters = LOWERCASE_CHARACTERS + (includeUppercase ? UPPERCASE_CHARACTERS : "")
                + (includeNumbers ? NUMERIC_CHARACTERS : "") + (includeSpecial ? SPECIAL_CHARACTERS : "");

        for (int i = 0; i < length; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(allCharacters.length());
            char randomChar = allCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}

