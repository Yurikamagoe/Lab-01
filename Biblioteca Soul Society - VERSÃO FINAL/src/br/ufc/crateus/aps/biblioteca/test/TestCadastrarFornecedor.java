package br.ufc.crateus.aps.biblioteca.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.crateus.aps.biblioteca.controlador.Fachada;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Fornecedor;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Perfil;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Usuario;

public class TestCadastrarFornecedor {

	Fachada f;
	@Test
	public void cadastrarFornecedor(){
		
		f  = new Fachada();
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
		
		try{					
			assertEquals(1,f.cadastrarFornecedor(admin, novo)); //1 - Cadastrou fornecedor
		}catch(Exception e){									//2 - Não tem permissão de cadastrar
			System.out.println("Não cadastrado");
		}
	}
	

}
