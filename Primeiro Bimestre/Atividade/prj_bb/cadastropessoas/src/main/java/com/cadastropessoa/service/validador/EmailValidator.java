package com.cadastropessoa.service.validador;

    public final class EmailValidator {

    private EmailValidator() {}

    public static boolean isValid(String email) {

        if (email == null) return false;

        String emailTratado = email.trim();

        if (emailTratado.isEmpty()) return false;

        int at = emailTratado.indexOf('@');

        if (at <= 0 || at == emailTratado.length() - 1) return false;

        int ponto = emailTratado.indexOf('.', at + 1);

        return ponto > at + 1 && ponto < emailTratado.length() - 1;
    }

    public static String normalize(String email) {

        if (email == null) return null;

        String emailTratado = email.trim().toLowerCase();

        return emailTratado.isEmpty() ? null : emailTratado;
    }
}
