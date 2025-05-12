package Biblioteca.Biblioteca.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "revistas")
public class RevistaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "editora", nullable = false)
	private String editora;
	@Column(name = "numeroDeEdicao", nullable = false)
	private int numeroDeEdicao;
	@Column(name = "dataDePublicacao", nullable = false)
	private LocalDate dataDePublicacao;
	@OneToMany(mappedBy = "revista", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<ArtigoModel> artigo;
	
	public RevistaModel() {
		
	}
	
	public RevistaModel(String editora, int numeroDeEdicao, LocalDate dataDePublicacao) {
		this.editora = editora;
		this.numeroDeEdicao = numeroDeEdicao;
		this.dataDePublicacao = dataDePublicacao;
	}

	public RevistaModel(String editora, int numeroDeEdicao, LocalDate dataDePublicacao, List<ArtigoModel> artigo) {
		this.editora = editora;
		this.numeroDeEdicao = numeroDeEdicao;
		this.dataDePublicacao = dataDePublicacao;
		this.artigo = artigo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getNumeroDeEdicao() {
		return numeroDeEdicao;
	}

	public void setNumeroDeEdicao(int numeroDeEdicao) {
		this.numeroDeEdicao = numeroDeEdicao;
	}

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

	public void setDataDePublicacao(LocalDate dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public List<ArtigoModel> getArtigo() {
		return artigo;
	}

	public void setArtigo(List<ArtigoModel> artigo) {
		this.artigo = artigo;
	}

	@Override
	public String toString() {
		return "RevistaModel [id=" + id + ", editora=" + editora + ", numeroDeEdicao=" + numeroDeEdicao
				+ ", dataDePublicacao=" + dataDePublicacao + "]";
	}	
}