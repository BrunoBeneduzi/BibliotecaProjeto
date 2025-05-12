package Biblioteca.Biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Biblioteca.Biblioteca.model.GeneroLivro;
import Biblioteca.Biblioteca.model.LivroModel;

public interface LivrosRepository extends JpaRepository<LivroModel, Long>{
	Optional<LivroModel> findByTitulo(String nome);
	
	@Query("SELECT l FROM LivroModel l JOIN l.autores a WHERE l.titulo = :titulo")
    List<LivroModel> findByRetornaTitulo(@Param("titulo") String titulo);
	
	List<LivroModel> findByGenero(GeneroLivro generoLivro);
	

	@Query("SELECT DISTINCT a FROM AutorModel a JOIN a.artigos art WHERE a.nomeCompleto LIKE %:sobrenome%")
    List<LivroModel> findLivrosByAutorSobrenome(@Param("sobrenome") String sobrenome);
    

}
