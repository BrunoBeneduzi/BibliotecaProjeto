package Biblioteca.Biblioteca.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "artigos")
public class ArtigoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo", nullable = false, unique = true)
	private String titulo;
	@Column(name = "textoDePublicacao", nullable = false)
	private String textoDePublicacao;
	@ManyToOne
	@JoinColumn(name = "revista_id")
	private RevistaModel revista;
	@ManyToMany(mappedBy = "artigos", fetch = FetchType.EAGER)
	private List<AutorModel> autor;
	
	public ArtigoModel() {
		
	}
		
	public ArtigoModel(String titulo, String textoDePublicacao) {
		this.titulo = titulo;
		this.textoDePublicacao = textoDePublicacao;
	}

	public ArtigoModel(String titulo, String textoDePublicacao, RevistaModel revista) {
		this.titulo = titulo;
		this.textoDePublicacao = textoDePublicacao;
		this.revista = revista;
	}

	public ArtigoModel(String titulo, String textoDePublicacao, RevistaModel revista, List<AutorModel> autor) {
		this.titulo = titulo;
		this.textoDePublicacao = textoDePublicacao;
		this.revista = revista;
		this.autor = autor;
	}
	
	public String getTitulo() {return titulo;}
	
	public void setTitulo(String titulo) {this.titulo = titulo;}
	
	public String getTextoDePublicacao() {return textoDePublicacao;}
	
	public void setTextoDePublicacao(String textoDePublicacao) {this.textoDePublicacao = textoDePublicacao;}
	
	public RevistaModel getRevista() {return revista;}
	
	public void setRevista(RevistaModel revista) {this.revista = revista;}
	
	public List<AutorModel> getAutor() {return autor;}
	
	public void setAutor(List<AutorModel> autor) {this.autor = autor;}
	
	@Override
	public String toString() {
		return "ArtigoModel [id=" + id + ", titulo=" + titulo + ", textoDePublicacao=" + textoDePublicacao+" ]";
	}
}