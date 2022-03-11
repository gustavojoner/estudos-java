
public class TestaGetESet {
	public static void main(String[] args) {
		Conta conta = new Conta(111, 2022);
		System.out.println(conta.getNumero());
		
		Cliente gustavo = new Cliente();
		gustavo.setNome("Gustavo Joner");
		conta.setTitular(gustavo);
		
		System.out.println(conta.getTitular().getNome());
		
		conta.getTitular().setProfissao("Programador");
		
		System.out.println(conta.getTitular().getProfissao());
		
	}
}
