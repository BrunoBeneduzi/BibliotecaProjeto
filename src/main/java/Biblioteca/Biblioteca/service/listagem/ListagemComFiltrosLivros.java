package Biblioteca.Biblioteca.service.listagem;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.GeneroLivro;
import Biblioteca.Biblioteca.model.LivroModel;
import Biblioteca.Biblioteca.repository.LivrosRepository;

@Service
public class ListagemComFiltrosLivros {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private LivrosRepository livrosRepository;
	
	
	public void listaAutoresPorSobrenome() {
		System.out.print("Digite o nome ou sobrenome do autor -> ");
		String nomeCompleto = sc.nextLine().toUpperCase();
		
		List<LivroModel> livro = this.livrosRepository.findLivrosByAutorSobrenome(nomeCompleto);
		
		for(LivroModel livroLista:livro) {
			System.out.println(livroLista.getAutores() + " " + livroLista);
		}
	}
	
	public void listarLivros() {
		List<LivroModel> livro = this.livrosRepository.findAll();
		
		for(LivroModel livroLista: livro) {
			System.out.println(livroLista);
		}
	}
	
	public void listarLivrosPorGenero() {
		GeneroLivro generoLivro = null;
		Boolean verifica = true;
		System.out.print("Digite o genero que deseja buscar -> ");
		
		do {
			String genero = sc.nextLine().trim().toUpperCase().replace(" ", "_");
				try {
					generoLivro = GeneroLivro.valueOf(genero);
					verifica = false;
				}catch(IllegalArgumentException e){
					System.out.print("Genero não existente, Digite novamente -> ");
				}
				
		}while(verifica);
		
		List<LivroModel> livro =  this.livrosRepository.findByGenero(generoLivro);
		
		for(LivroModel livroListsa: livro) {
			System.out.println(livroListsa);
		}
	}
	
	public void listarLivrosPorTitulo() {
		System.out.print("Digite o titulo que deseja buscar -> ");
		String titulo = sc.nextLine().toUpperCase();
		
		
		List<LivroModel> livro =  this.livrosRepository.findByRetornaTitulo(titulo);
		
		for(LivroModel livroListsa: livro) {
			System.out.println(livroListsa + " " + livroListsa.getAutores());
		}
	}
	
}
