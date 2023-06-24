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

import com.example.sistemafinanceiro.api.model.Fatura;
import com.example.sistemafinanceiro.api.repository.FaturaRepository;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
	
	@Autowired
	private FaturaRepository faturaRepository;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Fatura> listar(){
		return faturaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fatura> buscar(@PathVariable Long id) {
		Optional<Fatura> c = faturaRepository.findById(id);
		if (c.isPresent())
			return ResponseEntity.ok(c.get());

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Fatura salvar(@RequestBody Fatura fatura) {
		return faturaRepository.save(fatura);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Fatura> remover(@PathVariable Long id) {
		try {
			Optional<Fatura> c = faturaRepository.findById(id);
			if (c.isPresent()) {
				faturaRepository.deleteById(id);
				return ResponseEntity.noContent().build();
			}
			
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fatura> atualizar(@PathVariable Long id, @RequestBody Fatura fatura) {
		Optional<Fatura> faturaAtual = faturaRepository.findById(id);
		if (faturaAtual.isPresent()) {
			BeanUtils.copyProperties(fatura, faturaAtual.get(), "id");
			Fatura faturaA = faturaRepository.save(faturaAtual.get());
			return ResponseEntity.ok(faturaA);
		}
		
		return ResponseEntity.notFound().build();
	}
}
