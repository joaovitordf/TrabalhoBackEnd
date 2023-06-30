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

import com.example.sistemafinanceiro.api.model.Categoria;
import com.example.sistemafinanceiro.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
        Optional<Categoria> c = categoriaRepository.findById(id);
        if (c.isPresent())
            return ResponseEntity.ok(c.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria salvar(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> remover(@PathVariable Long id) {
        try {
            Optional<Categoria> c = categoriaRepository.findById(id);
            if (c.isPresent()) {
                categoriaRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        Optional<Categoria> categoriaAtual = categoriaRepository.findById(id);
        if (categoriaAtual.isPresent()) {
            BeanUtils.copyProperties(categoria, categoriaAtual.get(), "id");
            Categoria categoriaA = categoriaRepository.save(categoriaAtual.get());
            return ResponseEntity.ok(categoriaA);
        }

        return ResponseEntity.notFound().build();
    }
}
