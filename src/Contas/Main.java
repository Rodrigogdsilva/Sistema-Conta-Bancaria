package Contas;

import org.joda.time.LocalDate;

import Clientes.TipoCliente;

public class Main {

	public static void main(String[] args){

		//Instanciando objetos do tipo Conta Corrente
		ContaCorrente contaCorrente1 = new ContaCorrente("Rodrigo", "111.111.111-11", 500, TipoCliente.SERVIDORPUBLICO, "Itaú", 341, 11111, 1111, 1000.00, 
				LocalDate.now(), TipoConta.CONTACORRENTE);
		
		ContaCorrente contaCorrente2 = new ContaCorrente("José", "222.222.222-22", 300, TipoCliente.PESSOAJURIDICA, "Santander", 033, 22222, 2222, 500.00, 
				LocalDate.now(), TipoConta.CONTACORRENTE);
		
		ContaCorrente contaCorrente3 = new ContaCorrente("Julio Cesar", "333.333.333-33", 600, TipoCliente.PESSOAFISICA, "Original", 212, 33333, 3333, 1700.00, 
				LocalDate.now(), TipoConta.CONTACORRENTE);
		
		//Instanciando objetos do tipo Conta Corrente
		ContaPoupanca contaPoupanca1 = new ContaPoupanca("Valentina", "444.444.444-44", 900, TipoCliente.FUNCIONARIOBANCO , "Banco do Brasil", 756, 44444, 4444, 3400.00, 
				LocalDate.now(), TipoConta.CONTAPOUPANCA);
		
		ContaPoupanca contaPoupanca2 = new ContaPoupanca("Breno", "555.555.555-55", 750, TipoCliente.PESSOAJURIDICA, "Votorantim", 655, 55555, 5555, 1238.75, 
				LocalDate.now(), TipoConta.CONTAPOUPANCA);
		
		ContaPoupanca contaPoupanca3 = new ContaPoupanca("Caio", "666.666.666-66", 537, TipoCliente.SERVIDORPUBLICO, "Bradesco S.A", 237, 66666, 6666, 357.79, 
				LocalDate.now(), TipoConta.CONTAPOUPANCA);
		
		//Instanciando objetos do tipo Conta Empresarial
		ContaEmpresarial contaEmpresarial1 = new ContaEmpresarial("Florisvaldo", "777.777.777-77", 495, TipoCliente.PESSOAFISICA, "Inter S.A", 077, 77777, 7777, 1103.03, 
				LocalDate.now(), TipoConta.CONTAEMPRESARIAL, "Ambev");
		
		ContaEmpresarial contaEmpresarial2 = new ContaEmpresarial("Augusto", "888.888.888-88", 237, TipoCliente.SERVIDORPUBLICO, "Caixa Econômica Federal", 104, 88888, 8888, 135.01, 
				LocalDate.now(), TipoConta.CONTAEMPRESARIAL, "JBS");
		
		ContaEmpresarial contaEmpresarial3 = new ContaEmpresarial("Vanessa", "999.999.999-99", 623, TipoCliente.PESSOAFISICA, "Banco Safra S.A", 422, 99999, 9999, 4922.01, 
				LocalDate.now(), TipoConta.CONTAEMPRESARIAL, "TAM");
		
		
	}
}
