package servicos;

import java.math.BigDecimal;

public abstract interface Investimento {

	public BigDecimal valorizacao(BigDecimal valor);

}
