package contas;

import org.joda.time.LocalDate;
import clientes.Cliente;

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

	// Construtores
	public ContaBancaria(Cliente cliente, String nomeBanco, String codigoIdentificadorBanco, String numeroConta,
			String numeroAgencia, double saldoConta, LocalDate dataAberturaConta, LocalDate dataFechamentoConta,
			String motivoFechamento) {
		this.cliente = cliente;
		this.nomeBanco = nomeBanco;
		this.codigoIdentificadorBanco = codigoIdentificadorBanco;
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
		this.saldoConta = saldoConta;
		this.dataAberturaConta = dataAberturaConta;
		this.dataFechamentoConta = dataFechamentoConta;
		this.motivoFechamento = motivoFechamento;
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
			System.out.println("Não há conta cadastrada para este cliente");
			if (other.numeroAgencia != null)
				System.out.println("Não há conta cadastrada para este cliente");
			return false;

		} else if (!numeroAgencia.equals(other.numeroAgencia)) {

			return false;
		}
		if (numeroConta == null) {
			System.out.println("Não há conta cadastrada para este cliente");
			if (other.numeroConta != null) {
				System.out.println("Não há conta cadastrada para este cliente");
				return false;
			}
		} else if (!numeroConta.equals(other.numeroConta)) {
			System.out.println("Contas distintas, não possuem o mesmo número conta. \n");
			return false;
		}
		return true;
	}

	public int compareTo(ContaBancaria conta) {
		if (Integer.parseInt(this.numeroConta) < Integer.parseInt(conta.numeroConta)) {
			if (Integer.parseInt(this.numeroAgencia) < Integer.parseInt(conta.numeroAgencia)) {
				return -1;
			}
		}
			if (Integer.parseInt(this.numeroConta) < Integer.parseInt(conta.numeroConta)) {
				if (Integer.parseInt(this.numeroAgencia) > Integer.parseInt(conta.numeroAgencia)) {
					return 1;
				}
			}
		if (Integer.parseInt(this.numeroConta) > Integer.parseInt(conta.numeroConta)) {
			if (Integer.parseInt(this.numeroAgencia) > Integer.parseInt(conta.numeroAgencia)) {
				return 1;
			}
		}
		if (Integer.parseInt(this.numeroConta) > Integer.parseInt(conta.numeroConta)) {
			if (Integer.parseInt(this.numeroAgencia) < Integer.parseInt(conta.numeroAgencia)) {
				return -1;
			}
		}
		return 0;
	}
}