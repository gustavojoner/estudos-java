package br.com.bytebank.banco.modelo;

import java.io.Serializable;

public class ContaCorrente extends Conta implements Tributavel {
	
	private static final long serialVersionUID = -5169221826498540227L;

	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);		
	}

	@Override
	public void saca(double valor) throws SaldoInsufienteException {
		double valorASacar = valor + 0.2;
		super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;		
	}

	@Override
	public double getValorImposto() {
		return super.saldo * 0.01;
	}
	
	@Override
	public String toString() {
		return "ContaCorrente; " + super.toString();
	}
}
