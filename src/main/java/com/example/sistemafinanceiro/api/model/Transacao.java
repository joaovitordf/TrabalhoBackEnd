package com.example.sistemafinanceiro.api.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity(name = "transacao")
public class Transacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private double valor;

	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDate data;

	@Column(nullable = false)
	private int parcela;

	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDate datapagamento;

	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDate datavencimento;
	
	@ManyToOne
    @JoinColumn
	private Fatura fatura;

	@PrePersist
	private void definir_datas() {
		LocalDateTime currentDate = LocalDateTime.now();
		datapagamento = LocalDate.from((currentDate.plusDays(30)));
		datavencimento = LocalDate.from((currentDate.plusDays(60)));
	}
}
