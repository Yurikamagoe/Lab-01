package br.ufc.crateus.aps.biblioteca.controlador.entidade;

import br.ufc.crateus.aps.biblioteca.controlador.factoty.Impressora;

public class ImpressoraDaruma implements Impressora {

	@Override
	public void imprimir(String texto) {
		System.out.println("ImpressoraDaruma:"+texto);
	}

}
