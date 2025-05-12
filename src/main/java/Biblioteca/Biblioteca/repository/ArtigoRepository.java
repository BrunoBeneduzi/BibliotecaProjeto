package Biblioteca.Biblioteca.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import Biblioteca.Biblioteca.model.ArtigoModel;

public interface ArtigoRepository extends JpaRepository<ArtigoModel, Long>{
	Optional<ArtigoModel> findByTitulo(String nome);
	
	
	
}