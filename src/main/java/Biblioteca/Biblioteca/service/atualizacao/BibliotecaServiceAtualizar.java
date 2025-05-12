package Biblioteca.Biblioteca.service.atualizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaServiceAtualizar {
	@Autowired
	private AtualizarLivro atualizaLivro;
	@Autowired
	private AtualizarAutor atualizaAutor;
	@Autowired
	private AtualizarRevista atualizaRevista;
	@Autowired
	private AtualizarArtigo atualizarArtigo;
	
	//livros
	public void atualizaLivroTitulo() {
		this.atualizaLivro.editaTitulo();
	}
	
	public void atualizaLivroGenero() {
		this.atualizaLivro.editaGenero();
	}
	
	public void atualizaLivroEditora() {
		this.atualizaLivro.editarEditora();
	}
	
	public void atualizarLivroDataPublicacao() {
		this.atualizaLivro.editarDataDePublicacao();
	}
	
	//autor
	public void atualizarNomeDoAutor() {
		this.atualizaAutor.editarNomeAutor();
	}
	
	public void atualizarDataNascimentoAutor() {
		this.atualizaAutor.editarDataDeNascimentoAutor();
	}
	
	public void atualizarNacionalidadeAutor() {
		this.atualizaAutor.editarNacionalidadeAutor();
	}
	
	//revista
	
	public void atualizarEditoraRevista() {
		this.atualizaRevista.atualizarRevistaEditora();
	}
	
	//artigos
	
	public void atualizarArtigoTitulo() {
		this.atualizarArtigo.atualizarArtigoTitulo();
	}
	
	public void atualizarArtigoTexto() {
		this.atualizarArtigo.atualizarArtigoTexto();
	}
}