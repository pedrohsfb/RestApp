package br.com.original.desafio.repository;

import br.com.original.desafio.model.Processo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends CrudRepository<Processo, Long> {

    Processo findByCnj(String cnj);

    Processo findByAutor(String autor);

    Processo findByReu(String reu);

}
