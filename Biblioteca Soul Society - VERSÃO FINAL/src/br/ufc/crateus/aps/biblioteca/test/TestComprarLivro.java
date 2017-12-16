package br.ufc.crateus.aps.biblioteca.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.crateus.aps.biblioteca.controlador.Fachada;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Livro;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Perfil;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Usuario;

public class TestComprarLivro {

	Fachada f;
	@Test
	public void comprarLivro(){
		f = new Fachada();
		Usuario a = new Usuario(); 
		Livro l = new Livro();
		
		a.setLogin("eu");
		a.setNome("Ana");
		a.setPerfil(Perfil.cliente);
		a.setSenha("13");
		
		l.setAno(2017);
		l.setAutor("Yuri");
		l.setCod("123123");
		l.setNome("As cronicas");
		l.setQuantEstoque(4);
		l.setSinopse("era uma vez");
		l.setValorUnitario(2.50);
		
		f.usuarioCadastrouse(a);
		f.adicionarCarrinho(l);
		
		try{
			assertEquals(3,f.finalizarComprar(a, "cart�o"));//1 - Usu�rio n�o cadastrado
		}catch(Exception e){                                //2 - N�o tem permiss�o de cadastrar
			System.out.println("N�o comprou");              //3 - Alugou
		}
	}


}
