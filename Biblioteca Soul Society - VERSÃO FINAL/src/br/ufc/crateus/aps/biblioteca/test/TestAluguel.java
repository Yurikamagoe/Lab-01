package br.ufc.crateus.aps.biblioteca.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.crateus.aps.biblioteca.controlador.Fachada;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Livro;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Perfil;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Usuario;

public class TestAluguel {

	Fachada f;
	
	@Test
	public void aluguelLivros(){
		
		f = new Fachada();
		Livro l = new Livro();
		Usuario u = new Usuario(); 
		
		u.setLogin("admin");
		u.setNome("Ze");
		u.setPerfil(Perfil.cliente);
		u.setSenha("123");

		l.setAno(2017);
		l.setAutor("Yuri");
		l.setCod("123123");
		l.setNome("As cronicas");
		l.setQuantEstoque(4);
		l.setSinopse("era uma vez");
		l.setValorUnitario(2.50);
		
		f.adicionarCarrinho(l);
		f.usuarioCadastrouse(u);
		
		try{
		assertEquals(3,f.finalizarAluguel(u,48,"boleto"));     //1 - Usuário não cadastrado
		}catch(Exception e){                                   //2 - Não há itens no carrinho
															   //3 - Alugou
		}													   // usei a numeração para havia três tipos de retorno
	}


}
