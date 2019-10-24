package br.com.flaviadessoldi.api.MarketPlace.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="orderProducts")
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy") private LocalDate dateCreated;

    @OneToMany(mappedBy = "pk.order")
    @Valid
    private List<ListaProduto> listaProdutos = new ArrayList<>();

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<ListaProduto> listaProduto = getListaProdutos();
        for (ListaProduto lp : listaProdutos) {
            sum += lp.getPrecoProduto();
        }

        return sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }


    public List<ListaProduto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ListaProduto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Transient
    public int getNumeroProdutos() {
        return this.listaProdutos.size();
    }
    
}