package br.ufc.crateus.aps.biblioteca.controlador.util;

public class MensageiroUtil {
	
	public static void enviarEmail(String texto,String destino){
		System.out.println("Email:"+texto+" enviada para "+destino);
	}
	public static void enviarTexto(String texto,String destino){
		System.out.println("Arquivo:"+texto+" enviada para "+destino);
	}
}
