package br.ufc.crateus.aps.biblioteca.test;


import org.junit.Test;

import br.ufc.crateus.aps.biblioteca.controlador.Fachada;
import br.ufc.crateus.aps.biblioteca.controlador.dispositivos.Impressora;
import br.ufc.crateus.aps.biblioteca.controlador.dispositivos.ImpressoraFactory;
import br.ufc.crateus.aps.biblioteca.controlador.dispositivos.TipoImpressora;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.DestinatarioAdapter;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Fornecedor;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.FornecedorAdapter;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Livro;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Perfil;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Usuario;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.UsuarioAdapter;


public class FachadaTest {

	@Test
	public void cadastrarFornecedor(){
		
		
		Usuario admin = new Usuario(); 
		
		
		admin.setLogin("kamas");
		admin.setNome("Yuri");
		admin.setPerfil(Perfil.gerente);
		admin.setSenha("2016.2"); //SE O GERENTE JÁ ESTIVER LOGADO
		
		Fornecedor novo = new Fornecedor(); 
		
		novo.setNome("Tataproduções");
		novo.setEndereco("Beco da Poeira,n° 69,Bairro:Centro,Crateus-Ce");
		novo.setCnpj("123.123.432-62");
		novo.setTelefone("889200000000");
		novo.setTelefone("1232113231");
		
		
		//assertEquals("Yuri cadastrou um fornecedor",new Fachada().getObjeto().cadastrarFornecedor(admin, novo));
		//new Fachada().getObjeto().cadastrarFornecedor(admin, novo);
	}
	
	
	
	@Test
	public void cadastrarLivro(){
		
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
		
		//new Fachada().adicionarInterecados(a);
		//new Fachada().adicionarInterecados(b);
		//new Fachada().cadastrarLivro(u, l);
	}
	
	@Test
	public void aluguelLivros(){
		
		Livro l = new Livro();
		Usuario u = new Usuario(); 
		
		u.setLogin("admin");
		u.setNome("Ze");
		u.setPerfil(Perfil.cliente);
		u.setSenha("123");

		l.setAno(2017);
		l.setAutor("Alfredo");
		l.setCod("123123");
		l.setNome("As cronicas");
		l.setQuantEstoque(4);
		l.setSinopse("era uma vez");
		l.setValorUnitario(2.50);
		
		
		//new Fachada().adicionarCarrinho(l);
		//new Fachada().usuarioCadastrouse(u);
		//new Fachada().finalizarAluguel(u, 4, "cartão");
	}
	
	@Test
	public void comprarLivro(){
		Usuario a = new Usuario(); 
		
		a.setLogin("eu");
		a.setNome("Ana");
		a.setPerfil(Perfil.cliente);
		a.setSenha("13");
		//
		//new Fachada().usuarioCadastrouse(a);
		//new Fachada().finalizarComprar(a, "boleto");
		
	}
	
	@Test
	public void Adapter(){
		
		DestinatarioAdapter destinatarioEmail = new FornecedorAdapter("teste@gmail");
		DestinatarioAdapter destinatarioSMS = new UsuarioAdapter("889887676");
		new Fachada().enviarMensagem(destinatarioEmail,destinatarioSMS);
	}
	
	@Test
	public void Factory(){
		TipoImpressora t = TipoImpressora.daruma;
		Impressora impressora = new ImpressoraFactory().getImpressora(t);
		//impressora.imprimir("Imprimiu");
	}
	
	
	
	
	
	
}
