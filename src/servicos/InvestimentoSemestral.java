package servicos;

import java.math.BigDecimal;

public class InvestimentoSemestral {

	public static final BigDecimal juros = BigDecimal.valueOf(0.10);

	public static BigDecimal valorizacao(BigDecimal valor) {

		return valor.multiply(BigDecimal.ONE.add(juros));
	}

}
