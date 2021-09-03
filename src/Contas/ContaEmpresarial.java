package contas;

import org.joda.time.LocalDate;
import clientes.Cliente;

public class ContaEmpresarial extends ContaBancaria {

	// Atributos
	private String nomeEmpresa;

	// Construtores
	public ContaEmpresarial(Cliente cliente, String nomeBanco, String codigoIdentificadorBanco, String numeroConta,
			String numeroAgencia, double saldoConta, LocalDate dataAberturaConta, LocalDate dataFechamentoConta,
			String motivoFechamento, String nomeEmpresa) {
		super(cliente, nomeBanco, codigoIdentificadorBanco, numeroConta, numeroAgencia, saldoConta, dataAberturaConta,
				dataFechamentoConta, motivoFechamento);
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
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Nome do Banco: " + getNomeBanco() + "\n");
		sb.append("Código Identificador: " + getCodigoIdentificadorBanco() + "\n");
		sb.append("Nome da Empresa: " + getNomeEmpresa() + "\n");
		sb.append("Nome do cliente: " + getCliente().getNomeCliente() + "\n");
		sb.append("Numero da Agência: " + getNumeroAgencia() + "\n");
		sb.append("Numero da Conta: " + getNumeroConta() + "\n");
		sb.append("Saldo da Conta: " + String.format("%.2f", getSaldoConta()) + "\n");
		return sb.toString();
	}

	@Override
	public int compareTo(ContaBancaria conta) {
		if (Integer.parseInt(this.getNumeroConta()) < Integer.parseInt(conta.getNumeroConta())) {
			if (Integer.parseInt(this.getNumeroAgencia()) < Integer.parseInt(conta.getNumeroAgencia())) {
				return -1;
			}
		}
			if (Integer.parseInt(this.getNumeroConta()) < Integer.parseInt(conta.getNumeroConta())) {
				if (Integer.parseInt(this.getNumeroAgencia()) > Integer.parseInt(conta.getNumeroAgencia())) {
					return 1;
				}
			}
		if (Integer.parseInt(this.getNumeroConta()) > Integer.parseInt(conta.getNumeroConta())) {
			if (Integer.parseInt(this.getNumeroAgencia()) > Integer.parseInt(conta.getNumeroAgencia())) {
				return 1;
			}
		}
		if (Integer.parseInt(this.getNumeroConta()) > Integer.parseInt(conta.getNumeroConta())) {
			if (Integer.parseInt(this.getNumeroAgencia()) < Integer.parseInt(conta.getNumeroAgencia())) {
				return -1;
			}
		}

		return 0;
	}
}
