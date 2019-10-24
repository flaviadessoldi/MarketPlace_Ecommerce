package br.com.flaviadessoldi.api.MarketPlace.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ListaProdutoServiceImpl implements ListaProdutoService {

    private ListaProdutoRepository listaProdutoRepository;

    public ListaProdutoServiceImpl(ListaProdutoRepository listaProdutoRepository) {
        this.listaProdutoRepository = listaProdutotRepository;
    }

    @Override
    public ListaProduto create(ListaProduto listaProduto) {
        return this.listaProdutoRepository.save(listaProduto);
    }
}
