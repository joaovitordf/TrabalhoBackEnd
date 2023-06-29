package com.example.sistemafinanceiro.api.controll;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemafinanceiro.api.model.Transacao;
import com.example.sistemafinanceiro.api.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

	private final TransacaoRepository transacaoRepository;

	public TransacaoController(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	@GetMapping
	public ResponseEntity<List<Transacao>> listar() {
		List<Transacao> transacoes = transacaoRepository.findAll();
		return ResponseEntity.ok(transacoes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transacao> buscar(@PathVariable Long id) {
		Optional<Transacao> optionalTransacao = transacaoRepository.findById(id);
		return optionalTransacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Transacao salvar(@RequestBody Transacao transacao) {
		return transacaoRepository.save(transacao);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Optional<Transacao> optionalTransacao = transacaoRepository.findById(id);
		if (optionalTransacao.isPresent()) {
			transacaoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Transacao> atualizar(@PathVariable Long id, @RequestBody Transacao transacao) {
		Optional<Transacao> optionalTransacao = transacaoRepository.findById(id);
		if (optionalTransacao.isPresent()) {
			Transacao transacaoAtual = optionalTransacao.get();
			BeanUtils.copyProperties(transacao, transacaoAtual, "id");
			Transacao transacaoAtualizada = transacaoRepository.save(transacaoAtual);
			return ResponseEntity.ok(transacaoAtualizada);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/proximasfaturas")
	public List<Transacao> buscarProximaFatura(
            @RequestParam("dataInicial") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial) {

        LocalDate dataFinal = dataInicial.plusDays(90);

        return transacaoRepository.findBydataBetween(dataInicial, dataFinal);
    }

	@GetMapping("/faturasvencidas")
	public List<Transacao> buscarFaturaVencida(
			@RequestParam("dataFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal) {
		LocalDate dataInicial = dataFinal.minusDays(90);

		return transacaoRepository.findBydataBetween(dataInicial, dataFinal);
	}

	@GetMapping("/faturaspendentes")
	public List<Transacao> buscarFaturasPendentes(
			@RequestParam("dataFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal) {
		LocalDate dataInicial = LocalDate.now();

		return transacaoRepository.findBydatapagamentoBetween(dataInicial, dataFinal);
	}

	@GetMapping("/pagamentosefetuados")
	public List<Transacao> buscarPagamentosEfetuados(
			@RequestParam("dataInicial") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial) {
		LocalDate dataFinal = LocalDate.now();

		return transacaoRepository.findBydatapagamentoBetween(dataInicial, dataFinal);
	}

	@GetMapping("/datasvencimento")
	public List<Transacao> buscarDatasVencimento(
			@RequestParam("dataFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal) {
		LocalDate dataInicial = LocalDate.now();

		return transacaoRepository.findBydatavencimentoBetween(dataInicial, dataFinal);
	}
}
