package br.com.bytebank.banco.teste;

public class TesteArrayDePrimitivos {
	
	public static void main(String[] args) {
		
		int[]idades = new int[5]; // dentro do [] numero de elementos que tera (inicia com valores padrao 0)
		
		for(int i = 0; i < idades.length; i++ ) {
			idades[i] = i * i;
		}
		
		for(int i = 0; i < idades.length; i++ ) {
			System.out.println(idades[i]);
		}
		
		int idade1 = idades[0]; // posicao zero
		
		
		System.out.println(idades.length);
	}
}
