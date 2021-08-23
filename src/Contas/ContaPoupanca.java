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

	// M�todo para c�lculo do rendimento mensal da poupan�a de acordo com o dia
	// 1 de cada m�s
	public void calcularSaldoNovoComValorizacao() {

		if (LocalDate.now().dayOfMonth().equals(1)) {
			double saldo = getSaldoConta();
			setSaldoConta(saldo = saldo * rendimentoMensal);
		} else {
			System.out.println("Hoje n�o � o dia de rendimento! \nO seu dia de rendimento �: "
					+ super.getDataAberturaConta().getDayOfMonth() + " de cada m�s.");
		}
	}

	// Sobrescrevendo o m�todo sacar, conforme regra de neg�cio da Conta
	// Poupan�a
	@Override
	public void sacar(double valor) {

		if (LocalDate.now().getMonthOfYear() - super.getDataAberturaConta().getMonthOfYear() >= 1) {

			if (LocalDate.now().getYear() - super.getDataAberturaConta().getYear() >= 1) {
				setSaldoConta(getSaldoConta() - valor);
				System.out.println("Saque realizado com sucesso. \nSaldo atual: " + getSaldoConta());
			}

		} else {

			if (LocalDate.now().monthOfYear().equals(getDataAberturaConta().monthOfYear())) {
				System.out.println("N�o foi poss�vel completar a opera��o. "
						+ "\nO tempo para saque ainda n�o ultrapassou 30 dias");

			} else if (getSaldoConta() < valor) {
				System.out.println("Seu saldo � insulficiente para esta opera��o");
			}
		}
	}
}
