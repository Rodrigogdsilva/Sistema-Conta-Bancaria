package Contas;

import org.joda.time.LocalDate;

import Clientes.TipoCliente;

public class ContaPoupanca extends ContaBancaria {

	// Atributos
	private final double rendimentoMensal = 0.02;

	// Construtores
	
	public ContaPoupanca(String nomeCliente, String numeroDocCliente, int scoreCliente, TipoCliente tipoCliente,
			String nomeBanco, int codigoIdentificadorBanco, int numeroConta, int numeroAgencia, double saldoConta,
			LocalDate dataAberturaConta) {
		super(nomeCliente, numeroDocCliente, scoreCliente, tipoCliente, nomeBanco, codigoIdentificadorBanco, numeroConta,
				numeroAgencia, saldoConta, dataAberturaConta);
	}

	// Getters e Setters
	public double getRendimentoMensal() {
		return rendimentoMensal;
	}

	// Método para cálculo do rendimento mensal da poupança de acordo com o dia
	// 1 de cada mês
	public void calcularSaldoNovoComValorizacao() {

		if (LocalDate.now().dayOfMonth().equals(1)) {
			double saldo = getSaldoConta();
			setSaldoConta(saldo = saldo * rendimentoMensal);
		} else {
			System.out.println("Hoje não é o dia de rendimento! \nO seu dia de rendimento é: "
					+ super.getDataAberturaConta().getDayOfMonth() + " de cada mês.");
		}
	}

	// Sobrescrevendo o método sacar, conforme regra de negócio da Conta
	// Poupança
	@Override
	public void sacar(double valor) {

		if (LocalDate.now().getMonthOfYear() - super.getDataAberturaConta().getMonthOfYear() >= 1) {

			if (LocalDate.now().getYear() - super.getDataAberturaConta().getYear() >= 1) {
				setSaldoConta(getSaldoConta() - valor);
				System.out.println("Saque realizado com sucesso. \nSaldo atual: " + getSaldoConta());
			}

		} else {

			if (LocalDate.now().monthOfYear().equals(getDataAberturaConta().monthOfYear())) {
				System.out.println("Não foi possível completar a operação. "
						+ "\nO tempo para saque ainda não ultrapassou 30 dias");

			} else if (getSaldoConta() < valor) {
				System.out.println("Seu saldo é insulficiente para esta operação");
			}
		}
	}
}
