package br.ufc.crateus.aps.biblioteca.controlador.repositorio;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.ufc.crateus.aps.biblioteca.controlador.entidade.Fornecedor;

public class FornecedorRepositorio {

private static Map<Integer, Fornecedor> repositorio = new HashMap<Integer, Fornecedor>();
	
	private static int id = 1;
	
	public static void setFornecedor(Fornecedor fornecedor){
		
		if(fornecedor.getCnpj().equals(getFornecedorPorCnpj(fornecedor.getCnpj()))){
			System.out.println("O fornecedor já existe");
		}else{
			repositorio.put(id, fornecedor);
			id++;
		}
	}
	
	public static Fornecedor getFornecedorPorCnpj(String cnpj) {
		for (Entry<Integer, Fornecedor> fornecedores : repositorio.entrySet()) {
			if(fornecedores.getValue().getCnpj().equals(cnpj))
				return fornecedores.getValue();
		}
		return null;
	}

	public static Fornecedor getUsuarioPorNome(String nome) {
		for (Entry<Integer, Fornecedor> fornecedores : repositorio.entrySet()) {
			if(fornecedores.getValue().getNome().contains(nome))
				return fornecedores.getValue();
		}
		return null;
	}
}
