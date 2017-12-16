package br.ufc.crateus.aps.biblioteca.controlador.dispositivos;

public class ImpressoraDaruma implements Impressora {

	@Override
	public void imprimir(String texto) {
		System.out.println("ImpressoraDaruma:"+texto);
	}

}
