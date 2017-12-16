package br.ufc.crateus.aps.biblioteca.controlador.entidade;

public class UsuarioAdapter extends Usuario implements DestinatarioAdapter {

	public UsuarioAdapter(String telefone){
		setTelefone(telefone);
	}
	

	@Override
	public void enviarMensagem(String mensagem) {
		
		enviarSMS(mensagem);
	}
	
}
