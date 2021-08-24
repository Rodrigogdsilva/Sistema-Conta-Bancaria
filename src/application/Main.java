package application;

import org.joda.time.LocalDate;
import clientes.Cliente;
import clientes.TipoCliente;
import comparadores.Comparador;
import contas.ContaBancaria;
import contas.ContaCorrente;
import contas.ContaEmpresarial;
import contas.ContaPoupanca;

public class Main {

	public static void main(String[] args) {

		// Declaração de variáveis
		String primeiraString = "Hello World";
		String segundaString = new String("Hello World");

		// Instanciando objetos do tipo comparador
		Comparador comparator = new Comparador();

		// Instanciando os clientes
		Cliente cliente1 = new Cliente("Rodrigo", "111.111.111-11", 500, TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente2 = new Cliente("José", "222.222.222-22", 300, TipoCliente.PESSOA_JURIDICA);
		Cliente cliente3 = new Cliente("Julio Cesar", "333.333.333-33", 600, TipoCliente.PESSOA_FISICA);
		Cliente cliente4 = new Cliente("Valentina", "444.444.444-44", 900, TipoCliente.FUNCIONARIO_BANCO);
		Cliente cliente5 = new Cliente("Breno", "555.555.555-55", 750, TipoCliente.PESSOA_JURIDICA);
		Cliente cliente6 = new Cliente("Caio", "666.666.666-66", 537, TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente7 = new Cliente("Florisvaldo", "777.777.777-77", 495, TipoCliente.PESSOA_FISICA);
		Cliente cliente8 = new Cliente("Augusto", "888.888.888-88", 237, TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente9 = new Cliente("Vanessa", "999.999.999-99", 623, TipoCliente.PESSOA_FISICA);
		Cliente cliente10 = new Cliente("Rodrigo", "111.111.111-11", 500, TipoCliente.SERVIDOR_PUBLICO);

		// Instanciando objetos do tipo Conta Corrente
		ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "Itaú", 341, 11111, 1111, 1000.00, LocalDate.now(),
				5, 4);
		ContaCorrente contaCorrente2 = new ContaCorrente(cliente2, "Santander", 033, 22222, 2222, 500.00,
				LocalDate.now(), 10, 8);
		ContaCorrente contaCorrente3 = new ContaCorrente(cliente3, "Original", 212, 33333, 3333, 1700.00,
				LocalDate.now(), 4, 3);

		// Instanciando objetos do tipo Conta Corrente
		ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente4, "Banco do Brasil", 756, 44444, 4444, 3400.00,
				LocalDate.now(), 150, 135, 1);
		ContaPoupanca contaPoupanca2 = new ContaPoupanca(cliente5, "Votorantim", 655, 55555, 5555, 1238.75,
				LocalDate.now(), 300, 200, 2);
		ContaPoupanca contaPoupanca3 = new ContaPoupanca(cliente6, "Bradesco S.A", 237, 66666, 6666, 357.79,
				LocalDate.now(), 127, 50, 3);
		ContaPoupanca contaPoupanca4 = new ContaPoupanca(cliente1, "Itaú", 341, 11111, 1111, 1000.00, LocalDate.now(),
				300, 75, 4);

		// Instanciando objetos do tipo Conta Empresarial
		ContaEmpresarial contaEmpresarial1 = new ContaEmpresarial(cliente7, "Inter S.A", 077, 77777, 7777, 1103.03,
				LocalDate.now(), "Ambev");
		ContaEmpresarial contaEmpresarial2 = new ContaEmpresarial(cliente8, "Caixa Econômica Federal", 104, 88888, 8888,
				135.01, LocalDate.now(), "JBS");
		ContaEmpresarial contaEmpresarial3 = new ContaEmpresarial(cliente9, "Banco Safra S.A", 422, 99999, 9999,
				4922.01, LocalDate.now(), "TAM");

		comparator.comparaNumeros(500, 500);
		comparator.comparaNumeros(1000, 237);

		comparator.comparaStringsUsandoIguais(primeiraString, segundaString);
		comparator.comparaStringsUsandoIguais(primeiraString, "Hello World");

		comparator.comparaStringsUsandoEquals(primeiraString, segundaString);
		comparator.comparaStringsUsandoEquals(primeiraString, "Hello World.");

		verificaClientesIguais(cliente1, cliente2);
		verificaClientesIguais(cliente1, cliente10);

		verificaContasIguais(contaCorrente1, contaEmpresarial2);
		verificaContasIguais(contaCorrente1, contaPoupanca4);

	}

	// Método que verifica se dois clientes são iguais de acordo com o número de
	// documento de ambos
	public static boolean verificaClientesIguais(Cliente primeiroCliente, Cliente segundoCliente) {

		if (primeiroCliente.getNumeroDocCliente().equals(segundoCliente.getNumeroDocCliente())) {
			System.out.println(
					"Os dois clientes inseridos tratam-se da mesma pessoa, pois possuem o mesmo número de documento");
			return true;
		} else {
			System.out.println("Clientes distintos, números de documentos divergentes.");
			return false;
		}
	}

	// Método que verifica se duas contas são iguais de acordo com o número da
	// agência e conta de ambas
	public static boolean verificaContasIguais(ContaBancaria primeiraConta, ContaBancaria segundaConta) {

		if ((primeiraConta.getNumeroAgencia() == segundaConta.getNumeroAgencia())
				&& (primeiraConta.getNumeroConta() == segundaConta.getNumeroConta())) {

			System.out.println(
					"As Contas Bancárias inseridas são iguais, pois possuem o mesmo número de agência e conta");
			return true;

		} else {
			System.out.println("Contas distintas, não possuem o mesmo número de agência e conta");
			return false;
		}
	}
}
