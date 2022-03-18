package br.com.alura;

import java.util.List;

public class TestaCurso {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando Colecoes Java", "Paulo Silveira");
		
		List<Aula> aulas = javaColecoes.getAulas();
		
		javaColecoes.adiciona(new Aula("Modelando Colecoes", 35));
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 25));
		javaColecoes.adiciona(new Aula("Criando Aula", 19));
		
		System.out.println(javaColecoes.getAulas());		
		
	}
}
