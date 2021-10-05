package conta;

import java.util.Scanner;

import cliente.Cliente;
import servicos.InterfaceTaxa;

import java.time.LocalDate;

public class ContaPoupanca extends ContaBancaria implements InterfaceTaxa {

	// Atributos
	private int rendimentoMensal;
	private int descontoCarencia;
	private int periodoCarencia;
	Scanner scan = new Scanner(System.in);

	// Construtores
	public ContaPoupanca(Cliente cliente, String nomeBanco, String codigoIdentificadorBanco, String numeroConta,
			String numeroAgencia, double saldoConta, LocalDate dataAberturaConta, LocalDate dataFechamentoConta,
			String motivoFechamento, int rendimentoMensal, int descontoCarencia, int periodoCarencia) {
		super(cliente, nomeBanco, codigoIdentificadorBanco, numeroConta, numeroAgencia, saldoConta, dataAberturaConta,
				dataFechamentoConta, motivoFechamento);
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

		if (getMotivoFechamento() == null) {

			if (LocalDate.now().getDayOfMonth() == 1) {
				setSaldoConta(getSaldoConta() + rendimentoMensal);
			} else {
				System.out.println("Hoje não é o dia de rendimento! \nO seu dia de rendimento é: "
						+ super.getDataAberturaConta().getDayOfMonth() + " de cada mês.");
			}
		} else {
			System.out.println("Conta encerrada, não é possível fazer qualquer tipo de transação.");
		}
	}

	// Sobrescrevendo o método sacar, conforme regra de negócio da Conta
	// Poupança
	@Override
	public void sacar(double valor) {

		int diferencaMeses = (LocalDate.now().getMonthValue() - super.getDataAberturaConta().getMonthValue());
		int diferencaMesesPositivos = Math.abs(diferencaMeses);

		if (getMotivoFechamento() == null) {

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

					scan.close();
				}

			} else {

				System.out.println("Seu saldo é insulficiente para esta operação");

			}
		} else {
			System.out.println("Conta encerrada, não é possível fazer qualquer tipo de transação.");
		}
	}

	public double tributacao() {

		LocalDate inicialDate = LocalDate.parse("2021-11-01");

		if (inicialDate.isBefore(LocalDate.now()) || inicialDate.equals(LocalDate.now())) {

			System.out.println("CONTA POUPANCA");
			
			double taxa = getSaldoConta() * 0.03;

			System.out.println("Saldo anterior: " + getSaldoConta());

			setSaldoConta(getSaldoConta() - taxa);

			System.out.println("Total descontado:" + taxa);

			System.out.println("Saldo atualizado: " + getSaldoConta());

			return taxa;

		} else {

			System.out.println("Não é necessária a aplicação da taxa tributável.");

		}
		return 0;

	}
}
