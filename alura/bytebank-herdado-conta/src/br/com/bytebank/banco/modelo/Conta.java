package br.com.bytebank.banco.modelo;


/**
 * 
 * Cria classe do tipo conta
 * 
 * @author Gustavo Joner
 *
 */
public abstract class Conta {
	
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
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public static int getTotal() {
	return Conta.total;
	}
}
