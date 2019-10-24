package br.com.flaviadessoldi.MarketPlace.service;

import org.springframework.validation.annotation.Validated;

import br.com.flaviadessoldi.api.MarketPlace.model.ListaProduto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface ListaProdutoService {

    ListaProduto create(@NotNull(message = "Os Produtos da Lista não podem ser null.") @Valid ListaProduto listaProduto);
}
