package application;

import java.time.LocalDate;

import cliente.Cliente;
import cliente.TipoCliente;
import conta.ContaCorrente;
import conta.ContaEmpresarial;
import conta.ContaPoupanca;

public class MainPrimeiroExercicio {

	public static void main(String[] args) {

		// Instanciando os clientes
		Cliente cliente1 = new Cliente("Rodrigo", "111.111.111-11", "500", TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente2 = new Cliente("José", "222.222.222-22", "300", TipoCliente.PESSOA_FISICA);
		Cliente cliente3 = new Cliente("Julio Cesar", "333.333.333-33", "600", TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente4 = new Cliente("Valentina", "444.444.444-44", "900", TipoCliente.FUNCIONARIO_BANCO);
		Cliente cliente5 = new Cliente("Breno", "555.555.555-55", "750", TipoCliente.PESSOA_FISICA);
		Cliente cliente6 = new Cliente("Caio", "666.666.666-66", "537", TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente7 = new Cliente("Florisvaldo", "777.777.777-77", "495", TipoCliente.PESSOA_JURIDICA);
		Cliente cliente8 = new Cliente("Augusto", "888.888.888-88", "237", TipoCliente.PESSOA_JURIDICA);
		Cliente cliente9 = new Cliente("Vanessa", "999.999.999-99", "623", TipoCliente.PESSOA_JURIDICA);

		// Instanciando objetos do tipo Conta Corrente
		ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "Itaú", "341", "11111", "1111", 1000.00,
				LocalDate.parse("2008-02-07"), LocalDate.parse("2017-03-08"), "Mudança de Instituição Bancária", 5, 4);
		ContaCorrente contaCorrente2 = new ContaCorrente(cliente2, "Santander", "033", "22222", "2222", 500.00,
				LocalDate.parse("2015-04-08"), null, null, 10, 8);
		ContaCorrente contaCorrente3 = new ContaCorrente(cliente3, "Original", "212", "33333", "3333", 1700.00,
				LocalDate.parse("2013-02-09"), null, null, 4, 3);

		// Instanciando objetos do tipo Conta Corrente
		ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente4, "Banco do Brasil", "756", "44444", "4444", 3400.00,
				LocalDate.parse("2002-09-30"), null, null, 150, 135, 1);
		ContaPoupanca contaPoupanca2 = new ContaPoupanca(cliente5, "Votorantim", "655", "55555", "5555", 1238.75,
				LocalDate.parse("2017-09-12"), null, null, 300, 200, 2);
		ContaPoupanca contaPoupanca3 = new ContaPoupanca(cliente6, "Bradesco S.A", "237", "66666", "6666", 357.79,
				LocalDate.parse("2016-12-01"), null, null, 127, 50, 3);

		// Instanciando objetos do tipo Conta Empresarial
		ContaEmpresarial contaEmpresarial1 = new ContaEmpresarial(cliente7, "Inter S.A", "077", "77777", "7777",
				1103.03, LocalDate.parse("2010-11-28"), null, null, "Ambev");
		ContaEmpresarial contaEmpresarial2 = new ContaEmpresarial(cliente8, "Caixa Econômica Federal", "104", "88888",
				"8888", 135.01, LocalDate.parse("2013-05-22"), null, null, "JBS");
		ContaEmpresarial contaEmpresarial3 = new ContaEmpresarial(cliente9, "Banco Safra S.A", "422", "99999", "9999",
				4922.01, LocalDate.parse("2007-08-17"), null, null, "TAM");

		System.out.println(contaCorrente1);
		System.out.println();
		System.out.println(contaPoupanca1);
		System.out.println();
		System.out.println(contaEmpresarial1);

	}
}
