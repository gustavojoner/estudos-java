
public class TestaBanco {
	public static void main(String[] args) {
		Cliente gustavo = new Cliente();
		gustavo.nome = "Gustavo Joner";
		gustavo.cpf = "222.222.222-22";
		gustavo.profissao = "Programador";
		
		Conta contaDoGustavo = new Conta();
		contaDoGustavo.deposita(300);
		
		contaDoGustavo.titular = gustavo;
		System.out.println(contaDoGustavo.titular.nome);
	}

}
