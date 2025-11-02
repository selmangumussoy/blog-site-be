package com.example.blogsitebe.library.utils;

import java.security.SecureRandom;
import java.util.Random;

public class Functions {
    public Functions() {
    }

    public static String generateRandomPassword() {
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            password.append(random.nextInt(10));
        }
        return password.toString();
    }
}
