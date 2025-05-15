package Biblioteca.Biblioteca.service.cadastro;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.GeneroLivro;
import Biblioteca.Biblioteca.model.LivroModel;
import Biblioteca.Biblioteca.repository.LivrosRepository;
import Biblioteca.Biblioteca.service.VerificaData;


@Service
public class CadastroLivro {
	@Autowired
	private LivrosRepository livrosRepository;
	private Scanner sc = new Scanner(System.in);
	private VerificaData verificaData = new VerificaData();
	
	
	public LivroModel adicionaLivrosNaLista() {
		LivroModel livro = new LivroModel(this.cadastraTituloLivro().toUpperCase(), this.cadastraEditora().toUpperCase(), this.cadastraDataDePublicacao(), this.cadastraGenero());
		return livro;
	}
	
	 private String cadastraTituloLivro() {
	    String tituloLivro;
	    Boolean verifica = true;
	    	
	    System.out.print("Digite o nome do livro-> ");
		    do {
		    		tituloLivro = sc.nextLine().toUpperCase();
			    if(livrosRepository.findByTitulo(tituloLivro).isPresent()) {
			    	System.out.print("O nome já foi cadastrado, digite outro novamente ->");
			    }else {
			    	verifica = false;
			    }
		    }while(verifica);
	    	
	    return tituloLivro;
	  }
	  
	 private String cadastraEditora() {
		  System.out.print("Digite o nome da editora -> ");
		  return sc.nextLine().trim();
	  }
	  
	 private LocalDate cadastraDataDePublicacao() {
			return this.verificaData.verificaData();
	  }
	  
	 private GeneroLivro cadastraGenero(){
			List<GeneroLivro> genero = Arrays.asList(GeneroLivro.values());
			GeneroLivro listaGenero;
			
			System.out.println("Selecione qual o genero do livro");
			
			IntStream.range(0, genero.size()).forEach(i -> System.out.println((i + 1) + " - " + genero.get(i)));
			
			listaGenero = genero.get(sc.nextInt() - 1);
			
			return listaGenero;
		}
	
}
