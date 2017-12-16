package br.ufc.crateus.aps.biblioteca.controlador.repositorio;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;

import br.ufc.crateus.aps.biblioteca.controlador.entidade.Livro;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Usuario;

public class LivroRepositorio {

	private static ArrayList<Livro> listaItem = new ArrayList<Livro>();
	private static ArrayList<Livro> carrinho = new ArrayList<Livro>();
	private static ArrayList<Usuario> listaInterecados = new ArrayList<Usuario>();
	private static Map<Integer,Livro> livrosAlugados = new HashMap<Integer,Livro>(); 
	private static Map<String,Usuario> aluguelUsuario = new HashMap<String,Usuario>(); 
	
	
	public static Livro getItem(int indice) {
		return listaItem.get(indice);

	}
	

	public static Livro getItemName(String name) {
		for (int i = 0; i < listaItem.size(); i++) {
			if (listaItem.get(i).getNome().equals(name)) {
				return listaItem.get(i);
			}
		}
		return null;
	}

	public static boolean aumentarTamanhoDoConjunto(int n) {
		listaItem.ensureCapacity(n);
		return true;
	}
	
	public static boolean addItem(Livro l) {
		return listaItem.add(l);
	}

	public static ArrayList<Livro> getListaObjetos() {
		return listaItem;

	}

	public static int tamanhoLista() {
		return listaItem.size();
	}
	
	
	public static void AddCarrinho(Livro livro){
		carrinho.add(livro);
	}
	
	public static void vendeLivro(){
		if(carrinho.size() == 0){
			System.out.println("Não itens");
		}else{
		for (int i = 0; i < carrinho.size(); i++) {
			if (carrinho.get(i).getNome().equals(getItemName(carrinho.get(i).getNome()))) { // comparar pelo codigo
				listaItem.remove(getItemName(carrinho.get(i).getNome()));			
			}
		}
		}
	}
	
	public static void notificarCliente(){
		for(UsuarioListener listener : listaInterecados){
			listener.notificar(Notificar.novoLivro);
		}
	}
	
	public static void geraBoleto(){
		System.out.println("Nome do Banco | Prefixo |__0000.0000 0000000.000000000\n"
				          +"Local de pagamento_________________|Vencimento 0/00/00\n"
				          + "Cedente___________________________|Agencia 111-8/0000\n"
				          + "Data do documento|N° ducumento____|Especie doc_______\n"
				          + "Uso do banco_____|Carteira:06_____|Especie:R$__________");
	}
	
	public static void formaPagamento(String forma){
		if(forma == "boleto"){
			geraBoleto();
		}else{
			System.out.println("Passou o cartão");
		}
	}

	public static boolean addInterecados(Usuario u) {
		return listaInterecados.add(u);
	}
	
	public static boolean haItensCarrinho(){
		if(carrinho.size() == 0){
			return false;
		}else{
			return true;
		}
	}
	
	public static void addLivroAlugado(int tempoH){
		for(int i = 0;i < carrinho.size();i++){
			livrosAlugados.put(tempoH,carrinho.get(i));
		}
	}
	
	public static void addUsuarioAlugou(Usuario u){
		for(Entry<Integer,Livro> livros : livrosAlugados.entrySet()){
			aluguelUsuario.put(livros.getValue().getCod(),u);		
		}
	}
	
	public static void getListaDeAlugados(){
		for(Entry<Integer,Livro> livros : livrosAlugados.entrySet()){
			for(Entry<String,Usuario> usuarios : aluguelUsuario.entrySet()){
				if(livros.getValue().getCod().equals(usuarios.getKey())){
					System.out.println(livros.getValue().getNome()+" alugado por "+usuarios.getValue().getNome()+"|hs:"+livros.getKey());
				}		
			}
		}
	}
	
	
	
}
