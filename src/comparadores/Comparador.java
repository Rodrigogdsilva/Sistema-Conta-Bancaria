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

	// M�todo que verifica se duas strings s�o iguais utilizando o operador ==
	public boolean comparaStringsUsandoIguais(String primeiraString, String segundaString) {

		if (primeiraString == segundaString) {
			System.out.println("As Strings inseridas s�o iguais e possuem o mesmo local na mem�ria");
			return true;
		} else {
			System.out.println("As Strings inseridas s�o diferentes ou n�o possuem o mesmo local na mem�ria");
			return false;
		}
	}

	// M�todo que verifica se duas strings s�o iguais utilizando o m�todo
	// .equals
	public boolean comparaStringsUsandoEquals(String primeiraString, String segundaString) {

		if (primeiraString.equals(segundaString)) {

			System.out.println("O conte�do das Strings inseridas � igual");
			return true;

		} else {

			System.out.println("O conte�do das Strings inseridas � diferente");
		}

		return false;
	}

	// M�todo que compara se dois n�meros s�o iguais
	public boolean comparaNumeros(int primeiroNumero, int segundoNumero) {

		if (primeiroNumero == segundoNumero) {
			System.out.println("Os n�meros inseridos s�o iguais");
			return true;
		} else {
			System.out.println("Os n�meros inseridos s�o diferentes");
			return false;
		}
	}
}
