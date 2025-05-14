package Biblioteca.Biblioteca.repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import Biblioteca.Biblioteca.model.RevistaModel;

public interface RevistaReposiroty extends JpaRepository<RevistaModel, Long>{
	
	 Optional<RevistaModel> findByEditoraAndNumeroDeEdicao(String editora, int numeroDeEdicao);
	 
	 List<RevistaModel> findByEditora(String editora);

}