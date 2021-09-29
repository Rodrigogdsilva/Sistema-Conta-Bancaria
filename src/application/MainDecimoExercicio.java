package application;

import java.time.LocalDate;

import cliente.Cliente;
import cliente.TipoCliente;
import conta.ContaCorrente;
import tributacao.InterfaceTaxa;
import tributacao.Taxa;

public class MainDecimoExercicio {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Rodrigo", "111.111.111-11", "500", TipoCliente.SERVIDOR_PUBLICO);

		ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "Itaú", "341", "11111", "1111", 1000.00,
				LocalDate.parse("2008-02-07"), LocalDate.parse("2017-03-08"), "Mudança de Instituição Bancária", 5, 4);

		InterfaceTaxa interfaceTaxa = new Taxa();
		
		interfaceTaxa.tributacao(contaCorrente1);
		
	}

}
