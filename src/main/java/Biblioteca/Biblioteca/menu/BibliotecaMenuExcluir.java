package Biblioteca.Biblioteca.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.service.exclusao.BibliotecaServiceExclusao;

@Service
public class BibliotecaMenuExcluir {
	@Autowired
	private BibliotecaServiceExclusao excluir;
	private Scanner sc = new Scanner(System.in);
	private int escolha = 0;
	
	public void menuExcluirLivro() {
		
		System.out.print("Digite o que deseja excluir"+"\n1- Livros"+"\n2- Revistas"+"\n-> ");
		
		try {
			escolha = sc.nextInt();
			sc.nextLine();
		}catch(InputMismatchException e) {
			sc.nextLine();
		}
		
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