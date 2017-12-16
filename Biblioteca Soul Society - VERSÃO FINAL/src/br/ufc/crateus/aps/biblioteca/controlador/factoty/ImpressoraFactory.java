package br.ufc.crateus.aps.biblioteca.controlador.factoty;

import br.ufc.crateus.aps.biblioteca.controlador.entidade.ImpressoraDaruma;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.ImpressoraSamsung;

public class ImpressoraFactory {
	
	public Impressora getImpressora(TipoImpressora tipo){
		
		switch(tipo){
		case daruma: return new ImpressoraDaruma();
		
		case samsung: return new ImpressoraSamsung();
		
		default:
			break;
		}
		
		return null;
	}

		

}
