
public class TesteEscopo {

	public static void main(String[] args) {
		System.out.println("Testando condicionais");
		
		int idade = 16;
		int quantidadePessoas = 3;
		
		//boolean acompanhado = quantidadePessoas >= 2; // verdadeiro ou falso
		
		boolean acompanhado;
		
		if (quantidadePessoas >= 2) {
			acompanhado = true;
		} else {
			acompanhado = false;
		}
		
		if (idade >= 18 || acompanhado) { // OU é "||", E é "&&"
			System.out.println("Seja bem vindo!");
			
		} else {
		System.out.println("Você não pode entrar.");
		}			
	}
}
