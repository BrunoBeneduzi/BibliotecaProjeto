package Biblioteca.Biblioteca.service.cadastro;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Biblioteca.Biblioteca.model.ArtigoModel;
import Biblioteca.Biblioteca.repository.ArtigoRepository;

@Service
public class CadastroArtigo {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private ArtigoRepository artigoRepository;
	
	
	
	
	public ArtigoModel adicionarArtigoNaLista() {
		ArtigoModel artigo = null;
		
		System.out.print("Digite o titulo do artigo -> ");
		String tituloArtigo = sc.nextLine().toUpperCase().trim();
		System.out.println();
		
		
		if(this.cadastraTituloDoArtigo(tituloArtigo)) {
			return artigo = this.artigoRepository.findByTitulo(tituloArtigo).get();
		}else {
			artigo = new ArtigoModel(tituloArtigo, this.cadastraTextoPublicacao());
		}
		return artigo;
		
	}
	
	private Boolean cadastraTituloDoArtigo(String titulo) {
		
		if(this.artigoRepository.findByTitulo(titulo).isPresent()) {
			return true;
		}
		return false;
	}
	
	private String cadastraTextoPublicacao() {
		System.out.print("Digite o texto de publicação do artigo -> ");
		return sc.nextLine().toUpperCase().trim();
	}
}