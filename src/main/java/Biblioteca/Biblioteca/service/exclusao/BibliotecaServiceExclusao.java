package Biblioteca.Biblioteca.service.exclusao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaServiceExclusao {
	@Autowired
	private ExcluiLivros excluirLivro;
	@Autowired
	private ExcluirRevista excluirRevista;
	
	public void excluirLivroPorTitulo() {
		this.excluirLivro.excluiLivro();
	}
	
	public void excluirRevista() {
		this.excluirRevista.excluirRevista();
	}
}
