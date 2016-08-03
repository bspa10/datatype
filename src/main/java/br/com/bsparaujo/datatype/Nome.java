package br.com.bsparaujo.datatype;

import java.util.Objects;

public final class Nome {
    private static final String NOME_REGEX = "^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü ]*$";

    private final String primeiro;
    private final String sobrenome;
    private final String completo;

    private Nome(final String primeiro, final String sobrenome) {
        if (primeiro == null || primeiro.trim().length() < 3 || !primeiro.trim().matches(NOME_REGEX)) {
            throw new NomeException("O primeiro nome deve ser informado.");
        }

        if (sobrenome == null || sobrenome.trim().length() < 3 || !sobrenome.trim().matches(NOME_REGEX)) {
            throw new NomeException("O sobrenome deve ser informado.");
        }

        this.primeiro = primeiro;
        this.sobrenome = sobrenome;
        completo = primeiro + " " + sobrenome;
    }

    public static Nome newNome(final String primeiro, final String ultimo) {
        return new Nome(primeiro, ultimo);
    }

    /**
     * Obtém o primeiro nome.
     */
    public String primeiro() {
        return primeiro;
    }

    /**
     * Obtém o sobrenome.
     */
    public String sobrenome() {
        return sobrenome;
    }

    /**
     * Obtém o nome completo.
     */
    public String completo() {
        return completo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Nome nome = (Nome) o;
        return Objects.equals(primeiro, nome.primeiro) &&
                Objects.equals(sobrenome, nome.sobrenome) &&
                Objects.equals(completo, nome.completo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primeiro, sobrenome, completo);
    }
}
