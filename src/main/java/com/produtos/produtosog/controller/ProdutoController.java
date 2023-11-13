package com.produtos.produtosog.controller;

import com.produtos.produtosog.model.Produto;
import com.produtos.produtosog.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.MissingFormatArgumentException;
import java.util.NoSuchElementException;
@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarUm(@PathVariable Integer id){
        try {
            produtoService.buscarUm(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Produto>> buscarTodos(){
        try{
            return new ResponseEntity<>(produtoService.buscarTodos(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        produtoService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto){
        try{
            produtoService.salvar(produto);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Produto> editar(@RequestBody Produto produto){
        try {
            produtoService.salvar(produto);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
