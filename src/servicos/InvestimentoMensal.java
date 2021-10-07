package servicos;

import java.math.BigDecimal;

public class InvestimentoMensal implements Investimento {

	private final BigDecimal juros = BigDecimal.valueOf(0.01);

	public BigDecimal valorizacao(BigDecimal valor) {

		return valor.multiply(BigDecimal.ONE.add(juros));
	}

}
