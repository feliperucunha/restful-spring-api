package com.felipecunha.viasoft.webscrapper.controller;

import com.felipecunha.viasoft.webscrapper.controller.dto.PessoaRq;
import com.felipecunha.viasoft.webscrapper.controller.dto.PessoaRs;
import com.felipecunha.viasoft.webscrapper.model.Pessoa;
import com.felipecunha.viasoft.webscrapper.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;
    private Scrapper scrapper;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    //GET
    @GetMapping("/")
    public List<PessoaRs> findAll() {
        var pessoas = pessoaRepository.findAll();
        return pessoas
                .stream()
                .map((p) -> PessoaRs.converter(p))
                .collect(Collectors.toList());
    }

    //GET
    @GetMapping("/table")
    public Scrapper scrapAll() {
        return scrapper;
}

    //GET
    @GetMapping("/{id}")
    public PessoaRs findById(@PathVariable("id") Long id) {
        var pessoa = pessoaRepository.getOne(id);
        return PessoaRs.converter(pessoa);
    }

    //POST
    @PostMapping("/")
    public void salvarPessoa(@RequestBody PessoaRq pessoa) {
        var p = new Pessoa();
        p.setNome(pessoa.getNome());
        p.setSobrenome(pessoa.getSobrenome());
        pessoaRepository.save(p);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public HttpStatus apagarPessoa(@PathVariable("id") Long id) throws Exception {
         var p = pessoaRepository.findById(id);
         try {
             pessoaRepository.deleteById(id);
         } catch(Exception e) {
            throw new Exception("Pessoa não encontrada");
        }
         return HttpStatus.OK;

    }

    //PUT
    @PutMapping("/{id}")
    public void atualizarPessoa(@PathVariable("id") Long id, @RequestBody PessoaRq pessoa) throws Exception {
        var p = pessoaRepository.findById(id);

        if (p.isPresent()) {
            var pessoaSave = p.get();
            pessoaSave.setNome(pessoa.getNome());
            pessoaSave.setSobrenome(pessoa.getSobrenome());
            pessoaRepository.save(pessoaSave);
        } else {
            throw new Exception("Pessoa não encontrada");
        }
    }
}
