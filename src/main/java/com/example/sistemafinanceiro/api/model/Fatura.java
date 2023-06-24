package com.example.sistemafinanceiro.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Fatura {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double  valor_total;
	
	private int parcelas;
	
	private int faturado;
	
	@OneToMany
	private List<Transacao> transacoes = new ArrayList<>();
	
	@ManyToOne
    @JoinColumn(name = "categoria_id")
	private Categoria categoria;
}
