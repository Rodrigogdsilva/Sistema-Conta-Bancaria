package comparadores;

import clientes.Cliente;
import contas.ContaBancaria;

public class Comparador {

	private String primeiraString;
	private String segundaString;
	private int primeiroNumero;
	private int segundoNumero;

	public String getPrimeiraString() {
		return primeiraString;
	}

	public void setPrimeiraString(String primeiraString) {
		this.primeiraString = primeiraString;
	}

	public String getSegundaString() {
		return segundaString;
	}

	public void setSegundaString(String segundaString) {
		this.segundaString = segundaString;
	}

	public int getPrimeiroNumero() {
		return primeiroNumero;
	}

	public void setPrimeiroNumero(int primeiroNumero) {
		this.primeiroNumero = primeiroNumero;
	}

	public int getSegundoNumero() {
		return segundoNumero;
	}

	public void setSegundoNumero(int segundoNumero) {
		this.segundoNumero = segundoNumero;
	}

	// Método que verifica se duas strings são iguais utilizando o operador ==
	public boolean comparaStringsUsandoIguais(String primeiraString, String segundaString) {

		if (primeiraString == segundaString) {
			System.out.println("As Strings inseridas são iguais e possuem o mesmo local na memória");
			return true;
		} else {
			System.out.println("As Strings inseridas são diferentes ou não possuem o mesmo local na memória");
			return false;
		}
	}

	// Método que verifica se duas strings são iguais utilizando o método
	// .equals
	public boolean comparaStringsUsandoEquals(String primeiraString, String segundaString) {

		if (primeiraString.equals(segundaString)) {

			System.out.println("O conteúdo das Strings inseridas é igual");
			return true;

		} else {

			System.out.println("O conteúdo das Strings inseridas é diferente");
		}

		return false;
	}

	// Método que compara se dois números são iguais
	public boolean comparaNumeros(int primeiroNumero, int segundoNumero) {

		if (primeiroNumero == segundoNumero) {
			System.out.println("Os números inseridos são iguais");
			return true;
		} else {
			System.out.println("Os números inseridos são diferentes");
			return false;
		}
	}
}
