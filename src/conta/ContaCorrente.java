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

	// Sobrescrição do método sacar da classe ContaBancária
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
						"Devido a quantidade de saques mensais excedidos, serão cobrados R$ 5,00 adicionais sobre o valor do saque");
				System.out.println("Deseja realizar a operação? \n1 - Sim \n2 - Não");
				operacao = scan.nextInt();

				switch (operacao) {

				case 1:

					setSaldoConta(getSaldoConta() - (valor + 5));

					quantidadeSaques++;

					System.out.println("Saque realizado com sucesso! \nNovo Saldo: " + getSaldoConta());

					break;

				case 2:

					System.out.println("Operação cancelada conforme solicitado pelo usuário");

					break;
				}

				// Caso o valor do saque seja maior que o valor da conta
			} else {

				System.out.println("Impossível realizar a transação!! \nSaldo insuficiente para saque, a mesma possui: "
						+ getSaldoConta() + " de saldo.");
			}
		} else {
			System.out.println("Conta encerrada, não é possível fazer qualquer tipo de transação.");
		}
	}

	// Calcula o novo saldo para verificar se deve ser efetuado o desconto de
	// 13,9 relacionado a tarifa bancária
	public void calcularSaldoComDesconto() {

		if (getMotivoFechamento() == null) {

			if (getDataAberturaConta().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
				setSaldoConta(getSaldoConta() - desconto);
				System.out.println(getSaldoConta());
			}
		} else {
			System.out.println("Conta encerrada, não é possível fazer qualquer tipo de transação.");
		}
	}

	// Sobrescrição do método para transferencia bancária entre contas,
	// aplicando a regra de negócio de conta corrente
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
						"Devido a quantidade de transferências mensais excedidas, será cobrado R$ 5,00 a mais sobre o valor do saque");
				System.out.println("Deseja realizar a operação? \n1- Sim \n2- Não");
				operacao = scan.nextInt();

				switch (operacao) {

				case 1:

					setSaldoConta(getSaldoConta() - (valor + 5));

					quantidadeSaques++;

					System.out.println("Transferência realizada com sucesso! \nNovo Saldo: " + getSaldoConta());

					break;

				case 2:

					System.out.println("Operação cancelada conforme solicitado pelo usuário");

					break;
				}

			} else {

				System.out.println("Não há saldo suficiente para efetuar a transferência");

			}
		} else {
			System.out.println("Conta encerrada, não é possível fazer qualquer tipo de transação.");
		}
	}
}
