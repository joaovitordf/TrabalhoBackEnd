package com.example.sistemafinanceiro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemafinanceiro.api.model.Categoria;
import com.example.sistemafinanceiro.api.model.Fatura;

@Repository
public interface FaturaRepository extends
JpaRepository<Fatura, Long>{
	
	
}