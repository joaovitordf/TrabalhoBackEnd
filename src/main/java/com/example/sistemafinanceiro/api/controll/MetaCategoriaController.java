package com.example.sistemafinanceiro.api.controll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sistemafinanceiro.api.model.MetaCategoria;
import com.example.sistemafinanceiro.api.repository.MetaCategoriaRepository;

@RestController
@RequestMapping("/metacategorias")
public class MetaCategoriaController {
	
	@Autowired
	private MetaCategoriaRepository metacategoriaRepository;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<MetaCategoria> listar(){
		return metacategoriaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MetaCategoria> buscar(@PathVariable Long id) {
		Optional<MetaCategoria> c = metacategoriaRepository.findById(id);
		if (c.isPresent())
			return ResponseEntity.ok(c.get());

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MetaCategoria salvar(@RequestBody MetaCategoria metacategoria) {
		return metacategoriaRepository.save(metacategoria);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MetaCategoria> remover(@PathVariable Long id) {
		try {
			Optional<MetaCategoria> c = metacategoriaRepository.findById(id);
			if (c.isPresent()) {
				metacategoriaRepository.deleteById(id);
				return ResponseEntity.noContent().build();
			}
			
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MetaCategoria> atualizar(@PathVariable Long id, @RequestBody MetaCategoria metacategoria) {
		Optional<MetaCategoria> metacategoriaAtual = metacategoriaRepository.findById(id);
		if (metacategoriaAtual.isPresent()) {
			BeanUtils.copyProperties(metacategoria, metacategoriaAtual.get(), "id");
			MetaCategoria metacategoriaA = metacategoriaRepository.save(metacategoriaAtual.get());
			return ResponseEntity.ok(metacategoriaA);
		}
		
		return ResponseEntity.notFound().build();
	}

}
