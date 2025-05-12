package Biblioteca.Biblioteca.service.atualizacao;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.ArtigoModel;
import Biblioteca.Biblioteca.repository.ArtigoRepository;

@Service
public class AtualizarArtigo {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private ArtigoRepository artigoRepository;
	
	public ArtigoModel escolheArtigo() {
		System.out.print("Digite o titulo do artigo que deseja atualizar ->");
		String titulo = sc.nextLine().toUpperCase().trim();
		
		return this.artigoRepository.findByTitulo(titulo).get();
	}
	
	public void atualizarArtigoTitulo() {
		ArtigoModel artigo = this.escolheArtigo();
		
		System.out.print("Digite o novo titulo do artigo ->");
		String novoTitulo = sc.nextLine().toUpperCase().trim();
		
		artigo.setTitulo(novoTitulo);
		
		this.artigoRepository.save(artigo);
	}
	
	public void atualizarArtigoTexto() {
		ArtigoModel artigo = this.escolheArtigo();
		
		System.out.print("Digite o novo texto do artigo -> ");
		String novoTexto = sc.nextLine().toUpperCase().trim();
		
		artigo.setTextoDePublicacao(novoTexto);
		
		this.artigoRepository.save(artigo);
	}
}
