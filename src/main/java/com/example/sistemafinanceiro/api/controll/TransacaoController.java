package com.example.sistemafinanceiro.api.controll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemafinanceiro.api.model.Transacao;
import com.example.sistemafinanceiro.api.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacaos")
public class TransacaoController {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Transacao> listar(){
		return transacaoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transacao> buscar(@PathVariable Long id) {
		Optional<Transacao> c = transacaoRepository.findById(id);
		if (c.isPresent())
			return ResponseEntity.ok(c.get());

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Transacao salvar(@RequestBody Transacao transacao) {
		return transacaoRepository.save(transacao);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Transacao> remover(@PathVariable Long id) {
		try {
			Optional<Transacao> c = transacaoRepository.findById(id);
			if (c.isPresent()) {
				transacaoRepository.deleteById(id);
				return ResponseEntity.noContent().build();
			}
			
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Transacao> atualizar(@PathVariable Long id, @RequestBody Transacao transacao) {
		Optional<Transacao> transacaoAtual = transacaoRepository.findById(id);
		if (transacaoAtual.isPresent()) {
			BeanUtils.copyProperties(transacao, transacaoAtual.get(), "id");
			Transacao transacaoA = transacaoRepository.save(transacaoAtual.get());
			return ResponseEntity.ok(transacaoA);
		}
		
		return ResponseEntity.notFound().build();
	}
}
