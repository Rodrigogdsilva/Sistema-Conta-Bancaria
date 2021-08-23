package Contas;

import org.joda.time.LocalDate;

import Clientes.TipoCliente;

public class ContaEmpresarial extends ContaBancaria {

	// Atributos
	private String nomeEmpresa;

	// Construtores
	public ContaEmpresarial(String nomeCliente, String numeroDocCliente, int scoreCliente, TipoCliente tipoCliente,
			String nomeBanco, int codigoIdentificadorBanco, int numeroConta, int numeroAgencia, double saldoConta,
			LocalDate dataAberturaConta, String nomeEmpresa) {
		super(nomeCliente, numeroDocCliente, scoreCliente, tipoCliente, nomeBanco, codigoIdentificadorBanco, numeroConta,
				numeroAgencia, saldoConta, dataAberturaConta);
		this.nomeEmpresa = nomeEmpresa;
	}

	// Getters e Setters
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	@Override
	public String emitirExtrato(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("---------Extrato---------\n");
		sb.append("Nome do Banco: " + getNomeBanco() + "\n");
		sb.append("Código Identificador: " + getCodigoIdentificadorBanco() + "\n");
		sb.append("Nome da Empresa: " + getNomeEmpresa() + "\n");
		sb.append("Nome do cliente: " + getNomeCliente() + "\n");
		sb.append("Numero da Conta: " + getNumeroConta() + "\n");
		sb.append("Numero da Agência: " + getNumeroAgencia() + "\n");
		sb.append("Saldo da Conta: " + String.format("%.2f", getSaldoConta()) + "\n");
		System.out.println(sb);
		return sb.toString();
		
	}
}
