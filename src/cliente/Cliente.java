package cliente;

public class Cliente {

	private String nomeCliente;
	private String numeroDocCliente;
	private String scoreCliente;
	private TipoCliente tipoCliente;

	public Cliente(String nomeCliente, String numeroDocCliente, String scoreCliente, TipoCliente tipoCliente) {
		this.nomeCliente = nomeCliente;
		this.numeroDocCliente = numeroDocCliente;
		this.scoreCliente = scoreCliente;
		this.tipoCliente = tipoCliente;
	}

	// Getters e Setters
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNumeroDocCliente() {
		return numeroDocCliente;
	}

	public void setNumeroDocCliente(String numeroDocCliente) {
		this.numeroDocCliente = numeroDocCliente;
	}

	public String getScoreCliente() {
		return scoreCliente;
	}

	public void setScoreCliente(String scoreCliente) {
		this.scoreCliente = scoreCliente;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDocCliente == null) ? 0 : numeroDocCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (numeroDocCliente == null) {
			if (other.numeroDocCliente != null)
				return false;
		} else if (!numeroDocCliente.equals(other.numeroDocCliente)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nomeCliente=" + nomeCliente + ", numeroDocCliente=" + numeroDocCliente + ", scoreCliente="
				+ scoreCliente + ", tipoCliente=" + tipoCliente + "]";
	}

}
