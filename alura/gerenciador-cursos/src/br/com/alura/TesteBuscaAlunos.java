package br.com.alura;

public class TesteBuscaAlunos {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando Colecoes Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Modelando Colecoes", 35));
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 25));
		javaColecoes.adiciona(new Aula("Criando Aula", 19));
		
		Aluno a1 = new Aluno("Gustavo", 46541);
		Aluno a2 = new Aluno("Andreia", 45612);
		Aluno a3 = new Aluno("Pedro", 45871);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		Aluno aluno = javaColecoes.buscaMatriculado(45612); // buscando pela matricula
		System.out.println("Dados aluno: " + aluno); // retorna nulo caso nao encontrado
	}	
}

