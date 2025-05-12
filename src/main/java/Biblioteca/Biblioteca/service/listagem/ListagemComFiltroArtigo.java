package Biblioteca.Biblioteca.service.listagem;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.ArtigoModel;
import Biblioteca.Biblioteca.repository.ArtigoRepository;


@Service
public class ListagemComFiltroArtigo {
	@Autowired
	private ArtigoRepository artigoRepository;
	
	public void exibieArtigos() {
		List<ArtigoModel> artigo = this.artigoRepository.findAll();
		
		for(ArtigoModel artigoLista : artigo) {
			System.out.println(artigoLista);
		}
		
	}
	
	
}