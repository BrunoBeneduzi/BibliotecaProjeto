package Biblioteca.Biblioteca.service.listagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaServiceListagem {
	@Autowired
	private ListagemComFiltrosAutor listarComFiltrosAutor;
	@Autowired
	private ListagemComFiltrosLivros listarComFiltrosLivro;
	@Autowired
	private ListagemComFiltroRevista listarComFiltroRevista;
	@Autowired
	private ListagemComFiltroArtigo listarComFiltroArtigo;
	
	
	public  void listarLivrosVinculadosNoAutor() {
		this.listarComFiltrosAutor.listarAutoresComLivrosVinculados();
	}
	
	public void listarLivroPorTitulo() {
		this.listarComFiltrosLivro.listarLivrosPorTitulo();
	}

	public void listarLivroPorGenero() {
		this.listarComFiltrosLivro.listarLivrosPorGenero();
	}
	
	public void listarAutorPorNomeSobrenome() {
		this.listarComFiltrosLivro.listaAutoresPorSobrenome();
	}
	
	public void listarAutores() {
		this.listarComFiltrosAutor.listarAutores();
	}
	
	public void listarLivros() {
		this.listarComFiltrosLivro.listarLivros();
	}
	
	public void listarRevistas() {
		this.listarComFiltroRevista.exibeRevistas();
	}
	
	public void listarArtigos() {
		this.listarComFiltroArtigo.exibieArtigos();
	}
	
	public void listarRevistasPorSobreNomeDoAutor(){
			this.listarComFiltroRevista.exibeRevistasAutoresComArtigosVinculados();
	}
	
	public void listarPorTituloDaRevista() {
		this.listarComFiltroRevista.listarRevistaPorTitulo();
	}
	
	
}