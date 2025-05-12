package Biblioteca.Biblioteca.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class AutorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nomeCompleto", nullable = false, unique = true)
	private String nomeCompleto;
	
	@Column(name = "dataDeNascimento", nullable = false)
	private LocalDate dataDeNascimento;
	
	@Column(name = "nacionalidade", nullable = false)
	private String nacionalidade;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<LivroModel> livros = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<ArtigoModel> artigos = new ArrayList<>();
	

	public AutorModel() {}
	
	public AutorModel(String nomeCompleto, LocalDate dataDeNascimento, String nacionalidade) {
		this.nomeCompleto = nomeCompleto;
		this.dataDeNascimento = dataDeNascimento;
		this.nacionalidade = nacionalidade;
	}
	
	public AutorModel(String nomeCompleto, LocalDate dataDeNascimento, String nacionalidade, List<LivroModel> livros) {
		this.nomeCompleto = nomeCompleto;
		this.dataDeNascimento = dataDeNascimento;
		this.nacionalidade = nacionalidade;
		this.livros = livros;
	}
	
	public AutorModel(String nomeCompleto, LocalDate dataDeNascimento, String nacionalidade, List<LivroModel> livros, List<ArtigoModel> artigos) {
		this.nomeCompleto = nomeCompleto;
		this.dataDeNascimento = dataDeNascimento;
		this.nacionalidade = nacionalidade;
		this.livros = livros;
		this.artigos = artigos;
	}

	public String getNomeCompleto() {return nomeCompleto;}
	
	public void setNomeCompleto(String nomeCompleto) {this.nomeCompleto = nomeCompleto;}
	
	public LocalDate getDataDeNascimento() {return dataDeNascimento;}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {this.dataDeNascimento = dataDeNascimento;}

	public String getNacionalidade() {return nacionalidade;}
	
	public void setNacionalidade(String nacionalidade) {this.nacionalidade = nacionalidade;}
	
	public List<LivroModel> getLivros() {return livros;}
	
	public void setLivros(List<LivroModel> livros) {this.livros = livros;}
	
	public void setLivros(LivroModel livros) {this.livros.add(livros);}
	
	
	public List<ArtigoModel> getArtigos() {return artigos;}
	
	public void setArtigos(ArtigoModel artigos) {this.artigos.add(artigos);}
	
	public void setArtigos(List<ArtigoModel> artigos) {this.artigos = artigos;}

	@Override
	public String toString() {
		return "AutorModel [id=" + id + ", nomeCompleto=" + nomeCompleto + ", dataDeNascimento=" + dataDeNascimento
				+ ", nacionalidade=" + nacionalidade+"]";
	}
	
}