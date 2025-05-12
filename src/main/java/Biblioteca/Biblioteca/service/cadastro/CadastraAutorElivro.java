package Biblioteca.Biblioteca.service.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Biblioteca.Biblioteca.model.AutorModel;
import Biblioteca.Biblioteca.model.LivroModel;
import Biblioteca.Biblioteca.repository.AutorRepository;
import Biblioteca.Biblioteca.repository.LivrosRepository;


@Service
public class CadastraAutorElivro {
	@Autowired
    private AutorRepository autorRepository;
	@Autowired
	private LivrosRepository livrosRepository;
	@Autowired
	private CadastroAutor autor;
	@Autowired
	private CadastroLivro livro;
	
	
	public void cadastraLivroEautor() {
		LivroModel livroModel = this.livro.adicionaLivrosNaLista();
		
		this.livrosRepository.save(livroModel);
		
		AutorModel autorModel = this.autor.adicionarAutoresNaLista();
		
		autorModel.setLivros(livroModel);
		
		this.autorRepository.save(autorModel);
		
	}
	
}