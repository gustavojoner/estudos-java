package br.com.bytebank.banco.modelo;

public class SaldoInsufienteException extends Exception {
	
	public SaldoInsufienteException(String msg) {
		super(msg);
	}

}
