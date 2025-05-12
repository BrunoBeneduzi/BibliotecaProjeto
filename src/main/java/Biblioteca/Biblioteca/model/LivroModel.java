package Biblioteca.Biblioteca.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "livros")
public class LivroModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo", nullable = false, unique = true)
	private String titulo;
	
	@Column(name = "editora", nullable = false)
	private String editora;
	
	@Column(name = "dataDepublicacao", nullable = false)
	private LocalDate dataPublicacao;
	
	@Enumerated(EnumType.STRING)
	private GeneroLivro genero;
	
	@ManyToMany(mappedBy = "livros", fetch = FetchType.EAGER)
	private List<AutorModel> autores = new ArrayList<>();

	public LivroModel() {}

	public LivroModel(String titulo, String editora, LocalDate dataPublicacao, GeneroLivro genero) {
		this.titulo = titulo;
		this.editora = editora;
		this.dataPublicacao = dataPublicacao;
		this.genero = genero;
	}
	
	public LivroModel(String titulo, String editora, LocalDate dataPublicacao, GeneroLivro genero,List<AutorModel> autores) {
		this.titulo = titulo;
		this.editora = editora;
		this.dataPublicacao = dataPublicacao;
		this.genero = genero;
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public GeneroLivro getGenero() {
		return genero;
	}

	public void setGenero(GeneroLivro genero) {
		this.genero = genero;
	}

	public List<AutorModel> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorModel> autores) {
		this.autores = autores;
	}

	@Override
	public String toString() {
		return "LivroModel [id=" + id + ", titulo=" + titulo + ", editora=" + editora + ", dataPublicacao="
				+ dataPublicacao + ", genero=" + genero + "]";
	}

	

	
	
	 
}