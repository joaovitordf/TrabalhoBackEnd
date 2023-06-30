package com.example.sistemafinanceiro.api.repository;

import com.example.sistemafinanceiro.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemafinanceiro.api.model.Fatura;

import java.util.List;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long>{
    List<Fatura> findByCategoria(Categoria categoria);

}
