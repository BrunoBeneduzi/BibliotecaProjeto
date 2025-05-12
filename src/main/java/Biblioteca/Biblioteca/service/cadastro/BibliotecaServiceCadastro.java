package Biblioteca.Biblioteca.service.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BibliotecaServiceCadastro {
	@Autowired
	private CadastraAutorElivro autorElivro;
	@Autowired
	private CadastraAutorEartigo autorEartigo;
	@Autowired
	private CadastroRevista revista;
	@Autowired
	private VincularArtigoErevista vincula;
		
	public void cadastrarLivroEautor() {
		this.autorElivro.cadastraLivroEautor();
	}
	
	public void cadastrarArtigoEautor() {
		this.autorEartigo.cadastraAutorEartigo();
	}
	
	public void cadastrarRevista() {
		this.revista.cadastroRevista();
	}

	public void vincularArtigoRevista() {
		this.vincula.vinculaArtigoErevista();
	}
}