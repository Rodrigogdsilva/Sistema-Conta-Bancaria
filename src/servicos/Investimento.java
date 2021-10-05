package servicos;

import java.math.BigDecimal;

public abstract interface Investimento {

	public static BigDecimal valorizacao(BigDecimal valor) {
		return valor;
	}
}
