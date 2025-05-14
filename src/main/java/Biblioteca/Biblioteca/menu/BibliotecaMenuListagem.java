package Biblioteca.Biblioteca.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Biblioteca.Biblioteca.service.listagem.BibliotecaServiceListagem;

@Service
public class BibliotecaMenuListagem {
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private BibliotecaServiceListagem listar;
	private int escolha = 0;
	public void menuListagem() {
		System.out.print("Digite o que deseja exibir"+"\n1- Exibir todos os autores"+"\n2- Exibir todos os livros"+"\n3- Exibir todos os autores com livros vinculados"+
	"\n4- Filtrar e exibir livros por Titulo"+"\n5- Filtrar e exibir livros por Genero"+"\n6- Filtrar e exibir livros por sobrenome do autor"+
				"\n7- Exibir revistas"+"\n8- Exibir artigos"+"\n9- Filtrar e exibir revistas por nome ou sobrenome dos autores"+"\n10- Filtrar revistas por titulo"
	+"\n-> ");

		
		try {
			escolha = sc.nextInt();
			sc.nextLine();
		}catch(InputMismatchException e) {
			sc.nextLine();
		}
		
		this.linha();
		switch(escolha) {
		case 1:
			listar.listarAutores();
			this.linha();
			break;
		case 2:
			listar.listarLivros();
			this.linha();
			break;
		case 3:
			listar.listarLivrosVinculadosNoAutor();
			this.linha();
			break;
		case 4:
			listar.listarLivroPorTitulo();
			this.linha();
			break;
		case 5:
			listar.listarLivroPorGenero();
			this.linha();
			break;
		case 6:
			listar.listarAutorPorNomeSobrenome();
			this.linha();
			break;
		case 7:
			listar.listarRevistas();
			this.linha();
			break;
		case 8:
			listar.listarArtigos();
			this.linha();
			break;
		case 9:
			listar.listarRevistasPorSobreNomeDoAutor();//faz o filtro verificando quais revistas tem artigos vinculados a um autor, ou seja, se a revista tem 3 artigos de 3 autores diferentes, vai exibir a revista e os autores
			this.linha();
			break;
		case 10:
			listar.listarPorTituloDaRevista();
			this.linha();
			break;
		default:
			System.out.println("Numero invalido");
		}
	}
	
	public void linha() {
		System.out.println("-------------------------------------------------------------------------------------");
	}
}