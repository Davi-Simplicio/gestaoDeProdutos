package com.produtos.produtosog.service;

import com.produtos.produtosog.model.Estoque;
import com.produtos.produtosog.model.Produto;
import com.produtos.produtosog.repository.EstoqueRepository;
import com.produtos.produtosog.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.server.ExportException;
import java.util.List;
import java.util.MissingFormatArgumentException;

@AllArgsConstructor
@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public void deletar( Integer id){
        produtoRepository.deleteById(id);
    }


    public void salvar(Produto produto) throws Exception {
        if (produtoRepository.existsByNome(produto.getNome())){
            throw new Exception("Esse produto já existe no estoque");
        }
        if (produto.getQuantidadeEmEstoque()<0){
            throw new RuntimeException("Você não pode ter um estoque negativo");
        }

        produtoRepository.save(produto);

    }

    public Produto buscarUm(Integer id) {
        return produtoRepository.findById(id).get();
    }

}
