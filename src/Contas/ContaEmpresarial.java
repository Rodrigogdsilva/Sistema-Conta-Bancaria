package contas;

import org.joda.time.LocalDate;
import clientes.Cliente;

public class ContaEmpresarial extends ContaBancaria {

	// Atributos
	private String nomeEmpresa;
	private ContaEmpresarial[] contaEmpresarials = new ContaEmpresarial[7];
	private int contador;

	// Construtores

	public ContaEmpresarial() {
		super();
	}

	public ContaEmpresarial(Cliente cliente, String nomeBanco, int codigoIdentificadorBanco, int numeroConta,
			int numeroAgencia, double saldoConta, LocalDate dataAberturaConta, String nomeEmpresa) {
		super(cliente, nomeBanco, codigoIdentificadorBanco, numeroConta, numeroAgencia, saldoConta, dataAberturaConta);
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
		sb.append("---------Extrato---------\n");
		sb.append("Nome do Banco: " + getNomeBanco() + "\n");
		sb.append("Código Identificador: " + getCodigoIdentificadorBanco() + "\n");
		sb.append("Nome da Empresa: " + getNomeEmpresa() + "\n");
		sb.append("Nome do cliente: " + getCliente().getNomeCliente() + "\n");
		sb.append("Numero da Conta: " + getNumeroConta() + "\n");
		sb.append("Numero da Agência: " + getNumeroAgencia() + "\n");
		sb.append("Saldo da Conta: " + String.format("%.2f", getSaldoConta()) + "\n");
		return sb.toString();
	}

	public void imprimirQuantidadeElementosDoArray() {

		System.out.println("\nExistem " + contador + " cadastradas no nosso sistema.");

	}

	public void adicionarElementosNoArray(ContaEmpresarial conta) {
		if (contador < contaEmpresarials.length) {
			contaEmpresarials[contador] = conta;
			contador++;
		} else {
			System.out.println("Capacidade máxima de armazenamento atingida, não é possível adicionar mais contas.");
		}
	}

	public void imprimirOPrimeiroElementoDoArray() {

		if (!(contaEmpresarials[0].equals(null))) {
			System.out.println("\n------------------------ ");
			System.out.println(contaEmpresarials[0]);
			System.out.println("------------------------");
		} else {
			System.out.println("Não foi possível exibir. \nNão há contas cadastradas.");
		}
	}

	public void imprimirOUltimoElementoDoArray() {

		System.out.println("\n------------------------ ");
		System.out.println(contaEmpresarials[contador - 1]);
		System.out.println("------------------------");

	}
}
