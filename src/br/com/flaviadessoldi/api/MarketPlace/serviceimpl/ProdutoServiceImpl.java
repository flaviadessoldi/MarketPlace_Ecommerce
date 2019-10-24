package br.com.flaviadessoldi.api.MarketPlace.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.flaviadessoldi.MarketPlace.service.ProdutoService;
import br.com.flaviadessoldi.api.MarketPlace.model.Produto;
import br.com.flaviadessoldi.api.repository.ProdutoRepository;
import src.br.com.flaviadessoldi.api.MarketPlace.model.Product;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Iterable<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto getProduto(long id) {
        return produtoRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
    }

    @Override
    public Produto save(Produto product) {
        return produtoRepository.save(product);
    }


}