package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando Colecoes Java", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Modelando Colecoes", 35));
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 25));
		javaColecoes.adiciona(new Aula("Criando Aula", 19));
		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		
		System.out.println(aulasImutaveis);	
		
		List<Aula> aulas = new ArrayList<>(aulasImutaveis);
		
		Collections.sort(aulas);
		System.out.println(aulas);
		System.out.println(javaColecoes.getTempoTotal());
	}
}


