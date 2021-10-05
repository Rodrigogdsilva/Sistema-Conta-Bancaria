package servicos;

import java.math.BigDecimal;

public class InvestimentoAnual implements Investimento {

	public static final BigDecimal juros = BigDecimal.valueOf(0.30);

	public static BigDecimal valorizacao(BigDecimal valor) {

		return valor.multiply(BigDecimal.ONE.add(juros));
	}

}
