package contas;

import org.joda.time.LocalDate;

import clientes.Cliente;
import clientes.TipoCliente;

public abstract class ContaBancaria{

	// Atributos

	private Cliente cliente;
	private String nomeBanco;
	private int codigoIdentificadorBanco;
	private int numeroConta;
	private int numeroAgencia;
	private double saldoConta;
	private LocalDate dataAberturaConta;
	private LocalDate dataFechamentoConta;
	private String motivoFechamento;

	// Construtores

	public ContaBancaria(Cliente cliente, String nomeBanco, int codigoIdentificadorBanco, 
			int numeroConta, int numeroAgencia, double saldoConta,	LocalDate dataAberturaConta) {
		this.cliente = cliente;
		this.nomeBanco = nomeBanco;
		this.codigoIdentificadorBanco = codigoIdentificadorBanco;
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
		this.saldoConta = saldoConta;
		this.dataAberturaConta = dataAberturaConta;
	}

	// Getters e Setters
	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public int getCodigoIdentificadorBanco() {
		return codigoIdentificadorBanco;
	}

	public void setCodigoIdentificadorBanco(int codigoIdentificadorBanco) {
		this.codigoIdentificadorBanco = codigoIdentificadorBanco;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
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

		if (valor > getSaldoConta()) {
			setSaldoConta(getSaldoConta() - valor);

		} else {

			System.out.println("Impossível realizar a transação!! \nSaldo insuficiente para saque, a mesma possui: "
					+ getSaldoConta() + " de saldo.");
		}
	}

	// Método para depositar valores na conta
	public void deposito(double valor) {
		setSaldoConta(getSaldoConta() + valor);
		System.out.println(verificarSaldo());
	}

	// Verifica o saldo da conta
	public String verificarSaldo() {
		return "Saldo da Conta: " + String.valueOf(getSaldoConta());
	}

	// Método para transferencia

	public void transferencia(ContaBancaria conta, double valor) {

		if (getSaldoConta() >= valor) {

			this.sacar(valor);

			conta.deposito(valor);

			System.out.println("Transferencia realizada com sucesso.");

		} else {

			System.out.println("Não há saldo suficiente para efetuar a transferência");
		}
	}

	public String emitirExtrato() {

		StringBuilder sb = new StringBuilder();
		sb.append("---------Extrato---------\n");
		sb.append("Nome do Banco: " + getNomeBanco() + "\n");
		sb.append("Código Identificador: " + getCodigoIdentificadorBanco() + "\n");
		sb.append("Nome do cliente: " + cliente.getNomeCliente() + "\n");
		sb.append("Numero da Conta: " + getNumeroConta() + "\n");
		sb.append("Numero da Agência: " + getNumeroAgencia() + "\n");
		sb.append("Saldo da Conta: " + String.format("%.2f", getSaldoConta()) + "\n");
		System.out.println(sb);
		return sb.toString();
	}
}
