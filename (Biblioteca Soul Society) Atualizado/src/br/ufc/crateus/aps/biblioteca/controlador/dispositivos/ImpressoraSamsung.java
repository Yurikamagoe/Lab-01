package br.ufc.crateus.aps.biblioteca.controlador.dispositivos;

public class ImpressoraSamsung implements Impressora {

	@Override
	public void imprimir(String texto) {
		System.out.println("ImpressoraSamsung:"+texto);
	}

}
