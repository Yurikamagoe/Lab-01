package br.ufc.crateus.aps.biblioteca.controlador.entidade;

public class Livro {

	private String nome;
	private String cod;
	private String autor;
	private double valorUnitario;
	private int ano;
	private String sinopse;
	private int quantEstoque;

	public String getNome() {
		return nome;

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public int getQuantEstoque() {
		return quantEstoque;
	}

	public void setQuantEstoque(int quantEstoque) {
		this.quantEstoque = quantEstoque;
	}

	
	public String toString() {
		return "Nome: " + nome + "\nCódigo Único: " + cod + "\nAutor: " + autor + "\n Valor Unitario: " 
	+ valorUnitario	+ "\nAno: " + ano + "\nSinopse: " + sinopse + "\nQuant. Estoque: " + quantEstoque+"\n\n";	
		}	

}