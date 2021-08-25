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
		ContaCorrente contaCorrenteArray = new ContaCorrente();
		ContaPoupanca contaPoupancaArray = new ContaPoupanca();
		ContaEmpresarial contaEmpresarialArray = new ContaEmpresarial();

		// Instanciando objetos do tipo comparador
		Comparador comparator = new Comparador();

		// Instanciando os clientes
		Cliente cliente1 = new Cliente("Rodrigo", "111.111.111-11", 500, TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente2 = new Cliente("José", "222.222.222-22", 300, TipoCliente.PESSOA_FISICA);
		Cliente cliente3 = new Cliente("Julio Cesar", "333.333.333-33", 600, TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente4 = new Cliente("Valentina", "444.444.444-44", 900, TipoCliente.FUNCIONARIO_BANCO);
		Cliente cliente5 = new Cliente("Breno", "555.555.555-55", 750, TipoCliente.PESSOA_FISICA);
		Cliente cliente6 = new Cliente("Caio", "666.666.666-66", 537, TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente7 = new Cliente("Florisvaldo", "777.777.777-77", 495, TipoCliente.PESSOA_JURIDICA);
		Cliente cliente8 = new Cliente("Augusto", "888.888.888-88", 237, TipoCliente.PESSOA_JURIDICA);
		Cliente cliente9 = new Cliente("Vanessa", "999.999.999-99", 623, TipoCliente.PESSOA_JURIDICA);
		Cliente cliente10 = new Cliente("Rodrigo", "111.111.111-11", 500, TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente11 = new Cliente("Francisco", "111.111.111-12", 685, TipoCliente.FUNCIONARIO_BANCO);
		Cliente cliente12 = new Cliente("Paulo", "111.111.111-13", 323, TipoCliente.PESSOA_FISICA);
		Cliente cliente13 = new Cliente("Raimundo", "111.111.111-14", 143, TipoCliente.SERVIDOR_PUBLICO);
		Cliente cliente14 = new Cliente("Josefa", "111.111.111-15", 268, TipoCliente.FUNCIONARIO_BANCO);
		Cliente cliente15 = new Cliente("Joaquim", "111.111.111-16", 482, TipoCliente.PESSOA_FISICA);
		Cliente cliente16 = new Cliente("Sônia", "111.111.111-17", 198, TipoCliente.FUNCIONARIO_BANCO);
		Cliente cliente17 = new Cliente("Benedito", "111.111.111-18", 851, TipoCliente.PESSOA_JURIDICA);
		Cliente cliente18 = new Cliente("Rita", "111.111.111-19", 533, TipoCliente.PESSOA_JURIDICA);
		Cliente cliente19 = new Cliente("Manoel", "111.111.111-20", 754, TipoCliente.PESSOA_JURIDICA);
		Cliente cliente20 = new Cliente("Márcia", "111.111.111-21", 621, TipoCliente.PESSOA_JURIDICA);

		// Instanciando objetos do tipo Conta Corrente
		ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "Itaú", 341, 11111, 1111, 1000.00, LocalDate.now(),
				5, 4);
		ContaCorrente contaCorrente2 = new ContaCorrente(cliente2, "Santander", 033, 22222, 2222, 500.00,
				LocalDate.now(), 10, 8);
		ContaCorrente contaCorrente3 = new ContaCorrente(cliente3, "Original", 212, 33333, 3333, 1700.00,
				LocalDate.now(), 4, 3);
		ContaCorrente contaCorrente4 = new ContaCorrente(cliente10, "Cooperativo Sicredi S.A.", 748, 11119, 1111, 74.00,
				LocalDate.now(), 6, 2);
		ContaCorrente contaCorrente5 = new ContaCorrente(cliente11, "Agibank S.A.", 121, 12347, 5206, 864.00,
				LocalDate.now(), 3, 3);
		ContaCorrente contaCorrente6 = new ContaCorrente(cliente12, "BMG S.A.", 318, 96572, 3209, 5327.65,
				LocalDate.now(), 10, 7);
		ContaCorrente contaCorrente7 = new ContaCorrente(cliente13, "Cargill S.A", 040, 32687, 3685, 3561.96,
				LocalDate.now(), 6, 4);

		// Instanciando objetos do tipo Conta Corrente
		ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente4, "Banco do Brasil", 756, 44444, 4444, 3400.00,
				LocalDate.now(), 150, 135, 1);
		ContaPoupanca contaPoupanca2 = new ContaPoupanca(cliente5, "Votorantim", 655, 55555, 5555, 1238.75,
				LocalDate.now(), 300, 200, 2);
		ContaPoupanca contaPoupanca3 = new ContaPoupanca(cliente6, "Bradesco S.A", 237, 66666, 6666, 357.79,
				LocalDate.now(), 127, 50, 3);
		ContaPoupanca contaPoupanca4 = new ContaPoupanca(cliente14, "Itaú", 341, 11111, 1111, 1000.00, LocalDate.now(),
				300, 75, 4);
		ContaPoupanca contaPoupanca5 = new ContaPoupanca(cliente15, "Citibank S.A.", 745, 83647, 2196, 7462.99,
				LocalDate.now(), 247, 400, 2);
		ContaPoupanca contaPoupanca6 = new ContaPoupanca(cliente16, "Daycoval S.A.", 707, 85324, 3695, 2534.50,
				LocalDate.now(), 500, 1000, 6);

		// Instanciando objetos do tipo Conta Empresarial
		ContaEmpresarial contaEmpresarial1 = new ContaEmpresarial(cliente7, "Inter S.A", 077, 77777, 7777, 1103.03,
				LocalDate.now(), "Ambev");
		ContaEmpresarial contaEmpresarial2 = new ContaEmpresarial(cliente8, "Caixa Econômica Federal", 104, 88888, 8888,
				135.01, LocalDate.now(), "JBS");
		ContaEmpresarial contaEmpresarial3 = new ContaEmpresarial(cliente9, "Banco Safra S.A", 422, 99999, 9999,
				4922.01, LocalDate.now(), "TAM");
		ContaEmpresarial contaEmpresarial4 = new ContaEmpresarial(cliente17, "Smartbank S.A.", 630, 86254, 6358,
				9838.22, LocalDate.now(), "Pão de Açúcar");
		ContaEmpresarial contaEmpresarial5 = new ContaEmpresarial(cliente18, "Western Union do Brasil S.A.", 119, 83265,
				1865, 15025.72, LocalDate.now(), "Microsoft");
		ContaEmpresarial contaEmpresarial6 = new ContaEmpresarial(cliente19, "Xp S/A", 348, 36825, 9352, 7563.81,
				LocalDate.now(), "Sabesp");
		ContaEmpresarial contaEmpresarial7 = new ContaEmpresarial(cliente20, "Magliano S.A", 113, 23856, 7562, 6352.76,
				LocalDate.now(), "Nextel");

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

		contaCorrenteArray.adicionarElementosNoArray(contaCorrente1);
		contaCorrenteArray.adicionarElementosNoArray(contaCorrente2);
		contaCorrenteArray.adicionarElementosNoArray(contaCorrente3);
		contaCorrenteArray.adicionarElementosNoArray(contaCorrente4);
		contaCorrenteArray.adicionarElementosNoArray(contaCorrente5);
		contaCorrenteArray.adicionarElementosNoArray(contaCorrente6);
		contaCorrenteArray.adicionarElementosNoArray(contaCorrente7);

		contaCorrenteArray.imprimirOPrimeiroElementoDoArray();
		contaCorrenteArray.imprimirOUltimoElementoDoArray();
		contaCorrenteArray.imprimirQuantidadeElementosDoArray();

		contaPoupancaArray.adicionarElementosNoArray(contaPoupanca1);
		contaPoupancaArray.adicionarElementosNoArray(contaPoupanca2);
		contaPoupancaArray.adicionarElementosNoArray(contaPoupanca3);
		contaPoupancaArray.adicionarElementosNoArray(contaPoupanca4);
		contaPoupancaArray.adicionarElementosNoArray(contaPoupanca5);
		contaPoupancaArray.adicionarElementosNoArray(contaPoupanca6);

		contaPoupancaArray.imprimirOPrimeiroElementoDoArray();
		contaPoupancaArray.imprimirOUltimoElementoDoArray();
		contaPoupancaArray.imprimirQuantidadeElementosDoArray();

		contaEmpresarialArray.adicionarElementosNoArray(contaEmpresarial1);
		contaEmpresarialArray.adicionarElementosNoArray(contaEmpresarial2);
		contaEmpresarialArray.adicionarElementosNoArray(contaEmpresarial3);
		contaEmpresarialArray.adicionarElementosNoArray(contaEmpresarial4);
		contaEmpresarialArray.adicionarElementosNoArray(contaEmpresarial5);
		contaEmpresarialArray.adicionarElementosNoArray(contaEmpresarial6);
		contaEmpresarialArray.adicionarElementosNoArray(contaEmpresarial7);

		contaEmpresarialArray.imprimirOPrimeiroElementoDoArray();
		contaEmpresarialArray.imprimirOUltimoElementoDoArray();
		contaEmpresarialArray.imprimirQuantidadeElementosDoArray();

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

	/*
	 * public static void imprimirQuantidadeElementosDoArray(ContaBancaria...
	 * conta) {
	 * 
	 * System.out.println("\nO Array possui " + Stream.of(conta).count() +
	 * " elementos \n");
	 * 
	 * }
	 * 
	 * public static void imprimirOPrimeiroElementoDoArray(ContaBancaria...
	 * conta) {
	 * 
	 * Stream.of(conta).limit(1).forEach(System.out::println);
	 * 
	 * }
	 * 
	 * public static void imprimirOUltimoElementoDoArray(ContaBancaria... conta)
	 * {
	 * 
	 * Stream.of(conta).skip(conta.length - 1).forEach(System.out::println);
	 * 
	 * }
	 */
}
