
public class TestaMetodo {
	public static void main(String[] args) {
		Conta contaDoGustavo = new Conta();
			contaDoGustavo.saldo = 100;
			contaDoGustavo.deposita(50);
			System.out.println(contaDoGustavo);
			boolean conseguiuRetirar = contaDoGustavo.saca(20);
			System.out.println(contaDoGustavo.saldo);
			System.out.println(conseguiuRetirar);
			
			Conta contaDaMarcela = new Conta();
			contaDaMarcela.deposita(1000);
			boolean sucessoTransferencia = contaDaMarcela.transfere(300, contaDoGustavo);
			if(sucessoTransferencia) {
				System.out.println("Transferencia feita com sucesso!");
			} else {
				System.out.println("Transferencia não realizada!");
				
			}
			System.out.println(contaDoGustavo.saldo);
			System.out.println(contaDaMarcela.saldo);
			
			contaDoGustavo.titular = "Gustavo Joner";
			System.out.println(contaDoGustavo.titular);
			
	}
}

