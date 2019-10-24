package br.com.flaviadessoldi.MarketPlace.service;

import org.springframework.validation.annotation.Validated;

import br.com.flaviadessoldi.api.MarketPlace.model.Produto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProdutoService {

    @NotNull Iterable<Produto> getAllProdutos();

    Produto getProduto(@Min(value = 1L, message = "ID Produto Inválido.") long id);

    Produto save(Produto produto);
}