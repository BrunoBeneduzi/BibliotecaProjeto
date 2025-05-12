package Biblioteca.Biblioteca.service.atualizacao;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.model.RevistaModel;
import Biblioteca.Biblioteca.repository.RevistaReposiroty;

@Service
public class AtualizarRevista {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private RevistaReposiroty revistaReposiroty;
	
	public RevistaModel escolheRevistaParaEditar() {
		System.out.print("Digite a editora da revista que deseja editar -> ");
		String titulo = sc.nextLine().toUpperCase().trim();
		
		System.out.print("Digite o numero da edição ->");
		int numEdicao = sc.nextInt();
		sc.nextLine();
		
		return this.revistaReposiroty.findByEditoraAndNumeroDeEdicao(titulo, numEdicao).get();
		
	}
	
	public void atualizarRevistaEditora() {
		RevistaModel revista = this.escolheRevistaParaEditar();
		
		System.out.print("Nome da editora antiga "+revista.getEditora()+" Digite a nova editora -> ");
		String novoNome = sc.nextLine().toUpperCase().trim();
		
		revista.setEditora(novoNome);
		
		this.revistaReposiroty.save(revista);		
	}
	
	public void atualizarRevistaDataDepublicacao() {
		
	}
}