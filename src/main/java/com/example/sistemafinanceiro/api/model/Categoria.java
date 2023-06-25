package com.example.sistemafinanceiro.api.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false) // length: define o tamanho máximo que a coluna poderá ter, nullable: informa que o campo não pode ser nulo
    private String nome;

    // CascadeType.ALL: é usado para propagar todas as operações da entidade Categoria, orphanRemoval: especifica se a remoção órfã deve ser aplicada
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MetaCategoria> metaCategorias = new ArrayList<>();

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fatura> faturas = new ArrayList<>();
}
