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

	// M�todo para c�lculo do rendimento mensal da poupan�a de acordo com o dia
	// 1 de cada m�s
	public void calcularSaldoNovoComValorizacao() {

		if (getMotivoFechamento() == null) {

			if (LocalDate.now().getDayOfMonth() == 1) {
				setSaldoConta(getSaldoConta() + rendimentoMensal);
			} else {
				System.out.println("Hoje n�o � o dia de rendimento! \nO seu dia de rendimento �: "
						+ super.getDataAberturaConta().getDayOfMonth() + " de cada m�s.");
			}
		} else {
			System.out.println("Conta encerrada, n�o � poss�vel fazer qualquer tipo de transa��o.");
		}
	}

	// Sobrescrevendo o m�todo sacar, conforme regra de neg�cio da Conta
	// Poupan�a
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

					System.out.println("ATEN��O ! \nTentativa de saque dentro do per�odo de car�ncia. \n "
							+ "Caso deseje prosseguir ser� cobrado R$ 5,00 adicional sobre o valor do saque.");

					System.out.println("Deseja realizar a opera��o? \n1 - Sim \n2 - N�o");

					int operacao;

					operacao = scan.nextInt();

					switch (operacao) {

					case 1:

						setSaldoConta(getSaldoConta() - (valor + 5));

						System.out.println("Saque realizado com sucesso! \nNovo Saldo: " + getSaldoConta());

						break;

					case 2:

						System.out.println("Opera��o cancelada conforme solicitado pelo usu�rio");

						break;
					}

					scan.close();
				}

			} else {

				System.out.println("Seu saldo � insulficiente para esta opera��o");

			}
		} else {
			System.out.println("Conta encerrada, n�o � poss�vel fazer qualquer tipo de transa��o.");
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

			System.out.println("N�o � necess�ria a aplica��o da taxa tribut�vel.");

		}
		return 0;

	}
}
