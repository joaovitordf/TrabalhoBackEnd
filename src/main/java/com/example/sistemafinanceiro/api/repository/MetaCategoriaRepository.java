package com.example.sistemafinanceiro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemafinanceiro.api.model.MetaCategoria;

@Repository
public interface MetaCategoriaRepository extends
JpaRepository<MetaCategoria, Long>{
	
}