package br.com.flaviadessoldi.api.MarketPlace.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "lista")
public class ListaProdutoPK implements Serializable {

    private static final long serialVersionUID = 476151177562655457L;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "lista_id")
    private Lista lista;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((lista.getId() == null)
          ? 0
          : produto
            .getId()
            .hashCode());
        result = prime * result + ((produto.getId() == null)
          ? 0
          : produto
            .getId()
            .hashCode());

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
        ListaProdutoPK other = (ListaProdutoPK) obj;
        if (lista == null) {
            if (other.lista != null) {
                return false;
            }
        } else if (!lista.equals(other.lista)) {
            return false;
        }

        if (produto == null) {
            if (other.produto != null) {
                return false;
            }
        } else if (!produto.equals(other.produto)) {
            return false;
        }

        return true;
    }
}