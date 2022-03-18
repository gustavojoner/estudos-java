package br.com.alura;

public class Aluno {

	private String nome;
	private int numeroMatricula;

	public Aluno(String nome, int numeroMatricula) {
		if(nome == null) {
			throw new NullPointerException("Nome não pode ser nulo");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}	
	
	@Override
	public String toString() {
		return "Matricula: " +this.numeroMatricula + " Nome: " + this.nome;
	}
	
	@Override
	public boolean equals(Object obj) { // compara nome de objetos diferentes
		Aluno outro = (Aluno) obj;
		return this.nome.equals(outro.nome);
	}
	
	@Override
	public int hashCode() { // necessario reescrever hashCode quando reescrevemos o equals, mesmo obj precisa msm hashcode
		return this.nome.hashCode();
	}

}
