package servicos;

import java.math.BigDecimal;

public class SemiAnnualInvestment implements Investment{

	private final BigDecimal juros = BigDecimal.valueOf(0.10);

	public BigDecimal valorizacao(BigDecimal valor) {

		return valor.multiply(BigDecimal.ONE.add(juros));
	}

}
