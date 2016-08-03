package br.com.bsparaujo.datatype;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representação de um endereço de e-mail.
 */

public final class Email {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private final String endereco;

    private Email(String endereco) {
        if (endereco == null || endereco.length() < 8) {
            throw new EmailException("O endereço de e-mail deve conter ao menos 8 caracteres.");
        }

        final Matcher matcher = Pattern.compile(EMAIL_PATTERN).matcher(endereco);
        if (!matcher.matches()) {
            throw new EmailException("O e-mail não é válido");
        }


        this.endereco = endereco;
    }

    public static Email newEmail(final String endereco) {
        return new Email(endereco);
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Email email = (Email) o;
        return Objects.equals(endereco, email.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco);
    }
}
