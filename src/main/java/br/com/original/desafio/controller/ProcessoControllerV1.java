package br.com.original.desafio.controller;

import br.com.original.desafio.adapter.ProcessoAdapter;
import br.com.original.desafio.model.Processo;
import br.com.original.desafio.repository.ProcessoRepository;
import br.com.original.desafio.representation.ProcessoRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/processos")
public class ProcessoControllerV1 {

    @Autowired
    private ProcessoRepository processoRepository;

    @GetMapping("/test")
    public String test() {
        return "RestApp V1 running!!!";
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity list() {

        List<Processo> processoList = new ArrayList<>();

        Iterable<Processo> processoIterable = processoRepository.findAll();

        processoIterable.forEach(processo -> {processoList.add(processo);});

        if (!processoList.isEmpty()) {
            return new ResponseEntity<>(processoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Processo> save(@RequestBody ProcessoRepresentation representation) {

        Processo processo = ProcessoAdapter.from(representation);

        if (processo != null) {

            processoRepository.save(processo);

            if (processo.getId() != null) {
                return new ResponseEntity<Processo>(processo, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<Processo>(new Processo(), HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody Processo processoAtualizado) {

        if (processoAtualizado != null && processoAtualizado.getId() != null && processoAtualizado.getId() > 0) {
            Optional<Processo> optionalProcesso = processoRepository.findById(processoAtualizado.getId());
            if (optionalProcesso.isPresent()) {
                Processo processo = optionalProcesso.get();
                processo.setCnj(processoAtualizado.getCnj());
                processo.setAutor(processoAtualizado.getAutor());
                processo.setReu(processoAtualizado.getReu());
                processoRepository.save(processo);
                return new ResponseEntity<Processo>(processo, HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{processoId}")
    public ResponseEntity delete(@PathVariable Long processoId) {

        if (processoId != null && processoId > 0) {
            processoRepository.deleteById(processoId);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
