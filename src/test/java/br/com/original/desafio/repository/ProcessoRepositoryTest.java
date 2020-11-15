package br.com.original.desafio.repository;

import br.com.original.desafio.model.Processo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProcessoRepositoryTest {

    @Autowired
    private ProcessoRepository processoRepository;

    @Test
    @Order(1)
    public void whenFindProcessoById_thenCorrect() {
        processoRepository.save(getProcesso());
        Optional<Processo> optionalProcesso = processoRepository.findById(1L);
        assertEquals(1L, optionalProcesso.get().getId());
    }

    @Test
    @Order(2)
    public void whenFindProcessoByCNJ_thenCorrect() {
        String cnj = "0000001-10.2020.8.26.0000";
        Processo processo = processoRepository.findByCnj(cnj);
        assertEquals(cnj, processo.getCnj());
    }

    @Test
    @Order(3)
    public void whenFindProcessoByAutor_thenCorrect() {
        String autor = "Autor da Silva";
        Processo processo = processoRepository.findByAutor(autor);
        assertEquals(autor, processo.getAutor());
    }

    @Test
    @Order(4)
    public void whenFindProcessoByReu_thenCorrect() {
        String reu = "Reu dos Santos";
        Processo processo = processoRepository.findByReu(reu);
        assertEquals(reu, processo.getReu());
    }

    private Processo getProcesso() {

        Processo p = new Processo();
        p.setCnj("0000001-10.2020.8.26.0000");
        p.setAutor("Autor da Silva");
        p.setReu("Reu dos Santos");
        return p;
    }

}