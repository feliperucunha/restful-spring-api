package com.felipecunha.viasoft.webscrapper.repository;

import com.felipecunha.viasoft.webscrapper.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
