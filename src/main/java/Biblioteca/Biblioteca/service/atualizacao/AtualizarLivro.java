package Biblioteca.Biblioteca.service.atualizacao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.GeneroLivro;
import Biblioteca.Biblioteca.model.LivroModel;
import Biblioteca.Biblioteca.repository.LivrosRepository;
import Biblioteca.Biblioteca.service.VerificaData;

@Service
public class AtualizarLivro {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private LivrosRepository livrosRepository;
	private VerificaData data = new VerificaData();
	
	private LivroModel escolheLivro() {
		System.out.print("Digite o nome do livro que deseja editar -> ");
		String livro = sc.nextLine().toUpperCase();
		
		Optional<LivroModel> livros = this.livrosRepository.findByTitulo(livro);
		
		LivroModel livroModel = livros.get();
		
		return livroModel;
	}
	
	
	public void editaGenero(){
		List<GeneroLivro> genero = Arrays.asList(GeneroLivro.values());
		GeneroLivro listaGenero;
		
		LivroModel livro = this.escolheLivro();
		
		System.out.print("Escolha o novo genero que deseja cadastrar\n");
		
		
		IntStream.range(0, genero.size()).forEach(i -> System.out.println((i + 1) + " - " + genero.get(i)));
		
		System.out.print("-> ");
		listaGenero = genero.get(sc.nextInt() - 1);
		
		livro.setGenero(listaGenero);
		
		this.livrosRepository.save(livro);
		
	}
	
	public void editaTitulo() {
		String novoTitulo;
		Boolean verifica = true;
		LivroModel livro = this.escolheLivro();
		
		System.out.print("Titulo antigo: "+livro.getTitulo()+" Digite o novo titulo -> ");

	    do {
	    	novoTitulo = sc.nextLine().toUpperCase();
		    if(livrosRepository.findByTitulo(novoTitulo).isPresent()) {
		    	System.out.print("O nome já foi cadastrado, digite outro novamente ->");
		    }else {
		    	verifica = false;
		    }
	    }while(verifica);
	    
	    livro.setTitulo(novoTitulo);
	    this.livrosRepository.save(livro);
		
	}

	public void editarEditora() {
		LivroModel livro = this.escolheLivro();
		
		System.out.print("Digite a nova editora -> ");
		String novaEditora = sc.nextLine().toUpperCase();
		
		livro.setEditora(novaEditora);
		
		this.livrosRepository.save(livro);
	}
	
	public void editarDataDePublicacao() {
		LivroModel livro = this.escolheLivro();
		
		System.out.print("Digite a nova data de publicação do livro, ");
		
		livro.setDataPublicacao(data.verificaData());
		
		this.livrosRepository.save(livro);
	}
}