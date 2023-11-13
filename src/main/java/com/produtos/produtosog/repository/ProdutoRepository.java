package com.produtos.produtosog.repository;

import com.produtos.produtosog.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    Boolean existsByNome(String nome);
}
