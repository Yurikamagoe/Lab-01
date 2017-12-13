package br.ufc.crateus.aps.biblioteca.controlador.entidade;

public class FornecedorAdapter extends Fornecedor implements DestinatarioAdapter{

	public FornecedorAdapter(String email){
		setEmail(email);
	}

	public void enviarMensagem(String mensagem) {
		 
		enviarEmail(mensagem);
		
	}

}
