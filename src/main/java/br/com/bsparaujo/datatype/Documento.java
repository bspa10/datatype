package br.com.bsparaujo.datatype;

import java.util.Objects;

public final class Documento {

    private final TipoDocumento tipoDocumento;
    private final String documento;

    private Documento(final TipoDocumento tipoDocumento, final String documento) {
        if (!tipoDocumento.ehvalido(documento)){
            throw new DocumentoException("O documento " + documento + " não é um " + tipoDocumento + " válido.");
        }

        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }

    /**
     * Cria um novo documento.
     *
     * @param tipoDocumento Tipo de documento
     * @param documento Valor do documento
     * @return Documento que foi criado
     */
    public static Documento newDocumento(final TipoDocumento tipoDocumento, final String documento) {
        return new Documento(tipoDocumento, documento);
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    /**
    * Documento formatado para apresentação.
    *
    * @return Documento formatado para apresentação
    */
    public String formatado() {
        return tipoDocumento.formatar(this);
    }

    /**
     * Documento sem nenhuma formatação.
     * @return Documento sem nenhuma formatação
     */
    public String semFormato() {
        return documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento1 = (Documento) o;
        return tipoDocumento == documento1.tipoDocumento &&
                Objects.equals(documento, documento1.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumento, documento);
    }
}
