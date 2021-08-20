package Contas;

import java.util.Scanner;

import org.joda.time.LocalDate;

import Clientes.TipoCliente;

public class ContaCorrente extends ContaBancaria {

	// Atributos
	final private double desconto = 13.9;
	private int quantidadeSaques;

	Scanner scan = new Scanner(System.in);

	// Construtores

	public ContaCorrente(String nomeCliente, String numeroDocCliente, int scoreCliente, TipoCliente tipoCliente,
			String nomeBanco, int codigoIdentificadorBanco, int numeroConta, int numeroAgencia, double saldoConta,
			LocalDate dataAberturaConta, TipoConta tipoConta) {
		super(nomeCliente, numeroDocCliente, scoreCliente, tipoCliente, nomeBanco, codigoIdentificadorBanco, numeroConta,
				numeroAgencia, saldoConta, dataAberturaConta, tipoConta);
	}

	// Getters e Setters
	public int getQuantidadeSaques() {
		return quantidadeSaques;
	}

	public void setQuantidadeSaques(int quantidadeSaques) {
		this.quantidadeSaques = quantidadeSaques;
	}

	public double getDesconto() {
		return desconto;
	}

	// Sobrescrição do método sacar da classe ContaBancária
	@Override
	public void sacar(double valor) {

		double saldo = getSaldoConta();

		// Caso o valor do saque seja menor que o saldo da conta e a quantidade
		// de saques seja menor que 4
		if ((saldo - valor) >= 0 & quantidadeSaques < 4) {

			saldo -= valor;

			setSaldoConta(saldo);

			quantidadeSaques++;

			System.out.println("Saque realizado com sucesso! \nNovo Saldo: " + getSaldoConta());

			// Caso o valor do saque seja menor que o saldo da conta e a
			// quantidade de saques seja maior que 4
		} else if ((saldo - valor) >= 0 & quantidadeSaques >= 4) {

			int operacao;

			System.out.println(
					"Devido a quantidade de saques mensais excedidos, será cobrada uma taxa de 2% sobre o saldo restante");
			System.out.println("Deseja realizar a operação? \n1- Sim \n2- Não");
			operacao = scan.nextInt();

			switch (operacao) {

			case 1:

				saldo -= (valor * 1.02);

				setSaldoConta(saldo);

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

	public void calcularSaldoComDesconto() {

		if (super.getDataAberturaConta().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
			super.setSaldoConta(this.getSaldoConta() - desconto);
			System.out.println(getSaldoConta());
		}
	}
}
