package contas;

import java.util.Scanner;
import org.joda.time.LocalDate;
import clientes.Cliente;

public class ContaPoupanca extends ContaBancaria {

	// Atributos
	private int rendimentoMensal;
	private int descontoCarencia;
	private int periodoCarencia;
	Scanner scan = new Scanner(System.in);

	// Construtores
	public ContaPoupanca(Cliente cliente, String nomeBanco, String codigoIdentificadorBanco, String numeroConta,
			String numeroAgencia, double saldoConta, LocalDate dataAberturaConta, int rendimentoMensal,
			int descontoCarencia, int periodoCarencia) {
		super(cliente, nomeBanco, codigoIdentificadorBanco, numeroConta, numeroAgencia, saldoConta, dataAberturaConta);
		this.rendimentoMensal = rendimentoMensal;
		this.descontoCarencia = descontoCarencia;
		this.periodoCarencia = periodoCarencia;
	}

	// Getters e Setters
	public double getRendimentoMensal() {
		return rendimentoMensal;
	}

	public int getDescontoCarencia() {
		return descontoCarencia;
	}

	public void setDescontoCarencia(int descontoCarencia) {
		this.descontoCarencia = descontoCarencia;
	}

	public int getPeriodoCarencia() {
		return periodoCarencia;
	}

	public void setPeriodoCarencia(int periodoCarencia) {
		this.periodoCarencia = periodoCarencia;
	}

	public void setRendimentoMensal(int rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}

	// Método para cálculo do rendimento mensal da poupança de acordo com o dia
	// 1 de cada mês
	public void calcularSaldoNovoComValorizacao() {

		if (LocalDate.now().dayOfMonth().equals(1)) {
			setSaldoConta(getSaldoConta() + rendimentoMensal);
		} else {
			System.out.println("Hoje não é o dia de rendimento! \nO seu dia de rendimento é: "
					+ super.getDataAberturaConta().getDayOfMonth() + " de cada mês.");
		}
	}

	// Sobrescrevendo o método sacar, conforme regra de negócio da Conta
	// Poupança
	@Override
	public void sacar(double valor) {

		int diferencaMeses = (LocalDate.now().getMonthOfYear() - super.getDataAberturaConta().getMonthOfYear());
		int diferencaMesesPositivos = Math.abs(diferencaMeses);

		if (diferencaMesesPositivos >= periodoCarencia) {
			if ((LocalDate.now().getYear() - super.getDataAberturaConta().getYear()) >= 1) {
				setSaldoConta(getSaldoConta() - valor);
				System.out.println("Saque realizado com sucesso. \nSaldo atual: " + getSaldoConta());
			}

		} else if ((diferencaMesesPositivos < periodoCarencia)) {

			if ((LocalDate.now().getYear() - super.getDataAberturaConta().getYear()) < 1) {

				System.out.println("ATENÇÃO ! \nTentativa de saque dentro do período de carência. \n "
						+ "Caso deseje prosseguir será cobrado R$ 5,00 adicional sobre o valor do saque.");

				System.out.println("Deseja realizar a operação? \n1 - Sim \n2 - Não");

				int operacao;

				operacao = scan.nextInt();

				switch (operacao) {

				case 1:

					setSaldoConta(getSaldoConta() - (valor + 5));

					System.out.println("Saque realizado com sucesso! \nNovo Saldo: " + getSaldoConta());

					break;

				case 2:

					System.out.println("Operação cancelada conforme solicitado pelo usuário");

					break;
				}
			}

		} else {

			System.out.println("Seu saldo é insulficiente para esta operação");

		}
	}
}
