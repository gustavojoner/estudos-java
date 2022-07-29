package projeto;

public class Produto {

	private String nome;
	private String marca;
	private int quantidade;
	private double valor;

	public Produto(String n, String m, int q, double v) {

		nome = n;
		marca = m;
		quantidade = q;
		valor = v;
	}

	public boolean disponivel() {
		if (valor > 0) {
			return true;
		}
		return false;
	}
	
	public void exibeDados() {
		System.out.println("Dados do produto: ");
		System.out.println("Produto: " + nome);
		System.out.println("Marca: " + marca);
		System.out.println("Estoque: " + quantidade);
		System.out.println("Valor: " + valor);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
