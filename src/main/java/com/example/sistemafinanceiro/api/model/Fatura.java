package com.example.sistemafinanceiro.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "fatura")
public class Fatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private double  valor_total;

	@Column(nullable = false)
	private int parcelas;

	@Column(columnDefinition = "tinyint", nullable = false)
	private int faturado;
	
	@OneToMany
	private List<Transacao> transacoes = new ArrayList<>();
	
	@ManyToOne
    @JoinColumn
	private Categoria categoria;
}
