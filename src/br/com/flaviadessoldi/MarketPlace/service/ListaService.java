package br.com.flaviadessoldi.MarketPlace.service;

import org.springframework.validation.annotation.Validated;

import br.com.flaviadessoldi.api.MarketPlace.model.Lista;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface ListaService {

    @NotNull Iterable<Lista> getAllLista();

    Lista create(@NotNull(message = "Lista não poder ser null.") @Valid Lista lista);

    void update(@NotNull(message = "Lista não pode ser null.") @Valid Lista lista);
}
