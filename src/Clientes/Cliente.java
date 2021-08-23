package clientes;

public class Cliente {

	private String nomeCliente;
	private String numeroDocCliente;
	private int scoreCliente;
	private TipoCliente tipoCliente;

	public Cliente(String nomeCliente, String numeroDocCliente, int scoreCliente, TipoCliente tipoCliente) {
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

	public int getScoreCliente() {
		return scoreCliente;
	}

	public void setScoreCliente(int scoreCliente) {
		this.scoreCliente = scoreCliente;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

}
