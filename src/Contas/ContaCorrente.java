package Contas;

import java.util.Scanner;

import org.joda.time.LocalDate;

import Clientes.TipoCliente;

public class ContaCorrente extends ContaBancaria {

	// Atributos
	final private double desconto = 13.9;
	private int quantidadeSaques;
	private int quantidadeTransferencias;

	Scanner scan = new Scanner(System.in);

	// Construtores

	public ContaCorrente(String nomeCliente, String numeroDocCliente, int scoreCliente, TipoCliente tipoCliente,
			String nomeBanco, int codigoIdentificadorBanco, int numeroConta, int numeroAgencia, double saldoConta,
			LocalDate dataAberturaConta) {
		super(nomeCliente, numeroDocCliente, scoreCliente, tipoCliente, nomeBanco, codigoIdentificadorBanco,
				numeroConta, numeroAgencia, saldoConta, dataAberturaConta);
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

	// Sobrescrição do método sacar da classe ContaBancária
	@Override
	public void sacar(double valor) {

		// Caso o valor do saque seja menor que o saldo da conta e a quantidade
		// de saques seja menor que 4
		if (valor <= getSaldoConta() & quantidadeSaques < 4) {

			setSaldoConta(getSaldoConta() - valor);

			quantidadeSaques++;

			System.out.println("Saque realizado com sucesso! \nNovo Saldo: " + getSaldoConta());

			// Caso o valor do saque seja menor que o saldo da conta e a
			// quantidade de saques seja maior que 4
		} else if (valor <= getSaldoConta() & quantidadeSaques >= 4) {

			int operacao;

			System.out.println(
					"Devido a quantidade de saques mensais excedidos, será cobrada uma taxa de 2% sobre o saldo restante");
			System.out.println("Deseja realizar a operação? \n1- Sim \n2- Não");
			operacao = scan.nextInt();

			switch (operacao) {

			case 1:

				setSaldoConta(getSaldoConta() - (valor * 1.02));

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
	}

	// Calcula o novo saldo para verificar se deve ser efetuado o desconto de
	// 13,9 relacionado a tarifa bancária
	public void calcularSaldoComDesconto() {

		if (super.getDataAberturaConta().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
			super.setSaldoConta(this.getSaldoConta() - desconto);
			System.out.println(getSaldoConta());
		}
	}

	// Sobrescrição do método para transferencia bancária entre contas,
	// aplicando a regra de negócio de conta corrente
	@Override
	public void transferencia(ContaBancaria conta, double valor) {

		if (getSaldoConta() >= valor && quantidadeTransferencias < 4) {

			this.sacar(valor);

			conta.deposito(valor);

			System.out.println("Transferencia realizada com sucesso.");

			quantidadeTransferencias++;

		} else if (getSaldoConta() < valor) {

			System.out.println("Não há saldo suficiente para efetuar a transferência");

		} else if (quantidadeTransferencias >= 4) {

			System.out.println(
					"Você já atingiu o limite mensal de transferências! \nNão foi possível efetuar a operação.");

		}
	}
}
