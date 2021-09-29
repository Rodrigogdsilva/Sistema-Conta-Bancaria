package tributacao;

import java.time.LocalDate;

import conta.ContaBancaria;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class Taxa implements InterfaceTaxa {

	private static final double TAXA_TRIBUTAVEL = 0.03;

	@Override
	public double tributacao(ContaBancaria conta) {

		LocalDate limitDate = LocalDate.parse("2021-11-01");

		if (conta instanceof ContaCorrente || conta instanceof ContaPoupanca) {

			if (limitDate.isBefore(LocalDate.now()) || limitDate.equals(LocalDate.now())) {

				double taxa = conta.getSaldoConta() * TAXA_TRIBUTAVEL;

				System.out.println("Saldo anterior: " + conta.getSaldoConta());

				conta.setSaldoConta(conta.getSaldoConta() - taxa);

				System.out.println("Total descontado:" + taxa);

				System.out.println("Saldo atualizado: " + conta.getSaldoConta());

				return taxa;
			} else {
				System.out.println("Não é necessária a aplicação da taxa tributável.");
			}

		} else {

			System.out.println("Não há aplicação de taxa para esse tipo de conta");

			return 0;
		}

		return 0;

	}

}
