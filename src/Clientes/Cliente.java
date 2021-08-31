package clientes;

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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			System.out.println("Cliente não cadastrado");
			return false;
		}
		if (getClass() != obj.getClass()) {
			System.out.println("Objetos de classes diferentes, não é possível efetuar a verificação");
			return false;
		}
		Cliente other = (Cliente) obj;
		if (numeroDocCliente == null) {
			System.out.println("Não existe número de documento informado para este cliente");
			if (other.numeroDocCliente != null)
				System.out.println("Não existe número de documento informado para este cliente");
			return false;
		} else if (!numeroDocCliente.equals(other.numeroDocCliente)) {
			System.out.println("Clientes distintos, números de documentos divergentes. \n");
			return false;
		}
		System.out.println(
				"Os dois clientes inseridos tratam-se da mesma pessoa, pois possuem o mesmo número de documento. \n");
		return true;
	}
}
