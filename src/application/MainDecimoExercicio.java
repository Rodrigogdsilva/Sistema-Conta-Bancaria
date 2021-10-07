package application;

import java.math.BigDecimal;
import java.time.LocalDate;

import cliente.Cliente;
import cliente.TipoCliente;
import conta.ContaCorrente;
import conta.ContaEmpresarial;
import conta.ContaPoupanca;
import servicos.Investimento;
import servicos.InvestimentoAnual;

public class MainDecimoExercicio {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Rodrigo", "111.111.111-11", "500", TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente2 = new Cliente("José", "222.222.222-22", "300", TipoCliente.PESSOA_FISICA);
		Cliente cliente3 = new Cliente("Julio Cesar", "333.333.333-33", "600", TipoCliente.SERVIDOR_PUBLICO);

		ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "Itaú", "341", "11111", "1111", 1000.00,
				LocalDate.parse("2008-02-07"), LocalDate.parse("2017-03-08"), "Mudança de Instituição Bancária", 5, 4);
		ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente2, "Banco do Brasil", "756", "44444", "4444", 3400.00,
				LocalDate.parse("2002-09-30"), null, null,(Investimento) new InvestimentoAnual().valorizacao(BigDecimal.valueOf(500.00)), 150, 135, 1);
		ContaEmpresarial contaEmpresarial1 = new ContaEmpresarial(cliente3, "Inter S.A", "077", "77777", "7777",
				1103.03, LocalDate.parse("2010-11-28"), null, null, "Ambev");

		contaCorrente1.tributacao();
		contaPoupanca1.tributacao();
		
	}
}
