package br.com.flaviadessoldi.api.MarketPlace.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pagamento {
	
	private final BigDecimal valorProduto;
    private final BigDecimal valorParcelado;
    private final BigDecimal entrada;
    private final int numeroParcelas;
    private final BigDecimal taxaJuros;
    private final BigDecimal valorParcela;
    private final BigDecimal valorTotal; 
    private final BigDecimal valorJuros;

    public Pagamento(BigDecimal valorProduto, BigDecimal entrada, int numeroParcelas, BigDecimal taxaJuros) {
        if (numeroParcelas <= 0) throw new IllegalArgumentException();
        if (taxaJuros.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException();
        if (numeroParcelas >=6) {
        this.valorProduto = valorProduto;
        this.entrada = entrada;
        this.numeroParcelas = numeroParcelas;
        this.taxaJuros = taxaJuros;
        BigDecimal juros = taxaJuros.divide(100);
        this.valorParcelado = valorProduto.subtract(entrada);
        if (taxaJuros.compareTo(BigDecimal.ZERO) == 0) {
            this.valorParcela = valorParcelado.divide(BigDecimal.valueOf(numeroParcelas), 2, RoundingMode.HALF_EVEN);
        } else {
            BigDecimal potencia = juros.add(BigDecimal.ONE).pow(numeroParcelas);
            BigDecimal denominador = BigDecimal.ONE.subtract(BigDecimal.ONE.divide(potencia, 20, RoundingMode.HALF_EVEN));
            this.valorParcela = valorParcelado.multiply(juros).divide(denominador, 2, RoundingMode.HALF_EVEN);
        }
        this.valorJuros = valorParcela.multiply(BigDecimal.valueOf(numeroParcelas));
        this.valorTotal = entrada.add(valorJuros);
    }
        }


	public BigDecimal getValorBase() {
        return valorProduto;
    }
	public BigDecimal getEntrada() {
		return entrada;
	}

    public BigDecimal getValorParcelado() {
        return valorParcelado;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public BigDecimal getTaxaJuros() {
        return taxaJuros;
    }

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal getValorJuros() {
        return valorJuros;
    }
}


