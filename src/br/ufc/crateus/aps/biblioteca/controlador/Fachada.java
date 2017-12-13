package br.ufc.crateus.aps.biblioteca.controlador;



import br.ufc.crateus.aps.biblioteca.controlador.entidade.DestinatarioAdapter;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Fornecedor;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Livro;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Permissao;
import br.ufc.crateus.aps.biblioteca.controlador.entidade.Usuario;
import br.ufc.crateus.aps.biblioteca.controlador.repositorio.FornecedorRepositorio;
import br.ufc.crateus.aps.biblioteca.controlador.repositorio.LivroRepositorio;
import br.ufc.crateus.aps.biblioteca.controlador.repositorio.UsuarioRepositorio;

public class Fachada {

	
	public static Fachada fat;
	
	public static Fachada getObjeto(){
		fat = new Fachada();
		return fat;
	}
	
	
	public static void adicionarCarrinho(Livro livros){
		LivroRepositorio.AddCarrinho(livros);
	}
	
	public static void finalizarComprar(Usuario u,String forma){
		if(autenticar(u.getLogin(),u.getSenha()) == null){
			System.out.println("Não está cadastrado");
		}else{
			if(LivroRepositorio.haItensCarrinho() == false){
				System.out.println("Não há livros no carrinho");
			}else{
				LivroRepositorio.formaPagamento(forma);
				LivroRepositorio.vendeLivro();
			}
		}
	}
	
	public static void finalizarAluguel(Usuario u,int tempo,String forma){
		if(autenticar(u.getLogin(),u.getSenha()) == null){
			System.out.println("Não está cadastrado");
		}else{
			if(LivroRepositorio.haItensCarrinho() == false){
				System.out.println("Não há livros no carrinho");
			}else{
			LivroRepositorio.addLivroAlugado(tempo);
			LivroRepositorio.formaPagamento(forma);
			LivroRepositorio.addUsuarioAlugou(u);
			}
		}
	}
	
	public static Usuario autenticar(String login, String senha) {
		if (UsuarioRepositorio.getUsuarioPorLogin(login, senha) == null) {
			return null;
		} else {
			return UsuarioRepositorio.getUsuarioPorLogin(login, senha);
		}
	}
	
	public static void adicionarInterecados(Usuario u){
		if(LivroRepositorio.addInterecados(u) == true){
			System.out.println("novo interessado adicionado");
		}else{
			System.out.println("interessado não adicionado");
		}
	}

	public static Usuario buscarUsuario(Usuario u, String nome) {
		if (autenticar(u.getLogin(), u.getSenha()) == null)
			return null;
		return UsuarioRepositorio.getUsuarioPorNome(nome);
	}

	
	public static void cadastrarLivro(Usuario admin, Livro livro) {
		if (admin.getPerfil().getPermissoes().contains(Permissao.cadastrar_livro)){
			LivroRepositorio.addItem(livro);		
			LivroRepositorio.notificarCliente();
			System.out.println(admin.getNome() + " cadastrou livro");
		} else {
			System.out.println(admin.getNome()+" não tem permissão\n");
		}

	}
	
	public static void cadastrarUsuario(Usuario user,Usuario novo){
		if(user.getPerfil().getPermissoes().contains(Permissao.cadastrar_usuario)){
			UsuarioRepositorio.setUsuario(novo);
			System.out.println(user.getNome()+" cadastrou novo usuário");
		}else{
			System.out.println(user.getNome()+" não tem permissão para cadastrar usuário");
		}
	}
	
	public static void usuarioCadastrouse(Usuario novo){
			UsuarioRepositorio.setUsuario(novo);
			System.out.println("Usuario cadastrou-se");	
	}
	
	public static void cadastrarFornecedor(Usuario user,Fornecedor novo){
		if(user.getPerfil().getPermissoes().contains(Permissao.cadastrar_fornecedor)){
			FornecedorRepositorio.setFornecedor(novo);
			System.out.println(user.getNome()+" cadastrou novo Fornecedor");
		}else{
			System.out.println(user.getNome()+" não tem permissão para cadastrar fornecedores");
		}
	}
	
	public static void enviarMensagem(DestinatarioAdapter... destinatarios){
		for(DestinatarioAdapter p: destinatarios){
			p.enviarMensagem("Livro de cod xxxx estava imcompleto");
		}
	}
	
	public int teste(){
		
		return 1;
	}
	
	//&& FornecedorRepositorio.getFornecedorPorCnpj(novo.getCnpj()).equals(novo.getCnpj())
	
	
}
