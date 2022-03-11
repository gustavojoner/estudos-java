package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.SaldoInsufienteException;

public class TesteContas {

	public static void main(String[] args) throws SaldoInsufienteException {
		
	ContaCorrente cc = new ContaCorrente(3333, 1234);
		cc.deposita(100);
		cc.saca(20);
		
		ContaPoupanca cp = new ContaPoupanca(22222, 1234);
		cp.deposita(200);

		cc.transfere(10, cp);
		
		System.out.println("Conta Corrente saldo: " + cc.getSaldo());
		System.out.println("Conta Poupança saldo: " + cp.getSaldo());
	}

}
