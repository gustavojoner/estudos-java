package br.com.bytebank.banco.teste;

public class TesteString {
	
	public static void main(String[] args) {
		 
		int a = 3;
		String nome = "Gustavo"; // objeto literal
		// equivale = (String nome = new String("Gustavo") 
		
		String outro = nome.replace("a", "A"); // unica forma de modificar é criando outro objeto
		System.out.println(outro);
		
		String outro2 = nome.toLowerCase(); // criando outro objeto
		System.out.println(outro2);
		
		char c = nome.charAt(2); // mostra o caractere na posicao solicitada, comecando de zero
		System.out.println(c);
		
		int p = nome.indexOf("s"); // mostra a posicao do caractere
		System.out.println(p);
		
		int t = nome.length(); // tamanho da string
		System.out.println(t);
		
		boolean v = nome.isEmpty(); // diz se a string é vazia
		System.out.println(v);
		
		String vazio = "  Gustavo   Joner";
		String novoVazio = vazio.trim(); // remove espaço inicio e fim
		System.out.println(novoVazio);
		
		System.out.println(novoVazio.contains("a")); // pergunta se tem o " "
	}
}
