package com.produtos.produtosog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    private Double preco;
    private Integer QuantidadeEmEstoque;
    @Column(nullable = false)
    private Date dataDeValidade;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String codigoDeBarras;
    private Double peso;
    @Column(nullable = false)
    private Double medida;
    @Column(nullable = false)
    private String fabricante;
    @Column(nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private Categoria categoria;
}
