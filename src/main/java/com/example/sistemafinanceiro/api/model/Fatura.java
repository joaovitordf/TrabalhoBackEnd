package com.example.sistemafinanceiro.api.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Fatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private double  valor_total;
	
	private int parcelas;

	@Column(columnDefinition = "tinyint")
	private int faturado;

	@OneToMany(mappedBy = "fatura")
	private List<Transacao> transacoes = new ArrayList<>();

	@ManyToOne
	@JoinColumn(nullable = false)
	private Categoria categoria;

}
