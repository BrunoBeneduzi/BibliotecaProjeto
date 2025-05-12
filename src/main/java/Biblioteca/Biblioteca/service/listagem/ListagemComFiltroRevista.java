package Biblioteca.Biblioteca.service.listagem;

import java.util.List;
import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.ArtigoModel;
import Biblioteca.Biblioteca.model.AutorModel;
import Biblioteca.Biblioteca.model.RevistaModel;
import Biblioteca.Biblioteca.repository.AutorRepository;
import Biblioteca.Biblioteca.repository.RevistaReposiroty;

@Service
public class ListagemComFiltroRevista {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private RevistaReposiroty revistaReposiroty;
	@Autowired
	private AutorRepository autorRepository;
	
	
	/*esse metodo exibe todas as revistas que tem um artigo vinculado nela e com um autor vinculado ao artigo
	 * ou seja, se o autor escreveu 3 artigos e esses artigos estão vinculados a uma revista ou cada um vinculado a outras revistas, ele vai
	 * exibir essas revistas e os nomes do autores, entao digamos que a revista PEOPLES tenha um artigo do autor CARLOS, vai ser exibido essa revista e
	 * o autor que tem um artigo na revista
	*/
	public void exibeRevistasAutoresComArtigosVinculados() {
		System.out.print("Digite o nome ou sobrenome do autor que deseja filtrar -> ");
		String nome = sc.nextLine().toUpperCase();
		
		List<AutorModel> autor = this.autorRepository.findArtigosByAutorSobrenome(nome);
		
		
		for(AutorModel autorLista: autor) {
			System.out.println(autorLista);
			for(ArtigoModel artigoLista: autorLista.getArtigos()) {
				System.out.println(artigoLista.getRevista());
			}
		}	
	}
	
	public void exibeRevistas() {
		List<RevistaModel> revista = this.revistaReposiroty.findAll();
		
		for(RevistaModel revistaLista : revista) {
			System.out.println(revistaLista);
		}
	}
	
}
