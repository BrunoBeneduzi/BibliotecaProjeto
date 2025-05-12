package Biblioteca.Biblioteca.menu;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.service.exclusao.BibliotecaServiceExclusao;

@Service
public class BibliotecaMenuExcluir {
	@Autowired
	private BibliotecaServiceExclusao excluir;
	private Scanner sc = new Scanner(System.in);
	
	public void menuExcluirLivro() {
		
		System.out.print("Digite o que deseja excluir"+"\n1- Livros"+"\n2- Revistas"+"\n-> ");
		
		int escolha = sc.nextInt();
		sc.nextLine();
		
		switch(escolha){
			case 1:
				this.excluir.excluirLivroPorTitulo();
				break;
			case 2:
				this.excluir.excluirRevista();
				break;
			default:
				System.out.println("Digito invalido");
		}		
	}
}