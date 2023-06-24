package com.example.sistemafinanceiro.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Transacao {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double valor;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime data;
	
	private int parcela;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime data_pagamento;
	
	private String data_vencimento;
	
	@ManyToOne
    @JoinColumn(name = "fatura_id")
	private Fatura fatura;
}
