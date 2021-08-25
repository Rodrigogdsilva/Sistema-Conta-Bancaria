package contas;

import java.util.Scanner;
import org.joda.time.LocalDate;
import clientes.Cliente;

public class ContaPoupanca extends ContaBancaria {

	// Atributos
	private int rendimentoMensal;
	private int descontoCarencia;
	private int periodoCarencia;
	private int contador;
	private ContaPoupanca[] contaPoupancas = new ContaPoupanca[6];

	Scanner scan = new Scanner(System.in);

	// Construtores

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(Cliente cliente, String nomeBanco, int codigoIdentificadorBanco, int numeroConta,
			int numeroAgencia, double saldoConta, LocalDate dataAberturaConta, int rendimentoMensal,
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

	// M�todo para c�lculo do rendimento mensal da poupan�a de acordo com o dia
	// 1 de cada m�s
	public void calcularSaldoNovoComValorizacao() {

		if (LocalDate.now().dayOfMonth().equals(1)) {
			setSaldoConta(getSaldoConta() + rendimentoMensal);
		} else {
			System.out.println("Hoje n�o � o dia de rendimento! \nO seu dia de rendimento �: "
					+ super.getDataAberturaConta().getDayOfMonth() + " de cada m�s.");
		}
	}

	// Sobrescrevendo o m�todo sacar, conforme regra de neg�cio da Conta
	// Poupan�a
	@Override
	public void sacar(double valor) {

		if ((LocalDate.now().getMonthOfYear() - super.getDataAberturaConta().getMonthOfYear()) >= periodoCarencia) {

			if ((LocalDate.now().getYear() - super.getDataAberturaConta().getYear()) >= 1) {
				setSaldoConta(getSaldoConta() - valor);
				System.out.println("Saque realizado com sucesso. \nSaldo atual: " + getSaldoConta());
			}

		} else if ((LocalDate.now().getMonthOfYear()
				- super.getDataAberturaConta().getMonthOfYear()) < periodoCarencia) {

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

			}

		} else {

			System.out.println("Seu saldo � insulficiente para esta opera��o");

		}
	}

	public void imprimirQuantidadeElementosDoArray() {

		System.out.println("\nExistem " + contador + " cadastradas no nosso sistema.");

	}

	public void adicionarElementosNoArray(ContaPoupanca conta) {
		if (contador < contaPoupancas.length) {
			contaPoupancas[contador] = conta;
			contador++;
		} else {
			System.out.println("Capacidade m�xima de armazenamento atingida, n�o � poss�vel adicionar mais contas.");
		}
	}

	public void imprimirOPrimeiroElementoDoArray() {

		if (!(contaPoupancas[0].equals(null))) {
			System.out.println("\n------------------------ ");
			System.out.println(contaPoupancas[0]);
			System.out.println("------------------------");
		} else {
			System.out.println("N�o foi poss�vel exibir. \nN�o h� contas cadastradas.");
		}
	}

	public void imprimirOUltimoElementoDoArray() {

		System.out.println("\n------------------------ ");
		System.out.println(contaPoupancas[contador - 1]);
		System.out.println("------------------------");

	}

}
