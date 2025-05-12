package Biblioteca.Biblioteca.service.exclusao;


import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Biblioteca.Biblioteca.model.AutorModel;
import Biblioteca.Biblioteca.model.LivroModel;
import Biblioteca.Biblioteca.repository.AutorRepository;
import Biblioteca.Biblioteca.repository.LivrosRepository;

@Service
public class ExcluiLivros {
	@Autowired
	private LivrosRepository livrosRepository;
	@Autowired
	private AutorRepository autorRepository;
	private Scanner sc = new Scanner(System.in);
	
	public void excluiLivro() {
		System.out.print("\nDigite o titulo do livro que deseja excluir -> ");
		String tituloLivro = sc.nextLine().toUpperCase().trim();

		LivroModel livroModel = this.livrosRepository.findByTitulo(tituloLivro).get();
		
		for(AutorModel autor: livroModel.getAutores()) {
			autor.getLivros().remove(livroModel);
			autorRepository.save(autor);
		}
		livrosRepository.delete(livroModel);	
	}
}