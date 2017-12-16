package br.ufc.crateus.aps.biblioteca.controlador.entidade;

import br.ufc.crateus.aps.biblioteca.controlador.factoty.Impressora;

public class ImpressoraSamsung implements Impressora {

	@Override
	public void imprimir(String texto) {
		System.out.println("ImpressoraSamsung:"+texto);
	}

}
