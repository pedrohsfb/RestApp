package br.com.original.desafio.adapter;

import br.com.original.desafio.model.Processo;
import br.com.original.desafio.representation.ProcessoRepresentation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

public class ProcessoAdapter {

    public static Processo from(ProcessoRepresentation representation) {

        if (representation != null && representation.getCnj() != null && !representation.getCnj().isEmpty()) {
            Processo processo = new Processo();
            processo.setCnj(representation.getCnj());
            processo.setAutor(representation.getAutor());
            processo.setReu(representation.getReu());
            return processo;
        }
        return null;
    }

}
