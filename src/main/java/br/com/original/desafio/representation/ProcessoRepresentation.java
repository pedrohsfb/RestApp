package br.com.original.desafio.representation;

import java.io.Serializable;

public class ProcessoRepresentation implements Serializable {

    private String cnj;

    private String autor;

    private String reu;

    public ProcessoRepresentation() {}

    public String getCnj() {
        return cnj;
    }

    public void setCnj(String cnj) {
        this.cnj = cnj;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getReu() {
        return reu;
    }

    public void setReu(String reu) {
        this.reu = reu;
    }
}
