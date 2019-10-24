package br.com.flaviadessoldi.api.MarketPlace;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.flaviadessoldi.api.MarketPlace.model.Pagamento;

@SpringBootApplication
public class MarketPlaceApplication {


public static void main(String[] args) {
	
	SpringApplication.run(MarketPlaceApplication.class, args);
	
    System.out.println(Arrays.toString(" : : ".split(":")));
    Pagamento p = new Pagamento(BigDecimal.valueOf(3_000), 6, BigDecimal.valueOf(5));
    System.out.println("Valor da parcela: " + p.getValorParcela());
    System.out.println("Juros total: " + p.getValorJuros());
    System.out.println("Valor total: " + p.getValorTotal());
}

}