package br.ufc.crateus.aps.biblioteca.controlador.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.ufc.crateus.aps.biblioteca.controlador.entidade.Usuario;

public class UsuarioRepositorio{
	
	
	private static Map<Integer, Usuario> repositorio = new HashMap<Integer, Usuario>();
	
	private static int id = 1;
	
	public static void setUsuario(Usuario us){
		repositorio.put(id, us);
		id++;
	}
	
	public static Usuario getUsuarioPorLogin(String login,String senha) {
		for (Entry<Integer, Usuario> idUsuario : repositorio.entrySet()) {
			if(idUsuario.getValue().getLogin().equals(login) && idUsuario.getValue().getSenha().equals(senha))
				return idUsuario.getValue();
		}
		return null;
	}

	public static Usuario getUsuarioPorNome(String nome) {
		for (Entry<Integer, Usuario> idUsuario : repositorio.entrySet()) {
			if(idUsuario.getValue().getLogin().contains(nome))
				return idUsuario.getValue();
		}
		return null;
	}


}
