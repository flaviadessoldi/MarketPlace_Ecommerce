package br.com.flaviadessoldi.api.MarketPlace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ListaProduto {

    @EmbeddedId
    @JsonIgnore
    private ListaProdutoPK pk;

    @Column(nullable = false) private Integer quantidade;

    public ListaProduto() {
        super();
    }

    public ListaProduto(Lista lista, Produto produto, Integer quantidade) {
        pk = new ListaProdutoPK();
        pk.setLista(lista);
        pk.setProduto(produto);
        this.quantidade = quantidade;
    }

    @java.beans.Transient
    public Produto getProduto() {
        return this.pk.getProduto();
    }

    @java.beans.Transient
    public Double getPrecoProduto() {
        return getProduto().getPreco() * getQuantidade();
    }

    public ListaProdutoPK getPk() {
        return pk;
    }

    public void setPk(ListaProdutoPK pk) {
        this.pk = pk;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ListaProduto other = (ListaProduto) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }

        return true;
    }
}