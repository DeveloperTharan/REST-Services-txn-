package com.backend.interview.utils;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class GenerateId {
    private static final String CHARACTERS = "0123456789";
    private static final int ID_LENGTH = 8;
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final Set<String> GENERATED_IDS = new HashSet<>();

    public static String generateUniqueId() {
        StringBuilder sb;
        String generatedId;

        do {
            sb = new StringBuilder(ID_LENGTH);
            for (int i = 0; i < ID_LENGTH; i++) {
                sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
            }
            generatedId = sb.toString();
        } while (GENERATED_IDS.contains(generatedId));

        GENERATED_IDS.add(generatedId);
        return generatedId;
    }
}
