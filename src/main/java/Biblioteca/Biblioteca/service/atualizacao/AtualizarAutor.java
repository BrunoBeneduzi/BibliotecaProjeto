package Biblioteca.Biblioteca.service.atualizacao;

import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Biblioteca.Biblioteca.model.AutorModel;
import Biblioteca.Biblioteca.repository.AutorRepository;
import Biblioteca.Biblioteca.service.VerificaData;

@Service
public class AtualizarAutor {
	@Autowired
	private AutorRepository autorRepository;
	private VerificaData data = new VerificaData();
	private Scanner sc = new Scanner(System.in);
	
	
	private AutorModel escolheAutor() {
		System.out.print("Digite o nome do autor que deseja editar -> ");
		String nome = sc.nextLine().toUpperCase();
		
		Optional<AutorModel> livros = this.autorRepository.findByNomeCompleto(nome);
		
		AutorModel autorModel = livros.get();
		
		return autorModel;
	}
	
	
	public void editarNomeAutor() {
		AutorModel autor = this.escolheAutor();
		String novoNome;
		Boolean verifica = true;
		
		System.out.print("Nome antigo: "+autor.getNomeCompleto()+" Digite a correção do nome -> ");

	    do {
	    	novoNome = sc.nextLine().toUpperCase();
		    if(this.autorRepository.findByNomeCompleto(novoNome).isPresent()) {
		    	System.out.print("O nome já foi cadastrado, digite outro novamente ->");
		    }else {
		    	verifica = false;
		    }
	    }while(verifica);
	    
	    autor.setNomeCompleto(novoNome);
	    this.autorRepository.save(autor);
	}
	
	public void editarDataDeNascimentoAutor() {
		AutorModel autor = this.escolheAutor();
		
		System.out.print("Digite a nova data de nascimento do autor, ");
		
		autor.setDataDeNascimento(data.verificaData());
		
		this.autorRepository.save(autor);
	}
	
	public void editarNacionalidadeAutor() {
		AutorModel autor = this.escolheAutor();
		
		System.out.print("Digite a correção da nacionalidade do autor ->");
		String novaNacionalidade = sc.nextLine().toUpperCase();
		
		autor.setNacionalidade(novaNacionalidade);
		this.autorRepository.save(autor);
	}
}