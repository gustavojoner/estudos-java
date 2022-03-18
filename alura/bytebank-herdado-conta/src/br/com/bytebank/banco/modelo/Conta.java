package br.com.bytebank.banco.modelo;

import java.io.Serializable;

/**
 * 
 * Cria classe do tipo conta
 * 
 * @author Gustavo Joner
 *
 */
public abstract class Conta implements Comparable<Conta>, Serializable {
	
	double saldo;
	int agencia;
	int numero;
	Cliente titular;
	static int total;
		
	public Conta(int agencia, int numero) {
		Conta.total ++;
		this.agencia = agencia;
		this.numero = numero;
	}
		
	public abstract void deposita(double valor);
	
	/**
	 * 
	 * O valor deve ser maior que o saque para funcionar.
	 * 
	 * @param valor
	 * @throws SaldoInsufienteException
	 */
	public void saca(double valor) throws SaldoInsufienteException {
		
		if(this.saldo < valor) {
			throw new SaldoInsufienteException("Saldo: " + this.saldo +", " + "Valor: " + valor); 
		}
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsufienteException {
		this.saca(valor);
		destino.deposita(valor);
		}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("Valor inválido");
			return;
		}
		this.numero = numero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("Valor inválido");
			return;
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente cliente) {
		this.titular = cliente;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public static int getTotal() {
	return Conta.total;
	}
	
	@Override
	public boolean equals(Object ref) {
		
		Conta outra = (Conta) ref;
		
		if(this.agencia != outra.agencia) {
			return false;
		}
		if(this.numero != outra.numero) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo(Conta outra) {
		return Double.compare(this.saldo, outra.saldo);
	}
	
	@Override
	public String toString() {
		return "Número: " + this.numero + ", Agência: " + this.agencia + ", Saldo: " + this.saldo;
	}
}
