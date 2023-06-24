package com.example.sistemafinanceiro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemafinanceiro.api.model.Transacao;

import java.util.Date;
import java.util.List;

@Repository
public interface TransacaoRepository extends
JpaRepository<Transacao, Long>{


}
