package application;

import java.math.BigDecimal;
import java.time.LocalDate;

import cliente.Cliente;
import cliente.TipoCliente;
import conta.ContaPoupanca;
import servicos.AnnualInvestment;
import servicos.MonthlyInvestment;
import servicos.SemiAnnualInvestment;

public class MainDecimoPrimeiroExercicio {

	public static void main(String[] args) {

		Cliente cliente2 = new Cliente("José", "222.222.222-22", "300", TipoCliente.PESSOA_FISICA);

		ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente2, "Banco do Brasil", "756", "44444", "4444", 3400.00,
				LocalDate.parse("2002-09-30"), null, null, new MonthlyInvestment(), 150, 135, 1);

		contaPoupanca1.apply(BigDecimal.valueOf(100.00));

		contaPoupanca1.setInvestment(new SemiAnnualInvestment());

		contaPoupanca1.apply(BigDecimal.valueOf(100.00));

		contaPoupanca1.setInvestment(new AnnualInvestment());

		contaPoupanca1.apply(BigDecimal.valueOf(100.00));
	}
}
