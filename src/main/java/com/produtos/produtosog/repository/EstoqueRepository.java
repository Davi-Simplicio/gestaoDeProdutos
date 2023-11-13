package com.produtos.produtosog.repository;

import com.produtos.produtosog.model.Estoque;
import com.produtos.produtosog.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque,Integer> {
}
