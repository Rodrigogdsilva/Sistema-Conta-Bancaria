package servicos;

import java.math.BigDecimal;

public class InvestimentoMensal implements Investimento {

	public static final BigDecimal juros = BigDecimal.valueOf(0.01);

	public static BigDecimal valorizacao(BigDecimal valor) {

		return valor.multiply(BigDecimal.ONE.add(juros));
	}

}
