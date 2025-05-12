package Biblioteca.Biblioteca.service.exclusao;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.ArtigoModel;
import Biblioteca.Biblioteca.model.RevistaModel;
import Biblioteca.Biblioteca.repository.ArtigoRepository;
import Biblioteca.Biblioteca.repository.RevistaReposiroty;


@Service
public class ExcluirRevista {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private RevistaReposiroty revistaReposiroty;
	@Autowired
	private ArtigoRepository artigoRepository;
	
	
	public void excluirRevista() {
		System.out.print("Digite a editora que deseja excluir -> ");
		String nomeEditora = sc.nextLine().toUpperCase().trim();
		
		System.out.print("Digite o numero da edicao -> ");
		int numEdicao = sc.nextInt();
		sc.nextLine();
		
		RevistaModel revista =  this.revistaReposiroty.findByEditoraAndNumeroDeEdicao(nomeEditora, numEdicao).get();
		
		for(ArtigoModel artigo : revista.getArtigo()) {
			artigo.setRevista(null);
			this.artigoRepository.save(artigo);
		}
		this.revistaReposiroty.delete(revista);
	}
}

