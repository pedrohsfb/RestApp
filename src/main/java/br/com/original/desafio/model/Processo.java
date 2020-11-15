package br.com.original.desafio.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "processo")
public class Processo implements Serializable {

    private static final long serialVersionUID = 7494029602070601100L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cnj", length = 25, nullable = false)
    private String cnj;

    @Column(name = "autor", length = 100)
    private String autor;

    @Column(name = "reu", length = 100)
    private String reu;

    public Processo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", cnj='" + cnj + '\'' +
                ", autor='" + autor + '\'' +
                ", reu='" + reu + '\'' +
                '}';
    }
}
