package Contas;

import org.joda.time.LocalDate;

import Clientes.TipoCliente;

public class ContaEmpresarial extends ContaBancaria {

	// Atributos
	private String nomeEmpresa;

	// Construtores
	public ContaEmpresarial(String nomeCliente, String numeroDocCliente, int scoreCliente, TipoCliente tipoCliente,
			String nomeBanco, int codigoIdentificadorBanco, int numeroConta, int numeroAgencia, double saldoConta,
			LocalDate dataAberturaConta, TipoConta tipoConta,
			String nomeEmpresa) {
		super(nomeCliente, numeroDocCliente, scoreCliente, tipoCliente, nomeBanco, codigoIdentificadorBanco, numeroConta,
				numeroAgencia, saldoConta, dataAberturaConta, tipoConta);
		this.nomeEmpresa = nomeEmpresa;
	}

	// Getters e Setters
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

}
