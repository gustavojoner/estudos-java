package projeto;

public class BibliotecaVirtual {
	private String nome;

	private int acervo;
	private boolean online;

	public BibliotecaVirtual(String nom, int acerv, boolean on) {
		nome = nom;
		acervo = acerv;
		online = on;
	}

	public String Getnome() {
		return nome;
	}

	public int Getacervo() {
		return acervo;
	}

	public boolean Getonline() {
		return online;
	}

	public void Setnome(String nom) {
		nome = nom;
	}

	public void Setacervo(int acerv) {
		acervo = acerv;
	}

	public void Setonline(boolean on) {
		online = on;
	}

	public void AddLivro(int livros_novos) {
		acervo = acervo + livros_novos;
	}

	public void MostrarAcervo() {
		System.out.println("Há " + acervo + " livro(s) no acervo.");
	}

	public void MostrarSeBibliotecaEstaOnline() {
		if (online == true) {
			System.out.println("A biblioteca está no ar");
		}

		if (online == false) {
			System.out.println("A biblioteca está fora do ar");
		}

	}
}