package Biblioteca.Biblioteca.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import Biblioteca.Biblioteca.model.AutorModel;



public interface AutorRepository extends JpaRepository <AutorModel, Long>{
	
	 Optional<AutorModel> findByNomeCompleto(String nome);
	 
	 @Query("SELECT a FROM AutorModel a WHERE a.nomeCompleto = :nomeCompleto")
	 AutorModel cadastrarCacheDeAutor(@Param("nomeCompleto") String nome);

	 
	@Query("SELECT a FROM AutorModel a JOIN a.livros l")
	List<AutorModel> findByRetornaAutoresComLivrosVinculados();
	
	
	 @Query("SELECT a FROM AutorModel a JOIN a.artigos l WHERE a.nomeCompleto LIKE %:sobrenome%")
	 List<AutorModel> findArtigosByAutorSobrenome(@Param("sobrenome") String sobrenome);
}