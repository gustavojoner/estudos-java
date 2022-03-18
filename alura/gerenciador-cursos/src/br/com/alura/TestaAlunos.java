package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TestaAlunos {

	public static void main(String[] args) {
		Collection<String> alunos = new HashSet<>(); // substituindo Set por Collection
		alunos.add("Rodrigo");
		alunos.add("Nico");
		alunos.add("Bruna");
		alunos.add("Pedro");
		alunos.add("Daiana");
		alunos.add("Thiago");

		boolean nicoEstaMatriculado = alunos.contains("Nico"); // busca
		System.out.println(nicoEstaMatriculado);
		
		alunos.forEach(aluno -> {System.out.println(aluno);}); // laço simplificado
		
		alunos.remove("Pedro");

		System.out.println(alunos);
		
		List<String> alunosEmLista = new ArrayList<>(alunos); // faz uma copia caso precise alterar, sem mexer no original
		
		Collections.sort(alunosEmLista);
		System.out.println(alunosEmLista); // por em lista ordenada
	}
}
