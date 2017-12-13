package br.ufc.crateus.aps.biblioteca.controlador.entidade;

import java.util.ArrayList;

import br.ufc.crateus.aps.biblioteca.controlador.util.MensageiroUtil;

public class Fornecedor {
	
	private String Nome;
	private String cnpj;
	private String endereco;
	private String email;
	private ArrayList<String> telefone = new ArrayList<>();
	int posicao;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco(){
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public ArrayList<String> getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone.add(posicao, telefone);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void enviarEmail(String texto){
		MensageiroUtil.enviarEmail(texto,getEmail());
	}
	
	
}
