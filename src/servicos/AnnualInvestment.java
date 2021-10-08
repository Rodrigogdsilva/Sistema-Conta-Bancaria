package servicos;

import java.math.BigDecimal;

public class AnnualInvestment implements Investment {

	private final BigDecimal juros = BigDecimal.valueOf(0.30);

	public BigDecimal valorizacao(BigDecimal valor) {

		return valor.multiply(BigDecimal.ONE.add(juros));
	}

}
