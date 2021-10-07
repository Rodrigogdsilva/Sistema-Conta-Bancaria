package conta;

import java.math.BigDecimal;
import java.time.LocalDate;

import cliente.Cliente;
import servicos.Investimento;
import servicos.InvestimentoAnual;
import servicos.InvestimentoMensal;
import servicos.InvestimentoSemestral;

public abstract class ContaBancaria implements Comparable<ContaBancaria> {

	// Atributos
	private Cliente cliente;
	private String nomeBanco;
	private String codigoIdentificadorBanco;
	private String numeroConta;
	private String numeroAgencia;
	private double saldoConta;
	private LocalDate dataAberturaConta;
	private LocalDate dataFechamentoConta;
	private String motivoFechamento;
	private Investimento investimento;

	private int instance;

	// Construtores
	public ContaBancaria(Cliente cliente, String nomeBanco, String codigoIdentificadorBanco, String numeroConta,
			String numeroAgencia, double saldoConta, LocalDate dataAberturaConta, LocalDate dataFechamentoConta,
			String motivoFechamento, Investimento investimento) {
		this.cliente = cliente;
		this.nomeBanco = nomeBanco;
		this.codigoIdentificadorBanco = codigoIdentificadorBanco;
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
		this.saldoConta = saldoConta;
		this.dataAberturaConta = dataAberturaConta;
		this.dataFechamentoConta = dataFechamentoConta;
		this.motivoFechamento = motivoFechamento;
		this.investimento = investimento;
	}

	// Getters e Setters
	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getCodigoIdentificadorBanco() {
		return codigoIdentificadorBanco;
	}

	public void setCodigoIdentificadorBanco(String codigoIdentificadorBanco) {
		this.codigoIdentificadorBanco = codigoIdentificadorBanco;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}

	public LocalDate getDataAberturaConta() {
		return dataAberturaConta;
	}

	public void setDataAberturaConta(LocalDate dataAberturaConta) {
		this.dataAberturaConta = dataAberturaConta;
	}

	public LocalDate getDataFechamentoConta() {
		return dataFechamentoConta;
	}

	public void setDataFechamentoConta(LocalDate dataFechamentoConta) {
		this.dataFechamentoConta = dataFechamentoConta;
	}

	public String getMotivoFechamento() {
		return motivoFechamento;
	}

	public void setMotivoFechamento(String motivoFechamento) {
		this.motivoFechamento = motivoFechamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}

	// Método para sacar valores
	public void sacar(double valor) {

		if (motivoFechamento == null) {

			if (saldoConta >= valor) {
				saldoConta -= valor;

			} else {

				System.out.println("Impossível realizar a transação!! \nSaldo insuficiente para saque, a mesma possui: "
						+ saldoConta + " de saldo.");
			}
		} else {
			System.out.println("Conta encerrada, não é possível fazer qualquer tipo de transação.");
		}
	}

	// Método para depositar valores na conta
	public void deposito(double valor) {

		if (motivoFechamento == null) {
			saldoConta += valor;
			System.out.println(verificarSaldo());
		} else {
			System.out.println("Conta encerrada, não é possível fazer qualquer tipo de transação.");
		}
	}

	// Verifica o saldo da conta
	public String verificarSaldo() {
		return "Saldo da Conta: " + String.valueOf(saldoConta);
	}

	// Método para transferencia

	public void transferencia(ContaBancaria conta, double valor) {

		if (motivoFechamento == null) {
			if (saldoConta >= valor) {

				this.sacar(valor);

				conta.deposito(valor);

				System.out.println("Transferencia realizada com sucesso.");

			} else {

				System.out.println("Não há saldo suficiente para efetuar a transferência");
			}
		} else {
			System.out.println("Conta encerrada, não é possível fazer qualquer tipo de transação.");
		}
	}

	public void investimentoV(BigDecimal valor) {

		if (instance == 0) {
			setInvestimento(new InvestimentoMensal());
		}
		if (instance == 1) {
			setInvestimento(new InvestimentoSemestral());
		}
		if (instance == 2) {
			setInvestimento(new InvestimentoAnual());
		}

		if (saldoConta > valor.doubleValue()) {

			saldoConta -= valor.doubleValue();

			if (investimento instanceof InvestimentoMensal) {
				System.out.printf("Montante valorizado após 30 dias: R$ %.2f%n", getInvestimento().valorizacao(valor));
			} else if (investimento instanceof InvestimentoSemestral) {
				System.out.printf("Montante valorizado após 6 meses: R$ %.2f%n", getInvestimento().valorizacao(valor));
			} else {
				System.out.printf("Montante valorizado após 1 ano: R$ %.2f%n", getInvestimento().valorizacao(valor));
			}
			if (!(investimento instanceof InvestimentoAnual)) {
				instance++;
			} else {
				instance = 0;
			}
		} else {

			System.out.println("Valor a investir desejado é maior do que o saldo total da conta. ");
		}

	}

	// Implementação do toString sobrescrevendo
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Nome do Banco: " + nomeBanco + "\n");
		sb.append("Código Identificador: " + codigoIdentificadorBanco + "\n");
		sb.append("Nome do cliente: " + cliente.getNomeCliente() + "\n");
		sb.append("Numero da Agência: " + numeroAgencia + "\n");
		sb.append("Numero da Conta: " + numeroConta + "\n");
		sb.append("Saldo da Conta: " + String.format("%.2f", saldoConta) + "\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroAgencia == null) ? 0 : numeroAgencia.hashCode());
		result = prime * result + ((numeroConta == null) ? 0 : numeroConta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ContaBancaria other = (ContaBancaria) obj;
		if (numeroAgencia == null) {
			if (other.numeroAgencia != null)
				return false;
		} else if (!numeroAgencia.equals(other.numeroAgencia)) {
			return false;
		}
		if (numeroConta == null) {
			if (other.numeroConta != null) {
				return false;
			}
		} else if (!numeroConta.equals(other.numeroConta)) {
			return false;
		}
		return true;
	}

	public int compareTo(ContaBancaria conta) {

		if (this.numeroAgencia.compareTo(conta.numeroAgencia) == 0) {

			return this.numeroConta.compareTo(conta.numeroConta);

		} else {

			return this.numeroAgencia.compareTo(conta.numeroAgencia);
		}
	}
}