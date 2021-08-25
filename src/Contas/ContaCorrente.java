package contas;

import java.util.Scanner;
import org.joda.time.LocalDate;
import clientes.Cliente;

public class ContaCorrente extends ContaBancaria {

	// Atributos
	final private double desconto = 13.9;
	private int quantidadeSaques;
	private int quantidadeTransferencias;
	private int quantidadeMaximaSaques;
	private int quantidadeMaximaTransferencias;
	private int contador;
	private ContaCorrente[] contaCorrentes = new ContaCorrente[7];

	Scanner scan = new Scanner(System.in);

	// Construtores

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(Cliente cliente, String nomeBanco, int codigoIdentificadorBanco, int numeroConta,
			int numeroAgencia, double saldoConta, LocalDate dataAberturaConta, int quantidadeMaximaSaques,
			int quantidadeMaximaTransferencias) {
		super(cliente, nomeBanco, codigoIdentificadorBanco, numeroConta, numeroAgencia, saldoConta, dataAberturaConta);
		this.quantidadeMaximaSaques = quantidadeMaximaSaques;
		this.quantidadeMaximaTransferencias = quantidadeMaximaTransferencias;
	}

	// Getters e Setters
	public int getQuantidadeSaques() {
		return quantidadeSaques;
	}

	public double getDesconto() {
		return desconto;
	}

	public double getQuantidadeTransferencias() {
		return quantidadeTransferencias;
	}

	public int getQuantidadeMaximaSaques() {
		return quantidadeMaximaSaques;
	}

	public void setQuantidadeMaximaSaques(int quantidadeMaximaSaques) {
		this.quantidadeMaximaSaques = quantidadeMaximaSaques;
	}

	public int getQuantidadeMaximaTransferencias() {
		return quantidadeMaximaTransferencias;
	}

	public void setQuantidadeMaximaTransferencias(int quantidadeMaximaTransferencias) {
		this.quantidadeMaximaTransferencias = quantidadeMaximaTransferencias;
	}

	// Sobrescri��o do m�todo sacar da classe ContaBanc�ria
	@Override
	public void sacar(double valor) {

		// Caso o valor do saque seja menor que o saldo da conta e a quantidade
		// de saques seja menor que 4
		if (valor <= getSaldoConta() && quantidadeSaques < quantidadeMaximaSaques) {

			setSaldoConta(getSaldoConta() - valor);

			quantidadeSaques++;

			System.out.println("Saque realizado com sucesso! \nNovo Saldo: " + getSaldoConta());

			// Caso o valor do saque seja menor que o saldo da conta e a
			// quantidade de saques seja maior que 4
		} else if (valor <= getSaldoConta() && quantidadeSaques >= quantidadeMaximaSaques) {

			int operacao;

			System.out.println(
					"Devido a quantidade de saques mensais excedidos, ser�o cobrados R$ 5,00 adicionais sobre o valor do saque");
			System.out.println("Deseja realizar a opera��o? \n1 - Sim \n2 - N�o");
			operacao = scan.nextInt();

			switch (operacao) {

			case 1:

				setSaldoConta(getSaldoConta() - (valor + 5));

				quantidadeSaques++;

				System.out.println("Saque realizado com sucesso! \nNovo Saldo: " + getSaldoConta());

				break;

			case 2:

				System.out.println("Opera��o cancelada conforme solicitado pelo usu�rio");

				break;
			}

			// Caso o valor do saque seja maior que o valor da conta
		} else {

			System.out.println("Imposs�vel realizar a transa��o!! \nSaldo insuficiente para saque, a mesma possui: "
					+ getSaldoConta() + " de saldo.");
		}
	}

	// Calcula o novo saldo para verificar se deve ser efetuado o desconto de
	// 13,9 relacionado a tarifa banc�ria
	public void calcularSaldoComDesconto() {

		if (super.getDataAberturaConta().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
			super.setSaldoConta(this.getSaldoConta() - desconto);
			System.out.println(getSaldoConta());
		}
	}

	// Sobrescri��o do m�todo para transferencia banc�ria entre contas,
	// aplicando a regra de neg�cio de conta corrente
	@Override
	public void transferencia(ContaBancaria conta, double valor) {

		if (valor <= getSaldoConta() && quantidadeTransferencias < quantidadeMaximaTransferencias) {

			this.sacar(valor);

			conta.deposito(valor);

			System.out.println("Transferencia realizada com sucesso.");

			quantidadeTransferencias++;

		} else if (getSaldoConta() <= valor && quantidadeTransferencias >= quantidadeMaximaTransferencias) {

			int operacao;

			System.out.println(
					"Devido a quantidade de transfer�ncias mensais excedidas, ser� cobrado R$ 5,00 a mais sobre o valor do saque");
			System.out.println("Deseja realizar a opera��o? \n1- Sim \n2- N�o");
			operacao = scan.nextInt();

			switch (operacao) {

			case 1:

				setSaldoConta(getSaldoConta() - (valor + 5));

				quantidadeSaques++;

				System.out.println("Transfer�ncia realizada com sucesso! \nNovo Saldo: " + getSaldoConta());

				break;

			case 2:

				System.out.println("Opera��o cancelada conforme solicitado pelo usu�rio");

				break;
			}

		} else {

			System.out.println("N�o h� saldo suficiente para efetuar a transfer�ncia");

		}
	}

	public void imprimirQuantidadeElementosDoArray() {

		System.out.println("\nExistem " + contador + " cadastradas no nosso sistema.");

	}

	public void adicionarElementosNoArray(ContaCorrente conta) {
		if (contador < contaCorrentes.length) {
			contaCorrentes[contador] = conta;
			contador++;
		} else {
			System.out.println("Capacidade m�xima de armazenamento atingida, n�o � poss�vel adicionar mais contas.");
		}
	}

	public void imprimirOPrimeiroElementoDoArray() {

		if (!(contaCorrentes[0].equals(null))) {
			System.out.println("\n------------------------ ");
			System.out.println(contaCorrentes[0]);
			System.out.println("------------------------");
		} else {
			System.out.println("N�o foi poss�vel exibir. \nN�o h� contas cadastradas.");
		}
	}

	public void imprimirOUltimoElementoDoArray() {

		System.out.println("\n------------------------ ");
		System.out.println(contaCorrentes[contador - 1]);
		System.out.println("------------------------");

	}

}
