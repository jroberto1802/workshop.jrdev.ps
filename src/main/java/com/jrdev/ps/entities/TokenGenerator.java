package com.jrdev.ps.entities;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TokenGenerator {
    private static final int TOKEN_LENGTH = 7;

    public static long generateUniqueToken() {
        Set<Long> generatedTokens = new HashSet<>();

        // Gera um novo token até que seja único
        while (generatedTokens.size() < Math.pow(10, TOKEN_LENGTH)) {
            long token = generateRandomToken();

            // Verifica se o token já foi gerado anteriormente
            if (!generatedTokens.contains(token)) {
                generatedTokens.add(token);
                return token;
            }
        }

        // Caso todos os tokens possíveis já tenham sido gerados
        throw new RuntimeException("Não foi possível gerar um token único.");
    }

    public static long generateRandomToken() {
        long min = 1_000_000; // Define o valor mínimo como 1,000,000
        long max = (long) Math.pow(10, TOKEN_LENGTH) - 1;
        long flag = min + new Random().nextLong() % (max - min + 1);

        if (flag < min) {
            flag = 999_999 + (flag % (max - 999_999 + 1));
        }
        
        return Math.abs(flag);
    }
}