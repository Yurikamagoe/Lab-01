package br.ufc.crateus.aps.biblioteca.test;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import br.ufc.crateus.aps.biblioteca.controlador.Fachada;
import br.ufc.crateus.aps.biblioteca.controlador.adapter.DestinatarioAdapter;
import br.ufc.crateus.aps.biblioteca.controlador.adapter.FornecedorAdapter;
import br.ufc.crateus.aps.biblioteca.controlador.adapter.UsuarioAdapter;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Fornecedor;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Livro;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Perfil;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Usuario;
import br.ufc.crateus.aps.biblioteca.controlador.factoty.Impressora;
import br.ufc.crateus.aps.biblioteca.controlador.factoty.ImpressoraFactory;
import br.ufc.crateus.aps.biblioteca.controlador.factoty.TipoImpressora;


public class TestCadastrarLivro {

	Fachada f;
			
	@Test
	public void cadastrarLivro(){
		
		f = new Fachada();
		
		Livro l = new Livro();	
		Usuario u = new Usuario();//admin
		Usuario a = new Usuario();//cliente interessado
		Usuario b = new Usuario();//cliente interessado
		
		a.setLogin("432");
		a.setNome("Ana");
		a.setPerfil(Perfil.cliente);
		a.setSenha("123");
		
		b.setLogin("44534");
		b.setNome("Paulo");
		b.setPerfil(Perfil.cliente);
		b.setSenha("123");
		
		u.setLogin("admin");
		u.setNome("Ze");
		u.setPerfil(Perfil.gerente);
		u.setSenha("123");//SE O GERENTE JÁ ESTIVER LOGADO
		
		l.setAno(2017);
		l.setAutor("Rogerinho");
		l.setCod("123123");
		l.setNome("Esqueerda");
		l.setQuantEstoque(4);
		l.setSinopse("Hackeado");
		l.setValorUnitario(2.50);
		
		try{
			assertEquals(1,f.cadastrarLivro(u,l));// 1 - cadastrou Livro
		}catch(Exception e){					  // 2 - Não tem permissão
			System.out.println("Não cadastrado");
		}		
	}
	
	
}
