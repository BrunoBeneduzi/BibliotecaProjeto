package Biblioteca.Biblioteca.service.cadastro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.ArtigoModel;
import Biblioteca.Biblioteca.model.AutorModel;
import Biblioteca.Biblioteca.model.GeneroLivro;
import Biblioteca.Biblioteca.model.LivroModel;
import Biblioteca.Biblioteca.model.RevistaModel;
import Biblioteca.Biblioteca.repository.ArtigoRepository;
import Biblioteca.Biblioteca.repository.AutorRepository;
import Biblioteca.Biblioteca.repository.LivrosRepository;
import Biblioteca.Biblioteca.repository.RevistaReposiroty;

@Service
public class CadastraAutorEartigo {
	@Autowired
    private AutorRepository autorRepository;
	@Autowired
	private ArtigoRepository artigoRepository;
	@Autowired
	private LivrosRepository livrosRepository;
	@Autowired
	private RevistaReposiroty revistaReposiroty;
	@Autowired
	private CadastroArtigo artigo;
	@Autowired
	private CadastroAutor autor;
	
	public void popularBanco(){
		List<ArtigoModel> artigo = new ArrayList<>();
		List<LivroModel> livro = new ArrayList<>();
		List<AutorModel> autor = new ArrayList<>();
		List<RevistaModel> revista = new ArrayList<>();

		// Cadastro de livros
		livro.add(new LivroModel("O SENHOR DOS ANEIS","ESTRELA",LocalDate.of(2000, 01, 21), GeneroLivro.AVENTURA));
		livro.add(new LivroModel("O SENHOR DOS ANEIS E AS DUAS TORRES","ESTRELA",LocalDate.of(2001, 01, 21), GeneroLivro.AVENTURA));
		livro.add(new LivroModel("O SENHOR DOS ANEIS E A SOCIEDADE DO ANEL","ESTRELA",LocalDate.of(2002, 01, 21), GeneroLivro.AVENTURA));
		livro.add(new LivroModel("O GUIA DO MOCHILEIRO DAS GALAXIAS","CUBO",LocalDate.of(2010, 01, 21), GeneroLivro.COMEDIA));
		livro.add(new LivroModel("A HISTORIA DO MUNDO","VERMELHO LTDA",LocalDate.of(2020, 01, 21), GeneroLivro.FANTASIA));

		this.livrosRepository.saveAll(livro);

		// Cadastro de revistas
		revista.add(new RevistaModel("PEOPLES DAY",1, LocalDate.of(2015, 07, 01)));
		revista.add(new RevistaModel("PEOPLES DAY",2, LocalDate.of(2016, 07, 01)));
		revista.add(new RevistaModel("CIENCIA BOOK",1, LocalDate.of(2015, 07, 01)));
		revista.add(new RevistaModel("2012 FIM",1, LocalDate.of(2012, 12, 12)));
		revista.add(new RevistaModel("2000 FIM",1, LocalDate.of(2000, 01, 01)));

		
		this.revistaReposiroty.saveAll(revista);

		// Cadastro de artigos
		artigo.add(new ArtigoModel("GUERRA SANTA", "GUERRA SANTA FOI UMA GUERRA SANTA"));
		artigo.add(new ArtigoModel("COMO A SEGUNDA GUERRA MUNDIAL NOS AFETOU", "A SEGUNDA GUERRA MUNDIAL ACONTECEU FAZ UM TEMPO"));
		artigo.add(new ArtigoModel("COMO FOI FEITO UM ARMÁRIO", "OS ARMÁRIOS SÃO ÚTEIS PARA GUARDAR COISAS"));
		artigo.add(new ArtigoModel("COMO ANDAR NA RUA FAZ BEM PARA O CORPO", "ANDAR FAZ BEM PARA O CORPO POIS É UM EXERCÍCIO"));

		// Associando artigos às revistas
		artigo.get(0).setRevista(revista.get(0));
		artigo.get(1).setRevista(revista.get(1));
		artigo.get(2).setRevista(revista.get(2));
		artigo.get(3).setRevista(revista.get(3));

	
		this.artigoRepository.saveAll(artigo);

		// Cadastro de autores
		autor.add(new AutorModel("BRUNO BENEDUZI BERNARDES", LocalDate.of(2000, 03, 21), "BRASILEIRO"));
		autor.add(new AutorModel("SILVIO SANTOS", LocalDate.of(2000, 03, 21), "BRASILEIRO"));
		autor.add(new AutorModel("BRUCE WAYNE", LocalDate.of(2000, 03, 21), "AMERICANO"));

		// Associando artigos aos autores
		autor.get(0).getArtigos().add(artigo.get(0));
		autor.get(0).getArtigos().add(artigo.get(1));
		autor.get(1).getArtigos().add(artigo.get(2));
		autor.get(2).getArtigos().add(artigo.get(3));

		// Associando livros aos autores
		autor.get(0).getLivros().add(livro.get(0));
		autor.get(0).getLivros().add(livro.get(1));
		autor.get(0).getLivros().add(livro.get(2));
		autor.get(1).getLivros().add(livro.get(3));
		autor.get(2).getLivros().add(livro.get(4));

		
		this.autorRepository.saveAll(autor);
	}
	
	
	public void cadastraAutorEartigo() {
		ArtigoModel artigo = this.artigo.adicionarArtigoNaLista();
		
		this.artigoRepository.save(artigo);
		
		AutorModel autor = this.autor.adicionarAutoresNaLista();
		
		autor.setArtigos(artigo);
		
		this.autorRepository.save(autor);
	}
}