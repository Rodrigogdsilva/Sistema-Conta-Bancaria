package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cliente.Cliente;
import cliente.TipoCliente;
import conta.ContaBancaria;
import conta.ContaCorrente;

public class MainOitavoExercício {
	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("Rodrigo", "111.111.111-11", "500", TipoCliente.SERVIDOR_PUBLICO);

		ContaCorrente contaCorrente2 = new ContaCorrente(cliente1, "Santander", "033", "22222", "2222", 500.00,
				LocalDate.parse("2015-04-08"), null, null, 10, 8);
		ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "Itaú", "341", "11111", "1111", 1000.00,
				LocalDate.parse("2008-02-07"), LocalDate.parse("2017-03-08"), "Mudança de Instituição Bancária", 5, 4);

		System.out.println(buildingASentenceWithString(contaCorrente2));

		System.out.println(buildingASentenceWithStringBuilder(contaCorrente2));
	}

	public static String buildingASentenceWithStringBuilder(ContaBancaria conta) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' YYYY");
		StringBuilder phraseStringBuilder = new StringBuilder();

		phraseStringBuilder.append(
				"A/O " + conta.getCliente().getTipoCliente() + " de nome " + conta.getCliente().getNomeCliente());
		phraseStringBuilder.append(", possuidor do documento " + conta.getCliente().getNumeroDocCliente());
		phraseStringBuilder.append(", possui uma " + conta.getClass().getSimpleName());
		phraseStringBuilder.append(
				" nesta instituição financeira, \nreconhecida pelo código " + conta.getCodigoIdentificadorBanco());
		phraseStringBuilder.append(", com o valor de R$ " + String.format("%.2f", conta.getSaldoConta()));
		phraseStringBuilder.append(" em conta em " + dtf.format(LocalDate.now()) + ".\n");
		phraseStringBuilder.append("\nA " + conta.getClass().getSimpleName());
		phraseStringBuilder.append(", da agência " + conta.getNumeroAgencia());
		phraseStringBuilder.append(", e da conta " + conta.getNumeroConta());
		phraseStringBuilder.append(", foi aberta pelo " + conta.getCliente().getNomeCliente());
		phraseStringBuilder.append(" na data de " + dtf.format(conta.getDataAberturaConta()));
		phraseStringBuilder.append(
				", \nem uma unidade presencial ou por meio de algum meio de acesso digital dessa instituição.\n");

		if (conta.getDataFechamentoConta() != null) {
			phraseStringBuilder.append("O cliente " + conta.getCliente().getTipoCliente());
			phraseStringBuilder.append(" encerrou sua " + conta.getClass().getSimpleName());
			phraseStringBuilder.append(" nesta instituição na data de " + dtf.format(conta.getDataFechamentoConta()));
			phraseStringBuilder.append(", pelo seguinte motivo: " + conta.getMotivoFechamento() + ".");
		}

		return phraseStringBuilder.toString();
	}

	public static String buildingASentenceWithString(ContaBancaria conta) {

		String phraseString;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' YYYY");

		phraseString = ("A/O " + conta.getCliente().getTipoCliente() + " de nome " + conta.getCliente().getNomeCliente()
				+ ", possuidor do documento " + conta.getCliente().getNumeroDocCliente() + ", possui uma "
				+ conta.getClass().getSimpleName() + " nesta instituição financeira, \nreconhecida pelo código "
				+ conta.getCodigoIdentificadorBanco() + ", com o valor de R$ "
				+ String.format("%.2f", conta.getSaldoConta()) + " em conta em " + dtf.format(LocalDate.now())
				+ ".\n\nA " + conta.getClass().getSimpleName() + ", da agência " + conta.getNumeroAgencia()
				+ ", e da conta " + conta.getNumeroConta() + ", foi aberta pelo " + conta.getCliente().getNomeCliente()
				+ " na data de " + dtf.format(conta.getDataAberturaConta())
				+ ", \nem uma unidade presencial ou por meio de algum meio de acesso digital dessa instituição.\n");

		if (conta.getDataFechamentoConta() != null) {
			phraseString += ("O cliente " + conta.getCliente().getTipoCliente() + " encerrou sua "
					+ conta.getClass().getSimpleName() + " nesta instituição na data de "
					+ dtf.format(conta.getDataFechamentoConta()) + ", pelo seguinte motivo: "
					+ conta.getMotivoFechamento() + ".");
		}

		return phraseString;
	}
}
