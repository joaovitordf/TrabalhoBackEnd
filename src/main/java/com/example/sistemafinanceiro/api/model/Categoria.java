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
@Entity(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // nullable: informa que o campo não pode ser nulo
    private String nome;

    @OneToMany
    private List<MetaCategoria> metaCategorias = new ArrayList<>();

    @OneToMany
    private List<Fatura> faturas = new ArrayList<>();

}
