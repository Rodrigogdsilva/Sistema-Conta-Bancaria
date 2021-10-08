package servicos;

import java.math.BigDecimal;

public class MonthlyInvestment implements Investment {

	private final BigDecimal juros = BigDecimal.valueOf(0.02);

	public BigDecimal valorizacao(BigDecimal valor) {

		return valor.multiply(BigDecimal.ONE.add(juros));
	}

}
