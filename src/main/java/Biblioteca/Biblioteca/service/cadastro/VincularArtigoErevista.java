package Biblioteca.Biblioteca.service.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.ArtigoModel;
import Biblioteca.Biblioteca.model.RevistaModel;
import Biblioteca.Biblioteca.repository.ArtigoRepository;
import Biblioteca.Biblioteca.repository.RevistaReposiroty;

@Service
public class VincularArtigoErevista {
	@Autowired
	private ArtigoRepository artigoRepository;
	@Autowired
	private RevistaReposiroty revistaReposiroty;
	@Autowired
	private CadastroArtigo artigo;
	@Autowired
	private CadastroRevista revista;
	
	
	public void vinculaArtigoErevista() {
		RevistaModel revista = null;
		
		try {
			revista = this.revista.cacheRevista();
			this.revistaReposiroty.save(revista);
			
			ArtigoModel artigo = this.artigo.adicionarArtigoNaLista();
			
				if(artigo.getRevista() != null) {
					System.out.println("----------------------------  o artigo já está vinculado a outra revista ----------------------------");
				}else {
					artigo.setRevista(revista);
					
					this.artigoRepository.save(artigo);
				}
			
		}catch(InvalidDataAccessApiUsageException e) {
			System.out.println("----------------------------   A revista não existe ---------------------------- ");
		}
		
	
	}
	
}
