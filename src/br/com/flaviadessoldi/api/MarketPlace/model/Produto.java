package br.com.flaviadessoldi.api.MarketPlace.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Informe o nome do Produto.")
    @Basic(optional = false)
    private String nome;

    private Double preco;

    
    public Produto(Long id, @NotNull(message = "Informe o nome do Produto.") String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPrice(Double preco) {
        this.preco = preco;
    }

}