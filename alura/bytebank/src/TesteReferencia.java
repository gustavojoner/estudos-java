
public class TesteReferencia {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 300;
		
		System.out.println("O saldo da primeira conta " + primeiraConta.saldo);
		
		Conta segundaConta = primeiraConta;
		System.out.println("O saldo da segunda conta: " + segundaConta.saldo);
		
		segundaConta.saldo += 200;
		System.out.println(segundaConta.saldo);
		System.out.println(primeiraConta.saldo);
	}
}
