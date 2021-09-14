package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import clientes.Cliente;
import clientes.TipoCliente;
import contas.ContaBancaria;
import contas.ContaCorrente;

public class MainOitavoExerc�cio {
	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Rodrigo", "111.111.111-11", "500", TipoCliente.SERVIDOR_PUBLICO);

		ContaCorrente contaCorrente2 = new ContaCorrente(cliente1, "Santander", "033", "22222", "2222", 500.00,
				LocalDate.parse("2015-04-08"), null, null, 10, 8);
		ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "Ita�", "341", "11111", "1111", 1000.00,
				LocalDate.parse("2008-02-07"), LocalDate.parse("2017-03-08"), "Mudan�a de Institui��o Banc�ria", 5, 4);

		System.out.println(apareceUmaFrase(contaCorrente2));

	}

	public static String mostraFrase(ContaBancaria conta) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' YYYY");
		StringBuilder frase = new StringBuilder();

		frase.append("A/O " + conta.getCliente().getTipoCliente() + " de nome " + conta.getCliente().getNomeCliente());
		frase.append(", possuidor do documento " + conta.getCliente().getNumeroDocCliente());
		frase.append(", possui uma " + conta.getClass().getSimpleName());
		frase.append(" nesta institui��o financeira, reconhecida pelo c�digo " + conta.getCodigoIdentificadorBanco());
		frase.append(", com o valor de R$ " + String.format("%.2f", conta.getSaldoConta()));
		frase.append(" em conta em " + dtf.format(LocalDate.now()) + "\n");
		frase.append("A " + conta.getClass().getSimpleName());
		frase.append(", da ag�ncia " + conta.getNumeroAgencia());
		frase.append(", e da conta " + conta.getNumeroConta());
		frase.append(", foi aberta pelo " + conta.getCliente().getNomeCliente());
		frase.append(" na data de " + dtf.format(conta.getDataAberturaConta()));
		frase.append(", em uma unidade presencial ou por meio de algum meio de acesso digital dessa institui��o.\n");

		if (conta.getDataFechamentoConta() != null) {
			frase.append("O cliente " + conta.getCliente().getTipoCliente());
			frase.append(" encerrou sua " + conta.getClass().getSimpleName());
			frase.append(" nesta institui��o na data de " + dtf.format(conta.getDataFechamentoConta()));
			frase.append(", pelo seguinte motivo: " + conta.getMotivoFechamento() + ".");
		}

		return frase.toString();
	}

	public static String apareceUmaFrase(ContaBancaria conta) {

		String algumaFrase = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' YYYY");

		algumaFrase = ("A/O " + conta.getCliente().getTipoCliente() + " de nome " + conta.getCliente().getNomeCliente()
				+ ", possui uma " + conta.getClass().getSimpleName()
				+ " nesta institui��o financeira, reconhecida pelo c�digo " + conta.getCodigoIdentificadorBanco()
				+ ", com o valor de R$ " + String.format("%.2f", conta.getSaldoConta()) + " em conta em "
				+ dtf.format(LocalDate.now()) + "\n" + "A " + conta.getClass().getSimpleName() + ", da ag�ncia "
				+ conta.getNumeroAgencia() + ", e da conta " + conta.getNumeroConta() + ", foi aberta pelo "
				+ conta.getCliente().getNomeCliente() + " na data de " + dtf.format(conta.getDataAberturaConta())
				+ ", em uma unidade presencial ou por meio de algum meio de acesso digital dessa institui��o.\n");

		if (conta.getDataFechamentoConta() != null) {
			algumaFrase += ("O cliente " + conta.getCliente().getTipoCliente() + " encerrou sua "
					+ conta.getClass().getSimpleName() + " nesta institui��o na data de "
					+ dtf.format(conta.getDataFechamentoConta()) + ", pelo seguinte motivo: "
					+ conta.getMotivoFechamento() + ".");
		}

		return algumaFrase;
	}
}
