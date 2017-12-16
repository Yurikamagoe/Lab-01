package br.ufc.crateus.aps.biblioteca.controlador.entidade;

import br.ufc.crateus.aps.biblioteca.controlador.repositorio.Notificar;
import br.ufc.crateus.aps.biblioteca.controlador.repositorio.UsuarioListener;
import br.ufc.crateus.aps.biblioteca.controlador.util.MensageiroUtil;

public class Usuario implements UsuarioListener{
	
	private String nome;
	private String login;
	private String senha;
	private String telefone;
	
	private Perfil perfil;
	

	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
		
	}
	public String getNome() {
		return nome;				
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void notificar(){
		System.out.println(this.nome+" foi notificado");
	}
	@Override
	public String toString() {
		return "Nome=" + nome + "\nLogin=" + login + "\nSenha=" + senha + "\nPerfil=" + perfil + "\n\n";
	}
	public void enviarSMS(String mensagem){
		MensageiroUtil.enviarEmail(mensagem,getTelefone());
	}
	
	@Override
	public void notificar(Notificar novoLivro) {
		notificar();
	}
	
	

}
