package com.controlle.notebooks.Service;

import java.security.SecureRandom;

public class S_GeratorSenha {
    public static String gerarSenha() {
        SecureRandom random = new SecureRandom();

        // Caracteres permitidos para letras, números e especiais
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String especiais = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        // Inicializa um StringBuilder para construir a senha
        StringBuilder senhaBuilder = new StringBuilder();

        // Gera 5 letras aleatoriamente
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(letras.length());
            senhaBuilder.append(letras.charAt(index));
        }

        // Gera 3 números aleatoriamente
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(numeros.length());
            senhaBuilder.append(numeros.charAt(index));
        }

        // Gera 2 caracteres especiais aleatoriamente
        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(especiais.length());
            senhaBuilder.append(especiais.charAt(index));
        }

        // Embaralha a senha para torná-la mais aleatória
        String senha = senhaBuilder.toString();
        char[] senhaArray = senha.toCharArray();
        for (int i = senhaArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = senhaArray[index];
            senhaArray[index] = senhaArray[i];
            senhaArray[i] = temp;
        }
        return senha;
    }
}
