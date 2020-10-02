package com.felipecunha.viasoft.webscrapper.controller;

import com.felipecunha.viasoft.webscrapper.controller.dto.PessoaRq;
import com.felipecunha.viasoft.webscrapper.controller.dto.PessoaRs;
import com.felipecunha.viasoft.webscrapper.model.Pessoa;
import com.felipecunha.viasoft.webscrapper.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/")
    public List<PessoaRs> findAll() {
        var pessoas = pessoaRepository.findAll();
        return pessoas
                .stream()
                .map((p) -> PessoaRs.converter(p))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PessoaRs findById(@PathVariable("id") Long id) {
        var pessoa = pessoaRepository.getOne(id);
        return PessoaRs.converter(pessoa);
    }

    @PostMapping("/")
    public void salvarPessoa(@RequestBody PessoaRq pessoa) {
        var p = new Pessoa();
        p.setNome(pessoa.getNome());
        p.setSobrenome(pessoa.getSobrenome());
        pessoaRepository.save(p);
    }
}
