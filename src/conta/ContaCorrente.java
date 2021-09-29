package conta;

import java.util.Scanner;

import cliente.Cliente;

import java.time.LocalDate;

public class ContaCorrente extends ContaBancaria {

	// Atributos
	private final double desconto = 13.9;
	private int quantidadeSaques;
	private int quantidadeTransferencias;
	private int quantidadeMaximaSaques;
	private int quantidadeMaximaTransferencias;
	Scanner scan = new Scanner(System.in);

	// Construtores
	public ContaCorrente(Cliente cliente, String nomeBanco, String codigoIdentificadorBanco, String numeroConta,
			String numeroAgencia, double saldoConta, LocalDate dataAberturaConta, LocalDate dataFechamentoConta,
			String motivoFechamento, int quantidadeMaximaSaques, int quantidadeMaximaTransferencias) {
		super(cliente, nomeBanco, codigoIdentificadorBanco, numeroConta, numeroAgencia, saldoConta, dataAberturaConta,
				dataFechamentoConta, motivoFechamento);
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

		if (getMotivoFechamento() == null) {

			// Caso o valor do saque seja menor que o saldo da conta e a
			// quantidade
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
		} else {
			System.out.println("Conta encerrada, n�o � poss�vel fazer qualquer tipo de transa��o.");
		}
	}

	// Calcula o novo saldo para verificar se deve ser efetuado o desconto de
	// 13,9 relacionado a tarifa banc�ria
	public void calcularSaldoComDesconto() {

		if (getMotivoFechamento() == null) {

			if (getDataAberturaConta().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
				setSaldoConta(getSaldoConta() - desconto);
				System.out.println(getSaldoConta());
			}
		} else {
			System.out.println("Conta encerrada, n�o � poss�vel fazer qualquer tipo de transa��o.");
		}
	}

	// Sobrescri��o do m�todo para transferencia banc�ria entre contas,
	// aplicando a regra de neg�cio de conta corrente
	@Override
	public void transferencia(ContaBancaria conta, double valor) {

		if (getMotivoFechamento() == null) {

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
		} else {
			System.out.println("Conta encerrada, n�o � poss�vel fazer qualquer tipo de transa��o.");
		}
	}
}
