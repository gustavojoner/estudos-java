package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayReferencias {

	public static void main(String[] args) {
		
		Object[] referencias = new Object[5];
		
		ContaCorrente cc1 = new ContaCorrente(22, 33);		
		referencias[0] = cc1;
		
		ContaPoupanca cc2 = new ContaPoupanca(22,55);
		referencias[1] = cc2;

		Cliente cc3 = new Cliente();
		referencias[2] = cc3;
		
		ContaPoupanca ref = (ContaPoupanca) referencias[1]; // typecast > () transformam um tipo generico em um tipo + especifico
		
		System.out.println(cc2.getNumero()); // acessa por referencia e pega numero
		
//		System.out.println(contas[1].getNumero()); // acessa por posicao e pega numero
//		
//		System.out.println(contas[0].getAgencia());
		
		System.out.println(referencias[2]);
	}

}
