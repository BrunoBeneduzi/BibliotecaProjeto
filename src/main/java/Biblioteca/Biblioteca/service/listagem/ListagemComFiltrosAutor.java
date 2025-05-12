package Biblioteca.Biblioteca.service.listagem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Biblioteca.Biblioteca.model.AutorModel;
import Biblioteca.Biblioteca.repository.AutorRepository;



@Service
public class ListagemComFiltrosAutor {
	@Autowired
	private AutorRepository autorRepository;
	
	
	public void listarAutoresComLivrosVinculados() {
		List<AutorModel> autor = this.autorRepository.findByRetornaAutoresComLivrosVinculados();
		
		for(AutorModel autorLista: autor) {
			System.out.println(autorLista + " " + autorLista.getLivros());
		}
	}
	
	public void listarAutores() {
		List<AutorModel> autor = this.autorRepository.findAll();
		
		for(AutorModel autores: autor) {
			System.out.println(autores);
		}
	}
	
	
	
	
	
	
	
	
}