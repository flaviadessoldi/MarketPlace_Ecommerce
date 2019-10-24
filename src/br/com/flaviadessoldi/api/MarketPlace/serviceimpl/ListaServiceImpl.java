package br.com.flaviadessoldi.api.MarketPlace.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.flaviadessoldi.MarketPlace.service.ListaService;
import br.com.flaviadessoldi.api.MarketPlace.model.Lista;
import br.com.flaviadessoldi.api.repository.ListaRepository;

import java.time.LocalDate;

@Service
@Transactional
public class ListaServiceImpl implements ListaService {

    private ListaRepository listaRepository;

    public ListaServiceImpl(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

	@Override
	public Iterable<Lista> getAllLista() {
		  return this.listaRepository.findAll();
	}

	@Override
	public Lista create(Lista lista) {
		   lista.setDataCiacao(LocalDate.now());

	        return this.listaRepository.save(lista);
	}

	@Override
	public void update(Lista lista) {
		this.listaRepository.save(lista);
		
	}
}