package br.ufc.crateus.aps.biblioteca.controlador.entidade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Perfil {

	gerente(Permissao.cadastrar_livro,Permissao.cadastrar_usuario,Permissao.cadastrar_fornecedor),
	funcionario(Permissao.pesquisar_livro,Permissao.cadastrar_livro),
	cliente(Permissao.pesquisar_livro,Permissao.comprar_livro);
	
    private List<Permissao> permissoes = new ArrayList<Permissao>();
	
	private Perfil(Permissao... permissoes) {
		
		setPermissoes(Arrays.asList(permissoes));
	}

	public List<Permissao> getPermissoes(){
		return permissoes;
	}

	private void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	
	
}
